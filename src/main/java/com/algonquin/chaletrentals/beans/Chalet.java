package com.algonquin.chaletrentals.beans;

import java.util.UUID;

public class Chalet {
	private UUID chaletID;
	private String name;
	private String address;
	private String description;
	private double price;	
		
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
		
	public Chalet(UUID chaletID, String name, String address, 
			String description, double price) {		
		this.chaletID = chaletID;
		this.name = name;
		this.address = address;
		this.description = description;
		this.price = price;
	}
}
