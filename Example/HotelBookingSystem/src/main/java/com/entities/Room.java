package com.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Room entity mapped to a rooms table
@Entity
@Table(name = "rooms")
public class Room {

	@Id // specifies the primary key of the entity
	private int roomnumber;
	private int floor;
	private String roomtype;
	private String bedtype;
	private Double tariff;
	private String roomstatus;

	// Mapping to BookingHistory
	@OneToMany(mappedBy = "rooms")
	@JsonIgnore // To avoid infinity recursions
	List<BookingHistory> bookinghistory;

	// Getters and Setters
	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	public Double getTariff() {
		return tariff;
	}

	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

	public List<BookingHistory> getBookinghistory() {
		return bookinghistory;
	}

	public void setBookinghistory(List<BookingHistory> bookinghistory) {
		this.bookinghistory = bookinghistory;
	}

	// hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(bedtype, bookinghistory, floor, roomnumber, roomstatus, roomtype, tariff);
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
		Room other = (Room) obj;
		return Objects.equals(bedtype, other.bedtype) && Objects.equals(bookinghistory, other.bookinghistory)
				&& floor == other.floor && Objects.equals(roomnumber, other.roomnumber)
				&& Objects.equals(roomstatus, other.roomstatus) && Objects.equals(roomtype, other.roomtype)
				&& Objects.equals(tariff, other.tariff);
	}

	// toString method
	@Override
	public String toString() {
		return "Room [roomnumber=" + roomnumber + ", floor=" + floor + ", roomtype=" + roomtype + ", bedtype=" + bedtype
				+ ", tariff=" + tariff + ", roomstatus=" + roomstatus + ", bookinghistory=" + bookinghistory + "]";
	}

}
