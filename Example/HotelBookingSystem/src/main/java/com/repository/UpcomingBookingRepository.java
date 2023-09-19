package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.entities.UpcomingBooking;

//to perform CRUD operations

public interface UpcomingBookingRepository extends JpaRepository<UpcomingBooking, Integer> {

	// find by customerid to get all details
	List<UpcomingBooking> getByCid(int cid);
}
