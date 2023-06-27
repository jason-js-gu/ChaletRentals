package com.algonquin.chaletrentals.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String dbURL = "jdbc:mysql://localhost:3306/chaletrentals";
    private static final String dbUser = "root";
    private static final String dbPassword = "MysqlGu2023Cg!";
    

    public static Connection getConnectionToDatabase(){
        Connection connection = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        }catch(SQLException e) {
        	e.printStackTrace();
        }catch(ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return connection;
    }
}
