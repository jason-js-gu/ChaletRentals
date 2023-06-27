package com.algonquin.chaletrentals.beans;

import java.time.Instant;
import java.util.UUID;

public class Reservation {
	private UUID reservationID;
	private Instant checkin;
	private Instant checkout;
	private double totalPrice;	
}
