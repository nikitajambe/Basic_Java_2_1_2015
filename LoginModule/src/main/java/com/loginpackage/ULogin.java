package com.loginpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/ULogin")
public class ULogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	Connection con ;
	Statement st ;
	ResultSet rs ;
	
   
    public ULogin() {
        super();
       
    }
    
    
    @Override
    public void init() throws ServletException {
    	
    	super.init();
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login","root","Mysql@2001");
	    	
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("select * from users");
			
			while(rs.next()) {
				System.out.println("r = "+rs.getInt(1) +" |"+ rs.getString(1) +" |"+ rs.getString(2));
				System.out.println("Thank You");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");        //resp.setContentType use to define response content format
		PrintWriter out = response.getWriter();      //PrintWriter used to insert content on html page ->resp.getWriter() creates a html file to write
		out.println("helloworld. welcome to"); //normal string

    	out.println("<form method=\"GET\">"); //html element
    	out.println("<input type='text' placeholder='Enter your password'/>"); //html element
    	out.println("<input type='text' placeholder='Enter your user name'/>");//new line
    	out.println("</br>");//new line
    	out.println("</form>"); //html element
		
//		pic jonhson control
	}


	@Override
	public void destroy() {
		
		super.destroy();
	}

}
