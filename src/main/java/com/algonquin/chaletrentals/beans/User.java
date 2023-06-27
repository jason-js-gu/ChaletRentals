package com.algonquin.chaletrentals.beans;

import java.util.UUID;

public class User {
	private UUID userID;
	private String username;
	private String password;
	private String email;
	private boolean isChaletOwner;
	private boolean isAdmin;
	
	public User(UUID userID, String username, 
			String password, String email,
			boolean isChaletOwner, boolean isAdmin) {		
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;	
		this.isChaletOwner = isChaletOwner;
		this.isAdmin = isAdmin;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
