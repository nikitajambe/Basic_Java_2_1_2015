package com.loginpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Connection con;
	
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
  
    
    
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "Mysql@2001");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        super.init();

    }
	
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");

   
     
        String q2="insert into users(user,password) values(?,?)";
        
		try {
			PreparedStatement ps = con.prepareStatement(q2);
			ps.setString(1,username);
			ps.setString(2, password);
			
			int rowAffected = ps.executeUpdate();
			
			if(rowAffected > 0) {
				System.out.println("<h2>SignUp Successful! Welcome, " + username + ".</h2>");
			}
			else {
				System.out.println("<h2>SignUp Failed</h2>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.destroy();
    }
    
    
    
	protected void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 resp.setContentType("text/html");
	        PrintWriter out = resp.getWriter();
	        
        out.println("Welcome to Sign page");
        out.println("</br>");
        out.println("</br>");
        out.println("<form method=\"POST\">"); // Changed method to POST for security

        out.println("<input type=\"text\" name=\"username\" placeholder=\"Enter username\" required/>");
        out.println("</br>");
        out.println("</br>");
        out.println("<input type=\"password\" name=\"password\" placeholder=\"Enter password\" required/>");
        out.println("</br>");
        out.println("</br>");
        out.println("<input type=\"submit\" name=\"submit\" value=\"Signup\"/>");
        out.println("</form>");
	}

	


}
