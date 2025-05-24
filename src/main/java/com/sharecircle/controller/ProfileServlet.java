package com.sharecircle.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ProfileServlet() 
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doPost(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
	    
	    if (session == null || session.getAttribute("userName") == null) 
	    {
	        response.sendRedirect("login.jsp");
	        return;
	    }
	    
	    String userName = (String) session.getAttribute("userName");
	    request.setAttribute("userName", userName);
	    request.getRequestDispatcher("profile.jsp").forward(request, response);
		
		
	}

}
