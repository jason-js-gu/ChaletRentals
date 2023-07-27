package com.algonquin.chaletrentals.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import com.algonquin.chaletrentals.beans.Chalet;
import com.algonquin.chaletrentals.services.CrudService;

public class ChaletDao implements CrudService<Chalet, UUID> {
	
	@Override
	public boolean create(Chalet chalet) {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"INSERT INTO chalet VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
			//get all urls of photos and convert them into a string
			List<String> photos = chalet.getPhotos();
			StringBuilder sb = new StringBuilder();
			int num_photos = photos.size();

			for(int i=0; i<num_photos; i++) {
				sb.append(photos.get(i));
				if(i < num_photos - 1) {
					sb.append(",");
				}
			}

			stmt.setString(1, String.valueOf(chalet.getChaletID()));
			stmt.setString(2, chalet.getName());
			stmt.setString(3, chalet.getAddress());
			stmt.setString(4, chalet.getDescription());
			stmt.setString(5, sb.toString());
			stmt.setDouble(6, chalet.getPrice());
			stmt.setString(7, String.valueOf(chalet.getUserID()));
			stmt.setTimestamp(8, Timestamp.from(chalet.getCreatedAt()));
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean update(Chalet chalet) {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"UPDATE chalet SET name=?, address=?, description=?, photos=?, price=? WHERE chaletID = ?")) {
			//get all urls of photos and convert them into a string
			List<String> photos = chalet.getPhotos();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<photos.size(); i++) {
				sb.append(photos.get(i));
				if(i < photos.size() - 1) {
					sb.append(",");
				}
			}			
			stmt.setString(1, chalet.getName());
			stmt.setString(2, chalet.getAddress());
			stmt.setString(3, chalet.getDescription());
			stmt.setString(4, sb.toString());
			stmt.setDouble(5, chalet.getPrice());			
			stmt.setString(6, String.valueOf(chalet.getChaletID()));
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(UUID chaletID) {
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"DELETE FROM chalet WHERE chaletID = ?")) {
			stmt.setString(1, String.valueOf(chaletID));
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Chalet> getAll() {
		List<Chalet> chalets = new ArrayList<Chalet>();
		
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM chalet ORDER BY created_at DESC")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Chalet chalet = new Chalet();
                    chalet.setChaletID(UUID.fromString(rs.getString("chaletID")));
                    chalet.setName(rs.getString("name"));
                    chalet.setAddress(rs.getString("address"));
                    chalet.setDescription(rs.getString("description"));
                    chalet.setPhotos(Arrays.asList(rs.getString("photos").split(",")));
                    chalet.setPrice(rs.getDouble("price"));
                    chalet.setUserID(UUID.fromString(rs.getString("userID")));
                    chalet.setCreatedAt(rs.getTimestamp("created_at").toInstant());
                    chalets.add(chalet);
                }
                return chalets;
            }
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Chalet select(UUID u) {
		Chalet chalet = null;
		try (Connection conn = DBConnection.getConnectionToDatabase();
                PreparedStatement stmt = conn.prepareStatement(
                		"SELECT * FROM chalet WHERE chaletID = ?")) {
			stmt.setString(1, u.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    chalet = new Chalet();
                    chalet.setChaletID(u);
                    chalet.setName(rs.getString("name"));
                    chalet.setAddress(rs.getString("address"));
                    chalet.setDescription(rs.getString("description"));
                    chalet.setPhotos(Arrays.asList(rs.getString("photos")));
                    chalet.setPrice(rs.getDouble("price"));
                    chalet.setUserID(UUID.fromString(rs.getString("userID")));
                }                
            }
		} catch (SQLException e) {			
			e.printStackTrace();			
		}
		return chalet;
	}
}
