package com.sharecircle.controller;

import java.io.IOException;

import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/forgetPasswordServlet")
public class forgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public forgetPasswordServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		try
		{
			UserService userService = UserServiceFactory.getUserServiceInstance();
			String message = null;
			String userName =  request.getParameter("username");
			String action = request.getParameter("reset");
			
			if(action != null)
			{
				Boolean checkUser = userService.checkUser(userName);
				if(checkUser)
				{
					request.setAttribute("userName", userName);
					request.getRequestDispatcher("forgetPasswordPage1.jsp").forward(request, response);
				}
				else
				{
					message = "Invalid Username !!";
					request.setAttribute("alert", "error");
					request.setAttribute("message", message);
					request.getRequestDispatcher("forgetPassword.jsp").forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			doGet(request, response);
	}

}
