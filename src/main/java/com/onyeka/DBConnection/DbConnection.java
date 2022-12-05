package com.onyeka.DBConnection;
import java.sql.*;

public class DbConnection {
	static Connection con;
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/todolist";
		String username="root";
		String password="meandsunshine200";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		if(getConnection()!=null) {
			System.out.println("Connection to Database was successful");
		}
	}
}
