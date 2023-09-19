package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Customer;
import com.repository.CustomerRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController // create RESTful web services using Spring MVC
public class CustomerController {

	@Autowired // inject the bean automatically
	CustomerRepository cr;

	@Operation(summary = "Retrieves all customers details")
	@GetMapping("/allcustomers")
	public List<Customer> getallcustomers() {
		return cr.findAll();
	}
}
