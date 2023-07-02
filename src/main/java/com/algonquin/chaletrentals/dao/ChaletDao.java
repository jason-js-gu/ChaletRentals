package com.algonquin.chaletrentals.dao;

import java.util.List;
import java.util.UUID;

import com.algonquin.chaletrentals.beans.Chalet;
import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.services.CrudService;

public class ChaletDao implements CrudService<Chalet, UUID> {
	
	@Override
	public boolean create(Chalet chalet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Chalet chalet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UUID chaletID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Chalet> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chalet select(UUID u) {
		// TODO Auto-generated method stub
		return null;
	}

}
