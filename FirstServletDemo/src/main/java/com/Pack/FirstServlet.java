package com.Pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  //to initaialize the sevlet
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("Servelet started....");
    }
    //to process the (Get) incoming requests on type get
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");        //resp.setContentType use to define response content format
		PrintWriter out = resp.getWriter();      //PrintWriter used to insert content on html page ->resp.getWriter() creates a html file to write
		out.println("helloworld. welcome to"); //normal string
    	out.println("<em>SANIKA</em>"); //html element
    	out.println("</br>");//new line
    	out.println("</br>");//new line
    	out.println("<form method=\"GET\">"); //html element
    	out.println("<input type=\"text\" name=\"a\" placeholder=\"Enter value of a\"/>");//html element 
    	out.println("</br>");//new line
    	out.println("</br>");//new line
    	out.println("<input type=\"text\" name=\"b\" placeholder=\"Enter value of b\"/>");//html element
    	out.println("</br>");//new line
    	out.println("</br>");//new line
    	out.println("<input type=\"submit\" name=\"Addition\" value=\"Addition\"/>"); //html element
    	out.println("</br>");//new line
    	out.println("</br>");//new line
    	out.println("<input type=\"submit\" name=\"Substraction\" value=\"Substraction\"/>");//html element
    	out.println("</br>");//new line
    	out.println("</br>");//new line
    	out.println("<input type=\"submit\" name=\"Multiplication\" value=\"Multiplication\"/>");//html element
    	out.println("</br>");//new line
    	out.println("</br>");//new line
    	out.println("<input type=\"submit\" name=\"Division\" value=\"Division\"/>");//html element
    	out.println("</form>"); //html element
		
		String reqval1 = req.getParameter("Addition");
		if(reqval1 !=null) {
			int a = Integer.parseInt(req.getParameter("a"));
			int b = Integer.parseInt(req.getParameter("b"));
			out.print("<em>Addition = "+(a+b)+"</em>");
		}	
		
		String reqval2 = req.getParameter("Substraction");
		if(reqval2 !=null) {
			int a = Integer.parseInt(req.getParameter("a"));
			int b = Integer.parseInt(req.getParameter("b"));
			out.print("<em>Substraction = "+(a-b)+"</em>");
		}	
		
		String reqval3 = req.getParameter("Multiplication");
		if(reqval3 !=null) {
			int a = Integer.parseInt(req.getParameter("a"));
			int b = Integer.parseInt(req.getParameter("b"));
			out.print("<em>Multiplication = "+(a*b)+"</em>");
		}	
		
		String reqval4 = req.getParameter("Division");
		if(reqval4 !=null) {
			int a = Integer.parseInt(req.getParameter("a"));
			int b = Integer.parseInt(req.getParameter("b"));
			out.print("<em>Division = "+(a/b)+"</em>");
		}	
	}
	
	//to deallocated servlet memory from stack
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("Servelet executation complete....");
	}

}
