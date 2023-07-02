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
                		"SELECT * FROM users")) {
               try (ResultSet rs = stmt.executeQuery()) {
                   while (rs.next()) {
                       User user = new User();
                       user.setUserID(UUID.fromString(rs.getString("uuid")));
                       user.setUsername(rs.getString("username"));
                       user.setPassword(rs.getString("password"));
                       user.setEmail(rs.getString("email"));
                       user.setChaletOwner(Boolean.valueOf(rs.getString("ischaletowner")));
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
		User user = null;
//		String uuid = request.getParameter("")
//		try (Connection conn = DBConnection.getConnectionToDatabase();
//                PreparedStatement stmt = conn.prepareStatement(
//                		"INSERT INTO ? (uuid, username, password, email, ischaletowner) VALUES (?,?,?,?,?)")) {
//        		stmt.setString(1, TABLENAME);
//        		stmt.setString(2,)
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return user;
	}

	@Override
	public boolean create(User user){				
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"INSERT INTO users VALUES (?,?,?,?,?,?)")) {
        		//stmt.setString(1, TABLENAME);
        		stmt.setString(1, String.valueOf(user.getUserID()));
        		stmt.setString(2, user.getUsername());
        		stmt.setString(3, user.getPassword());
        		stmt.setString(4, user.getEmail());
        		stmt.setString(5, String.valueOf(user.isChaletOwner()));
        		stmt.setString(6, user.getTelephone());
        		return stmt.executeUpdate()>0;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean update(User user) {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"UPDATE users SET username=?,password=?,email=?,ischaletowner=?,telephone=? WHERE uuid = ?")) { 
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, String.valueOf(user.isChaletOwner()));
			stmt.setString(5, user.getTelephone());
			stmt.setString(6, String.valueOf(user.getUserID()));
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(UUID userID) {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"DELETE FROM users WHERE uuid = ?")) { 
			stmt.setString(1, String.valueOf(userID));			
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}		
	}
	
	public User select(String email, String password) {
		User user = null;
        try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM users WHERE email = ? AND password = ?")) {    		          	
               stmt.setString(1, email);
               stmt.setString(2, password);
               try (ResultSet rs = stmt.executeQuery()) {
                   if (rs.next()) {
                       user = new User();
                       user.setUserID(UUID.fromString(rs.getString("uuid")));
                       user.setUsername(rs.getString("username"));
                       user.setPassword(password);
                       user.setEmail(email);
                       user.setChaletOwner(Boolean.valueOf(rs.getString("ischaletowner")));
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
                		"SELECT * FROM users WHERE email = ?")) {              
        		stmt.setString(1, email);
               try (ResultSet rs = stmt.executeQuery()) {
                   if (rs.next()) {
                       user = new User();
                       user.setUserID(UUID.fromString(rs.getString("uuid")));
                       user.setUsername(rs.getString("username"));
                       user.setPassword(rs.getString("password"));
                       user.setEmail(email);
                       user.setChaletOwner(Boolean.valueOf(rs.getString("ischaletowner")));
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
                		"UPDATE users SET password= ? WHERE email = ?")) {    			
				stmt.setString(1, password);
				stmt.setString(2, email);
				return stmt.executeUpdate() > 0;
		}
	}

}
