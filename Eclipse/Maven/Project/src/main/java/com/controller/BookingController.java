    package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.entities.BookingHistory;
import com.repository.BookingHistoryRepository;
import com.repository.RoomRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController // create RESTful web services using Spring MVC
public class BookingController {

	@Autowired // inject the bean automatically
	BookingHistoryRepository bhr;

	@Autowired // inject the bean automatically
	RoomRepository rr;

	@Operation(summary = "Get Bookinghistory by id", description = "Given a id and it retrieves details of Booking history")
	@GetMapping("/history/{cid}")
	public List<BookingHistory> gethistory(@PathVariable("cid") int cid) {
		return bhr.findByCid(cid);
	}

	@Operation(summary = "Inserting a row in bookinghistories", description = "Inserting the required data in bookinghistories table")
	@PostMapping("/insert")
	public BookingHistory insertbookhistory(@RequestBody BookingHistory bookhistory) {
		bhr.save(bookhistory);
		return bookhistory;
	}

	@Operation(summary = "Inserting and Updating", description = "Given a roomnumber and updates roomstatus and inserting a row in bookinghistories")
	@PostMapping("/checkout/{roomnumber}/{roomstatus}")
	public BookingHistory handle(@PathVariable("roomnumber") int roomnumber, @RequestBody BookingHistory bookhistory,
			@PathVariable("roomstatus") String roomstatus) {
		var r = rr.findById(roomnumber);
		if (r.isPresent()) {
			var room = r.get();
			room.setRoomstatus(roomstatus);
			rr.save(room);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "roomnumber Not Found");
		}
		bhr.save(bookhistory);
		return bookhistory;
	}

}
