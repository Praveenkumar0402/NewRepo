package com.example.SpringDay27;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/localdatetime")
	public String dateTime() {
		LocalDateTime ltd = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss");
		// return date.format(ltd);
		return "<h1>" + date.format(ltd) + "</h1>";
	}

	@GetMapping("/fact/{i}")
	public int factorial(@PathVariable("i") int i) {
		int fact = 1;
		while (i > 0) {
			fact = fact * i;
			i--;
		}
		return fact;
	}
	

	@GetMapping("/hi")
	public String query(@RequestParam("user") String user) {
		return "<h1> Hi " + user + "</h1>";
	}
}
