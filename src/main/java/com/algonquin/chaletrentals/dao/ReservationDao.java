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
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID reservationID) {
		// TODO Auto-generated method stub
		
	}

}
