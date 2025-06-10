package com.sharecircle.controller;

import java.io.IOException;

import com.sharecircle.enums.UserStatus;
import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String message = null;
		try
		{
			UserService userService = UserServiceFactory.getUserServiceInstance();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			String verifyUser = userService.verifyUser(email,password);
			
			if(verifyUser != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("userName", verifyUser);
				request.getRequestDispatcher("./dashboardLoadServlet").forward(request, response);
			}
			else
			{
				message = UserStatus.INVALID_USER.getMessage();
				request.setAttribute("error", message);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			message = UserStatus.SOMETHING_WENT_WRONG.getMessage();
			request.setAttribute("error", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
