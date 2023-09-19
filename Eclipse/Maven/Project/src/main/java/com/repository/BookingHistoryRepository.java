package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.entities.BookingHistory;

//to perform CRUD operations
public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Integer> {

	// find by customerid to get all details
	List<BookingHistory> findByCid(int cid);

}
