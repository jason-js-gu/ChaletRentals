package com.algonquin.chaletrentals.beans;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class Chalet {
	private UUID chaletID;
	private String name;
	private String address;
	private String description;
	private List<String> photos;
	private double price;	
	private UUID userID;
	private Instant createdAt;
	
	private List<Reservation> reservations;
		

	public UUID getChaletID() {
		return chaletID;
	}
	public void setChaletID(UUID chaletID) {
		this.chaletID = chaletID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getPhotos() {
		return photos;
	}
	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public UUID getUserID() {
		return userID;
	}
	public void setUserID(UUID userID) {
		this.userID = userID;
	}
	
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public Chalet() {
		this.chaletID = null;
		this.name = null;
		this.address = null;
		this.description = null;
		this.photos = null;
		this.price = 0;
		this.userID = null;
		this.createdAt = Instant.now();		
	}
		
	public Chalet(String name, String address, 
			String description, List<String> photos, double price, UUID userID) {		
		this();
		this.chaletID = UUID.randomUUID();
		this.name = name;
		this.address = address;
		this.description = description;
		this.photos = photos;
		this.price = price;
		this.userID = userID;
	}
	
	
	public Chalet(UUID chaletID, String name, String address, 
			String description, List<String> photos, double price, UUID userID) {		
		this.chaletID = chaletID;
		this.name = name;
		this.address = address;
		this.description = description;
		this.photos = photos;
		this.price = price;
		this.userID = userID;
	}
	
	public synchronized boolean isAvailable(Reservation newReservation) {
		for(Reservation r: reservations) {
			if(r.isOverlapping(newReservation)) {
				return false;
			}
		}
		return true;
	}
	
	public synchronized void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	
	public List<Reservation> getReservations(){
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations){
		this.reservations = reservations;
	}
}
