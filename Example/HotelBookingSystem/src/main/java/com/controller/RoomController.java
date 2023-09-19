package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.entities.Room;
import com.repository.RoomRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController // create RESTful web services using Spring MVC
public class RoomController {

	@Autowired // inject the bean automatically
	RoomRepository rr;

	@Operation(summary = "Retrieves all room details")
	@GetMapping("/allrooms")
	public List<Room> getrooms() {
		return rr.findAll();
	}

	@Operation(summary = "Giving a roomtype", description = "Retrieving the all details in the given type")
	@GetMapping("/room/{roomtype}")
	public List<Room> getroomtype(@PathVariable("roomtype") String roomtype) {
		return rr.getRoomTyp(roomtype);
	}

	@Operation(summary = "Giving a Roomdetails", description = "To retrieving the all details of roomstatus and roomtype and bedtype")
	@GetMapping("/type/{roomstatus}/{roomtype}/{bedtype}")
	public List<Room> getroomstatus(@PathVariable("roomstatus") String roomstatus,
			@PathVariable("roomtype") String roomtype, @PathVariable("bedtype") String bedtype) {
		return rr.findByRooms(roomstatus, roomtype, bedtype);
	}

	@Operation(summary = "Updating the roomstatus", description = "Given a roomnumber and update the roomstatus")
	@PutMapping("/update/{roomnumber}/{roomstatus}")
	public Room update(@PathVariable("roomnumber") int roomnumber, @PathVariable("roomstatus") String roomstatus) {
		var rn = rr.findById(roomnumber);
		if (rn.isPresent()) {
			var t = rn.get();
			t.setRoomstatus(roomstatus);
			rr.save(t);
			return t;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "roomnumber Not Found");
	}

	@Operation(summary = "Availability of rooms", description = "Giving a roomtype,bedtype,startdate and enddate based on the requirement it will display count or rooms")
	@GetMapping("/givendates/{roomtype}/{bedtype}/{startdate}/{enddate}")
	public String givendates(@PathVariable("roomtype") String roomtype, @PathVariable("bedtype") String bedtype,
			@PathVariable("startdate") String startdate, @PathVariable("enddate") String enddate) {
		int num = rr.getavailable(roomtype, bedtype, startdate, enddate);
		return "Available  " + num;
	}

}
