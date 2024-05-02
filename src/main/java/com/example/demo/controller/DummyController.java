
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Hi";
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/bye")
	public String sayBye() {
		return "Bye";
	}
	
	@GetMapping("/openApi")
	public String openApi() {
		return "This is open API";
	}
	
	@GetMapping("/noAccess")
	public String noAccess() {
		return "you can not access";
	}

}

