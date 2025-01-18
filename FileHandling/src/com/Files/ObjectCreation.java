package com.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Emp {
	int id;
	String name;
	int age;

	public Emp(int i, String n, int a) {

		id = i;
		name = n;
		age = a;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}


public class ObjectCreation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Emp obj1 = new Emp(0, null, 0);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name with extention : ");
		String fname = sc.next();
		File file = new File(fname);
		
		
		try {
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("File created Succesfully");
			}else {
				System.out.println("File Already Exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.append(obj1.toString());
		
		bw.close();
		
		
//		reading 
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();
		fr.close();

	}

}
