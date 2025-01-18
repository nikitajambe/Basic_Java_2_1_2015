package com.mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Mysql@2001");

        String query = "CREATE TABLE Dept (" +"did INT PRIMARY KEY, " +"dname VARCHAR(20))";

        Statement st = conn.createStatement();
        

        st.executeUpdate(query);
        System.out.println("Table 'Dept' created successfully.");

        st.close();
        conn.close();
    }
}
