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
	    public Connection con;

	    public void LoginServlet() {
	        
	    }

	    @Override
	    public void init() throws ServletException {
	        super.init();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "Mysql@2001");
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void destroy() {
	        try {
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        super.destroy();
	    }

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        resp.setContentType("text/html");
	        PrintWriter out = resp.getWriter();
	        
	        out.println("Welcome to login page");
	        out.println("</br>");
	        out.println("</br>");
	        out.println("<form method=\"POST\">"); // Changed method to POST for security
	        out.println("<input type=\"text\" name=\"username\" placeholder=\"Enter username\" required/>");
	        out.println("</br>");
	        out.println("</br>");
	        out.println("<input type=\"password\" name=\"password\" placeholder=\"Enter password\" required/>");
	        out.println("</br>");
	        out.println("</br>");
	        out.println("<input type=\"submit\" name=\"submit\" value=\"Login\"/>");
	        out.println("</form>");
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        try {
	            // Use PreparedStatement to prevent SQL injection
	            String sql = "SELECT * FROM users WHERE user = ? AND password = ?";
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, username);
	            pst.setString(2, password);

	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                // Successful login
	                out.println("<h2>Login Successful! Welcome, " + username + ".</h2>");
	            } else {
	                // Invalid credentials
	                out.println("<h2>Invalid Username or Password. Please try again.</h2>");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
