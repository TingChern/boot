package tw.freely.structure.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public interface Controller {
	public Object post(String... pk);
	public Object get(String pk);
	public Object put(String pk);
	public Object delete(String pk);
	public Object patch(String... pk);
}
