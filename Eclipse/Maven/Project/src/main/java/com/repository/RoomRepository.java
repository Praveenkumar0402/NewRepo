package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entities.Room;

//to perform CRUD operations
public interface RoomRepository extends JpaRepository<Room, Integer> {

	// get by roomtypes
	@Query("from Room where roomtype=:roomtype")
	List<Room> getRoomTyp(String roomtype);

	// find by roomtype,bedtype and roomstatus available or occupied
	@Query("from Room where roomstatus=:roomstatus and roomtype=:roomtype and bedtype=:bedtype")
	List<Room> findByRooms(String roomstatus, String roomtype, String bedtype);

	// find the roomtype,bedtype and Available rooms from date to date
	@Query(value = "select count(*) from rooms r where r.roomstatus='Available' and r.roomtype=:roomtype and bedtype=:bedtype and "
			+ "not EXISTS (select * from upcomingbookings b where upstartdate between :startdate and :enddate)", nativeQuery = true)
	int getavailable(@Param("roomtype") String roomtype, @Param("bedtype") String bedtype,
			@Param("startdate") String startdate, @Param("enddate") String enddate);

}
