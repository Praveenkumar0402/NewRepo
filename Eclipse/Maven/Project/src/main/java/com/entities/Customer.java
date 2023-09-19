package com.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Customer entity mapped to a customers table
@Entity
@Table(name = "customers")
public class Customer {

	@Id // specifies the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private String email;
	private String mobile;
	private String gender;

	// Mapping to BookingHistory
	@OneToMany(mappedBy = "customers")
	@JsonIgnore // To avoid infinity recursions
	List<BookingHistory> bookinghistories;

	// Mapping to UpcomingBooking
	@OneToMany
	@JsonIgnore // To avoid infinity recursions
	List<UpcomingBooking> upcomingbooking;

	// Getters and Setters
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<BookingHistory> getBookinghistories() {
		return bookinghistories;
	}

	public void setBookinghistories(List<BookingHistory> bookinghistories) {
		this.bookinghistories = bookinghistories;
	}

	public List<UpcomingBooking> getUpcomingbooking() {
		return upcomingbooking;
	}

	public void setUpcomingbooking(List<UpcomingBooking> upcomingbooking) {
		this.upcomingbooking = upcomingbooking;
	}

	// hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(bookinghistories, cid, cname, email, gender, mobile, upcomingbooking);
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
		Customer other = (Customer) obj;
		return Objects.equals(bookinghistories, other.bookinghistories) && Objects.equals(cid, other.cid)
				&& Objects.equals(cname, other.cname) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(upcomingbooking, other.upcomingbooking);
	}

	// toString method
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + ", bookinghistories=" + bookinghistories + ", upcomingbooking=" + upcomingbooking + "]";
	}

}
