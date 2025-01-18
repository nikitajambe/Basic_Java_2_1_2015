package com.operation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class crud {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUDOperation", "root", "Mysql@2001");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the id :");
		int id = sc.nextInt();
		
		System.out.println("enter the name :");
		String name = sc.next();
		
//		PreparedStatement ps = ;

	}

}
