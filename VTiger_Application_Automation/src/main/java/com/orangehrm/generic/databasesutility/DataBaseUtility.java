package com.orangehrm.generic.databasesutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtility {
	public Connection con;

	public void getDBConnection(String url, String username, String password) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getDBConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?username=root&password=6396");
			System.out.println("Connection Established Successfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			con.close();
			System.out.println("Connection Closed Successfully....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet rs = null;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int executeNonSelectQuery(String query) {
		int updatedRows = 0;
		try {
			Statement st = con.createStatement();
			updatedRows = st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows;
	}
}
