package com.example.SpringDay27;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	// @GetMapping("/hello")
	public String hello() {
		return "Hello Rest";
	}

	@GetMapping("/hello/{user}")
	public String hello(@PathVariable("user") String user) {
		return "Hello " + user + "";
	}

}
