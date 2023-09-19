package com.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//BookingHistory entity mapped to a bookinghistories table
@Entity
@Table(name = "bookinghistories")
public class BookingHistory {

	@Id // specifies the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;
	private String startdate;
	private String enddate;
	private int cid;
	private int roomnumber;

	// Mapping to Customer and using joincolumn 'cid'
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", insertable = false, updatable = false)
	@JsonIgnore
	private Customer customers;

	// Mapping to Room and using joincolumn 'roomnumber'
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomnumber", insertable = false, updatable = false)
	@JsonIgnore
	private Room rooms;

	// Getters and Setters
	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public Room getRooms() {
		return rooms;
	}

	public void setRooms(Room rooms) {
		this.rooms = rooms;
	}

	// hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(bookingid, customers, enddate, cid, rooms, roomnumber, startdate);
	}

	// equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingHistory other = (BookingHistory) obj;
		return bookingid == other.bookingid && Objects.equals(customers, other.customers)
				&& Objects.equals(enddate, other.enddate) && cid == other.cid && Objects.equals(rooms, other.rooms)
				&& roomnumber == other.roomnumber && Objects.equals(startdate, other.startdate);
	}

	// toString method
	@Override
	public String toString() {
		return "BookingHistory [bookingid=" + bookingid + ", startdate=" + startdate + ", enddate=" + enddate + ", cid="
				+ cid + ", roomnumber=" + roomnumber + ", customers=" + customers + ", rooms=" + rooms + "]";
	}

}
