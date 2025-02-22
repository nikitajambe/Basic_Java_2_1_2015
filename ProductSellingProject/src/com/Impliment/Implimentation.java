package com.Impliment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Connection.connection;
import com.Method.Unimplimented;

public class Implimentation implements Unimplimented {

	public void InsertData() throws ClassNotFoundException, SQLException {

		Connection con = connection.createConnection();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the id for Product : ");
		int id = sc.nextInt();

		System.out.println("Enter the name for Milk Product :");
		String milkProd = sc.next();

		System.out.println("Enter the Price for Product :");
		double price = sc.nextDouble();

		try {
			PreparedStatement ps = con.prepareStatement("insert into ProductOfMilk values(?,?,?)");

			ps.setInt(1, id);
			ps.setString(2, milkProd);
			ps.setDouble(3, price);

			int res = ps.executeUpdate();
			System.out.println("affected rows : " + res);
			ps.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};
	
	
	
	public void fetch()throws ClassNotFoundException, SQLException {
		

		try {
			Connection con = connection.createConnection();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the id for Getting Details of Product :");
			int id = sc.nextInt();
			
			PreparedStatement ps = con.prepareStatement("select * from ProductOfMilk where pid = ?;");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
				
			}
			
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void Update() {
		
		try {
			Connection con = connection.createConnection();
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("enter your id tu update product price : ");
			int id = sc.nextInt();
			
			System.out.println("Enter your amount to update price of " +id+ "product");
			double s = sc.nextDouble();
			
			PreparedStatement ps = con.prepareStatement("Update ProductOfMilk set pprice= ? where pid =?");
			
			ps.setDouble(1, s);
			ps.setInt(2,id );
			
			int row=ps.executeUpdate();
			System.out.println(row+" Effected");
			
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	public void Delete() {
		try {
			Connection con = connection.createConnection();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter id for delete the Product :");
			int id = sc.nextInt();
			
			PreparedStatement ps = con.prepareStatement("Delete from ProductOfMilk where pid=?;");
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			System.out.println("affected rows : "+row);
			
			if(row==0) {
				System.out.println(row+ " Product NOT deleted , try again :(");
			}else {
				System.out.println(row+ " Product Deleted Succefully :)");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
