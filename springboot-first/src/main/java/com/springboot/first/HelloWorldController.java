package com.springboot.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController is equivalent to @Controller and @ResponseBody
@RestController
public class HelloWorldController {

	//@GetMapping annotation server Get http method
	//http://localhost:8080/hello-world
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
}
