package com.algonquin.chaletrentals.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import com.algonquin.chaletrentals.beans.User;
import com.algonquin.chaletrentals.services.CrudService;


public class UserDao implements CrudService<User, UUID> {

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
        try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM chaletrentals")) {
               try (ResultSet rs = stmt.executeQuery()) {
                   while (rs.next()) {
                       User user = new User();
                       user.setUserID(UUID.fromString(rs.getString("uuid")));
                       user.setUsername(rs.getString("username"));
                       user.setPassword(rs.getString("password"));
                       user.setEmail(rs.getString("email"));
                       user.setChaletOwner(Boolean.valueOf(rs.getString("chaletowner")));
                       user.setTelephone(rs.getString("telephone"));
                       users.add(user);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return users;
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
	
	public User select(String username, String password) {
		User user = null;
        try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM chaletrentals WHERE username = ? AND password = ?")) {
               stmt.setString(1, username);
               stmt.setString(2, password);
               try (ResultSet rs = stmt.executeQuery()) {
                   if (rs.next()) {
                       user = new User();
                       user.setUserID(UUID.fromString(rs.getString("uuid")));
                       user.setUsername(username);
                       user.setPassword(password);
                       user.setEmail(rs.getString("email"));
                       user.setChaletOwner(Boolean.valueOf(rs.getString("chaletowner")));
                       user.setTelephone(rs.getString("telephone"));
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return user;
	}
	
	public User select(String email) {
		User user = null;
        try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM chaletrentals WHERE email = ?")) {
               stmt.setString(1, email);
               try (ResultSet rs = stmt.executeQuery()) {
                   if (rs.next()) {
                       user = new User();
                       user.setUserID(UUID.fromString(rs.getString("uuid")));
                       user.setUsername(rs.getString("username"));
                       user.setPassword(rs.getString("password"));
                       user.setEmail(email);
                       user.setChaletOwner(Boolean.valueOf(rs.getString("chaletowner")));
                       user.setTelephone(rs.getString("telephone"));
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return user;
	}
	
	public boolean update(String email, String password) throws SQLException {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"UPDATE chaletrentals SET password= ? WHERE email = ?")) {
				stmt.setString(1, password);
				stmt.setString(2, email);
				return stmt.executeUpdate() > 0;
		}
	}

}
