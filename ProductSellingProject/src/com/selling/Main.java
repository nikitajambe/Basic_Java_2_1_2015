package com.selling;

import java.sql.SQLException;
import java.util.Scanner;

import com.Impliment.Implimentation;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Implimentation im = new Implimentation();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose From following list");
		System.out.println("------------------------------");
		System.out.println("1] Add the Product details");
		System.out.println("2] View all product details");
		System.out.println("3] Update the Product Deatils");
		System.out.println("4] Delete the Product");

		int choice = sc.nextInt();
		
		boolean flag = true;

		switch (choice) {

		case 1:
			im.InsertData();
			flag=false;
			break;
			
		case 2:
			im.fetch();
            flag = false;
            break;
		
            
		case 3:
			im.Update();
			flag = false;
			break;
			
		case 4:
			im.Delete();
			flag = false;
			break;
			
			default :
				System.out.println("You Entered the wrong Option :(");
		}
	}

}
