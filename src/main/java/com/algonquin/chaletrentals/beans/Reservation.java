package com.algonquin.chaletrentals.beans;

import java.time.Instant;
import java.util.UUID;

public class Reservation {
	private UUID reservationID;
	private Instant checkin;
	private Instant checkout;
	private Instant bookedAt;
	private double totalPrice;
	private UUID userID;
	private UUID chaletID;
	
	public UUID getReservationID() {
		return reservationID;
	}
	public void setReservationID(UUID reservationID) {
		this.reservationID = reservationID;
	}
	public Instant getCheckin() {
		return checkin;
	}
	public void setCheckin(Instant checkin) {
		this.checkin = checkin;
	}
	public Instant getCheckout() {
		return checkout;
	}
	public void setCheckout(Instant checkout) {
		this.checkout = checkout;
	}
	public Instant getBookedAt() {
		return bookedAt;
	}
	public void setBookedAt(Instant bookedAt) {
		this.bookedAt = bookedAt;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public UUID getUserID() {
		return userID;
	}
	public void setUserID(UUID userID) {
		this.userID = userID;
	}
	public UUID getChaletID() {
		return chaletID;
	}
	public void setChaletID(UUID chaletID) {
		this.chaletID = chaletID;
	}
	
	public Reservation() {		
		this.reservationID = null;
		this.checkin = null;
		this.checkout = null;
		this.bookedAt = Instant.now();
		this.totalPrice = 0;
		this.userID = null;
		this.chaletID = null;
	}
	
	public Reservation(Instant checkin, Instant checkout, double totalPrice,
			UUID userID, UUID chaletID) {
		this();
		this.reservationID = UUID.randomUUID();
		this.checkin = checkin;
		this.checkout = checkout;		
		this.totalPrice = totalPrice;
		this.userID = userID;
		this.chaletID = chaletID;
	}
	
	public Reservation(UUID reservationID, Instant checkin, Instant checkout, double totalPrice,
			UUID userID, UUID chaletID) {
		this();
		this.reservationID = reservationID;
		this.checkin = checkin;
		this.checkout = checkout;		
		this.totalPrice = totalPrice;
		this.userID = userID;
		this.chaletID = chaletID;
	}
	
	
	public boolean isOverlapping(Reservation otherReservation) {
		return this.checkin.isBefore(otherReservation.getCheckout()) 
				&& otherReservation.getCheckin().isBefore(this.checkout);
	}
}
