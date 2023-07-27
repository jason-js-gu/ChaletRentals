package com.algonquin.chaletrentals.dao;

import java.util.List;
import java.util.UUID;

import com.algonquin.chaletrentals.beans.Reservation;
import com.algonquin.chaletrentals.services.CrudService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ReservationDao implements CrudService<Reservation, UUID> {

	@Override
	public List<Reservation> getAll() {
		List<Reservation> reservations = new ArrayList<>();
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM reservation ORDER BY booked_at DESC")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                	Reservation reservation = new Reservation();
                	reservation.setReservationID(UUID.fromString(rs.getString("reservationID")));
                	reservation.setCheckin(rs.getTimestamp("checkin").toInstant());
                	reservation.setCheckout(rs.getTimestamp("checkout").toInstant());
                	reservation.setBookedAt(rs.getTimestamp("booked_at").toInstant());
                	reservation.setTotalPrice(rs.getDouble("total_price"));
                	reservation.setChaletID(UUID.fromString(rs.getString("chaletID")));
                	reservation.setUserID(UUID.fromString(rs.getString("userID")));
                	reservations.add(reservation);
                }
                return reservations;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Reservation> getAll(UUID reservationID) {
		List<Reservation> reservations = new ArrayList<>();
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM reservation where reservationID<>? ORDER BY booked_at DESC")) {
			stmt.setString(1, reservationID.toString());
			try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                	Reservation reservation = new Reservation();
                	reservation.setReservationID(UUID.fromString(rs.getString("reservationID")));
                	reservation.setCheckin(rs.getTimestamp("checkin").toInstant());
                	reservation.setCheckout(rs.getTimestamp("checkout").toInstant());
                	reservation.setBookedAt(rs.getTimestamp("booked_at").toInstant());
                	reservation.setTotalPrice(rs.getDouble("total_price"));
                	reservation.setChaletID(UUID.fromString(rs.getString("chaletID")));
                	reservation.setUserID(UUID.fromString(rs.getString("userID")));
                	reservations.add(reservation);
                }
                return reservations;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Reservation select(UUID reservationID) {
		Reservation r = new Reservation();
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM reservation WHERE reservationID = ?")) {
			stmt.setString(1, reservationID.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                	r.setReservationID(UUID.fromString(rs.getString("reservationID")));
                	r.setCheckin(rs.getTimestamp("checkin").toInstant());
                	r.setCheckout(rs.getTimestamp("checkout").toInstant());
                	r.setBookedAt(rs.getTimestamp("booked_at").toInstant());
                	r.setTotalPrice(rs.getDouble("total_price"));
                	r.setChaletID(UUID.fromString(rs.getString("chaletID")));
                	r.setUserID(UUID.fromString(rs.getString("userID")));
                }
                return r;
            }
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<Reservation> filterUser(UUID id){
		List<Reservation> reservations = new ArrayList<>();		
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM reservation WHERE userID = ?")) {
			stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                	Reservation reservation = new Reservation();
                	reservation.setReservationID(UUID.fromString(rs.getString("reservationID")));
                	reservation.setCheckin(rs.getTimestamp("checkin").toInstant());
                	reservation.setCheckout(rs.getTimestamp("checkout").toInstant());
                	reservation.setBookedAt(rs.getTimestamp("booked_at").toInstant());
                	reservation.setTotalPrice(rs.getDouble("total_price"));
                	reservation.setChaletID(UUID.fromString(rs.getString("chaletID")));
                	reservation.setUserID(UUID.fromString(rs.getString("userID")));
                	reservations.add(reservation);
                }
                return reservations;
              }		
            } catch (SQLException e) {
    			e.printStackTrace();
    			return null;
    		}
	}
	
	
	public List<Reservation> filterChalet(UUID id){
		List<Reservation> reservations = new ArrayList<>();		
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM reservation WHERE chaletID = ?")) {
			stmt.setString(1, id.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                	Reservation reservation = new Reservation();
                	reservation.setReservationID(UUID.fromString(rs.getString("reservationID")));
                	reservation.setCheckin(rs.getTimestamp("checkin").toInstant());
                	reservation.setCheckout(rs.getTimestamp("checkout").toInstant());
                	reservation.setBookedAt(rs.getTimestamp("booked_at").toInstant());
                	reservation.setTotalPrice(rs.getDouble("total_price"));
                	reservation.setChaletID(UUID.fromString(rs.getString("chaletID")));
                	reservation.setUserID(UUID.fromString(rs.getString("userID")));
                	reservations.add(reservation);
                }
                return reservations;
              }		
            } catch (SQLException e) {
    			e.printStackTrace();
    			return null;
    		}
	}

	@Override
	public boolean create(Reservation reservation) {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"INSERT INTO reservation VALUES (?, ?, ?, ?, ?, ?, ?)")) {
			stmt.setString(1, String.valueOf(reservation.getReservationID()));
			stmt.setTimestamp(2, Timestamp.from(reservation.getCheckin()));
			stmt.setTimestamp(3, Timestamp.from(reservation.getCheckout()));
			stmt.setTimestamp(4, Timestamp.from(reservation.getBookedAt()));
			stmt.setDouble(5, reservation.getTotalPrice());
			stmt.setString(6, String.valueOf(reservation.getChaletID()));
			stmt.setString(7, String.valueOf(reservation.getUserID()));
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Reservation reservation) {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"UPDATE reservation SET checkin=?, checkout=?, total_price=?, chaletID=?"
                		+ "WHERE reservationID=?")) {
			stmt.setTimestamp(1, Timestamp.from(reservation.getCheckin()));
			stmt.setTimestamp(2, Timestamp.from(reservation.getCheckout()));
			stmt.setDouble(3, reservation.getTotalPrice());
			stmt.setString(4, String.valueOf(reservation.getChaletID()));
			stmt.setString(5, String.valueOf(reservation.getReservationID()));
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(UUID reservationID) {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"DELETE FROM reservation WHERE reservationID=?")) {
			stmt.setString(1, String.valueOf(reservationID));
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}		
	}

}
