package com.algonquin.chaletrentals.beans;

import java.util.UUID;

public class Role {
	private UUID roleID;
	private String title;
	
	public Role(UUID roleID, String title) {		
		this.roleID = roleID;
		this.title = title;
	}

	public UUID getRoleID() {
		return roleID;
	}

	public void setRoleID(UUID roleID) {
		this.roleID = roleID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
