package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WelcomeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String username=request.getParameter("user");
String password=request.getParameter("pass");
String email=request.getParameter("email");
String phone=request.getParameter("phone");



		PrintWriter pw=response.getWriter();
		
		pw.println("<html><body bgcolor='pink'>");
		pw.println("<center><h1>Welcome "+username+" with "+email+" and "+phone+" </h1></center>");
		pw.println("</body></html>");
		
	}

}
