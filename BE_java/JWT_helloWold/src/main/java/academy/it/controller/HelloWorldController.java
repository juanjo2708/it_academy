package academy.it.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

	@GetMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="world") String name) {
		return "hello "+name;
	}
	
	@GetMapping("admin")
	public String helloAdmin() {
		return "hello Admin";
	}
	
	
}
