package com.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name for file with extension : ");
		String fname = sc.next();
		File file = new File(fname);

		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("file created successfully..");
			} else {
				System.out.println("file name already exists..");
				file.canWrite(); // if file is a;ready exit then we can make changes in the file
				file.canRead();
			}
		} catch (IOException obj) {
			obj.printStackTrace();
		}

//	 FileWriter fw = new FileWriter(file);
//	 BufferedWriter bw = new BufferedWriter(fw);

		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		System.out.println("Enter the number of line in the file :");
		int lno = sc.nextInt();

		String content[] = new String[lno];

		for (int i = 0; i < lno; i++) {
			content[i] = sc.nextLine();
			bw.append(content[i] + "\n");

		}

		bw.close();

		
//	------  reading operation ------ 

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
