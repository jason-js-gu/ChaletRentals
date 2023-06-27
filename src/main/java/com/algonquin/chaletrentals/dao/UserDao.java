package com.algonquin.chaletrentals.dao;

import java.util.List;
import java.util.UUID;

import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.services.CrudService;

public class UserDao implements CrudService<User, UUID> {

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User select(UUID userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID userID) {
		// TODO Auto-generated method stub
		
	}

}
