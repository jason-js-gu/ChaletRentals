package com.algonquin.chaletrentals.services;

import java.util.List;
import java.util.UUID;

import com.algonquin.chaletrentals.beans.Chalet;
import com.algonquin.chaletrentals.beans.Reservation;
import com.algonquin.chaletrentals.beans.User;

public interface CrudService<T, U>{
	public List<T> getAll();
	public T select(U u);
	public void create();
	public void update(T t);
	public void delete(U u);
}