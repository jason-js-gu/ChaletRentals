package com.algonquin.chaletrentals.beans;

import java.util.UUID;

public class User {
	private UUID userID;
	private String username;
	private String password;
	private String email;
	private boolean isChaletOwner = false;
	private String telephone;
	
	public User() {		
		this.userID = null;
		this.username = null;
		this.password = null;
		this.email = null;
		this.telephone = null;
	}
	
	public User(String username, 
			String password, String email, String telephone) {		
		this.userID = UUID.randomUUID();
		this.username = username;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
	}

	public UUID getUserID() {
		return userID;
	}

	public void setUserID(UUID userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isChaletOwner() {
		return isChaletOwner;
	}

	public void setChaletOwner(boolean isChaletOwner) {
		this.isChaletOwner = isChaletOwner;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
