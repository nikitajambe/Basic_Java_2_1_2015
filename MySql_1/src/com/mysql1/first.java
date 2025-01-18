package com.mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class first {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "Mysql@2001");

//		String query = "CREATE TABLE example (" + "id INT PRIMARY KEY, " + "name VARCHAR(20), " + "age INT)";

		String query ="insert into example values(?,?,?)";
//		Statement st = conn.createStatement();
		PreparedStatement pst = conn.prepareStatement(query);

//		pst.executeUpdate(query);
		
		pst.setInt(1, 104);
		pst.setString(2, "sangita");
		pst.setInt(3, 60);
		
//		System.out.println("First created Successfully...!!!");
		
		 int res = pst.executeUpdate();
		 
		
		System.out.println("data inserted Successfully...!!! "+ res);
		pst.close();

	}

}
