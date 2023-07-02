package com.algonquin.chaletrentals.dao;

import java.util.List;
import java.util.UUID;

import com.algonquin.chaletrentals.beans.Reservation;
import com.algonquin.chaletrentals.services.CrudService;

public class ReservationDao implements CrudService<Reservation, UUID> {

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation select(UUID reservationID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Reservation res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation reservation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UUID reservationID) {
		// TODO Auto-generated method stub
		return false;
	}

}
