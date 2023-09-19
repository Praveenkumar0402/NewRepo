package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.entities.UpcomingBooking;
import com.repository.UpcomingBookingRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController // create RESTful web services using Spring MVC
public class UpcomingController {

	@Autowired // inject the bean automatically
	UpcomingBookingRepository ubr;

	@Operation(summary = "Retrieving all the upcomingbooking details")
	@GetMapping("/upcomingbookings")
	public List<UpcomingBooking> getallbookings() {
		return ubr.findAll();
	}

	@Operation(summary = "Customerid details", description = "Given the customerid and retrive the all details")
	@GetMapping("/single/{cid}")
	public List<UpcomingBooking> getsingleid(@PathVariable("cid") int cid) {
		return ubr.getByCid(cid);

	}

}
