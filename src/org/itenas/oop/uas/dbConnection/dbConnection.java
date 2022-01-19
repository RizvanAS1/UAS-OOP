package org.itenas.oop.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbConnection {
	//URL Database
	static final String DB_URL = "jdbc:mysql://localhost/uasoop";
	String user = "root";
	String password = "basdat2020";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	//Method
	public void connect() {
		try {
			connection = DriverManager.getConnection(DB_URL, user, password);
			System.out.println("Koneksi ke database berhasil....!");
		} catch (Exception e) {
			System.out.println("Terjadi Error: " +e.getMessage());
		}
	}
		
	public void disconnect() {
		try {
			connection.close();
			statement.close();
			resultset.close();
		} catch (Exception e) {
			System.out.println("Terjadi Error: " +e.getMessage());
		}
	}
		
	public ResultSet readData(String query) {
		try {
			statement = connection.createStatement();
				
			resultset = statement.executeQuery(query);
				
			return resultset;
		} catch (Exception e) {
			System.out.println("Terjadi Error: " +e.getMessage());
		}
		
		return resultset;
	}
		
	public void executeQuery(String query) {
		try {
			statement = connection.createStatement();
				
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Terjadi Error: " +e.getMessage());
		}
	}
}
