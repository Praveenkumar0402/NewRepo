package com.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//UpcomingBooking entity mapped to a upcomingbookings table
@Entity
@Table(name = "upcomingbookings")
public class UpcomingBooking {

	@Id // specifies the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int upbid;
	private int cid;
	private String upstartdate;
	private String roomtype;
	private String bedtype;
	private int noofrooms;

	// Getters and Setters
	public int getUpbid() {
		return upbid;
	}

	public void setUpbid(int upbid) {
		this.upbid = upbid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getUpstartdate() {
		return upstartdate;
	}

	public void setUpstartdate(String upstartdate) {
		this.upstartdate = upstartdate;
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

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}

	// hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(bedtype, cid, noofrooms, roomtype, upbid, upstartdate);
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
		UpcomingBooking other = (UpcomingBooking) obj;
		return Objects.equals(bedtype, other.bedtype) && cid == other.cid && noofrooms == other.noofrooms
				&& Objects.equals(roomtype, other.roomtype) && upbid == other.upbid
				&& Objects.equals(upstartdate, other.upstartdate);
	}

	// toString method
	@Override
	public String toString() {
		return "UpcomingBooking [upbid=" + upbid + ", cid=" + cid + ", upstartdate=" + upstartdate + ", roomtype="
				+ roomtype + ", bedtype=" + bedtype + ", noofrooms=" + noofrooms + "]";
	}

}
