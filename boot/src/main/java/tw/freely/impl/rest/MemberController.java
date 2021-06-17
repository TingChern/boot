package tw.freely.impl.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.freely.impl.model.Member;

@RestController
@RequestMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
public class MemberController {

	private static Map<Integer,Member> members = new HashMap<>();

	static {
		members.put(1, new Member(1, "Apple"));
		members.put(2, new Member(2, "Orange"));
	}

	@GetMapping("/{id}")
	public Member get(@PathVariable("id") String id) {
		Optional<Member> optionalMember = Optional.of(members.get(Integer.parseInt(id)));
		return optionalMember.get();
	}

	@PostMapping()
	public Member post(@RequestBody Member newMember) {
		Integer key = members.keySet().stream().max(Integer::compare).get() + 1;
		newMember.setId(key);
		members.put(key, newMember);
		return newMember;
	}

	@PutMapping("/{id}")
	public Member put(@PathVariable("id") String id, @RequestBody Member member) {
		members.put(Optional.of(members.get(member.getId())).get().getId(), member);
		return Optional.of(members.get(Integer.parseInt(id))).get();
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") String id) {
		members.remove(Integer.parseInt(id));
		return id;
	}
//
//	@Override
//	public Object patch(String... pk) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
