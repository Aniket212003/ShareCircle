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


@WebServlet("/resetPasswordServlet")
public class resetPasswordServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public resetPasswordServlet() 
    
    {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		try
		{
			UserService userService = UserServiceFactory.getUserServiceInstance();
			String message = null;
			
			HttpSession session = request.getSession(false);
			if (session == null || session.getAttribute("userName") == null) 
			{
				message = "Somthing went Wrong";
				request.setAttribute("error", message);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			String newPassword = request.getParameter("newPassword");
			String userName = (String) session.getAttribute("userName");
			UserStatus status = userService.resetPassword(userName,newPassword);
			
			if(status == UserStatus.UPDATE_SUCCESS)
			{
				message = "Password Updated SuccessFully !!";
				request.setAttribute("alert", "success");
				request.setAttribute("message", message);
				request.getRequestDispatcher("forgetPasswordReset.jsp").forward(request, response);
			}
			else
			{
				message = "Failed to Update!!";
				request.setAttribute("alert", "error");
				request.setAttribute("message", message);
				request.getRequestDispatcher("forgetPasswordReset.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			String message = "Somthing went Wrong";
			request.setAttribute("alert", "error");
			request.setAttribute("message", message);
			request.getRequestDispatcher("forgetPasswordReset.jsp").forward(request, response);
		}
	}

}
