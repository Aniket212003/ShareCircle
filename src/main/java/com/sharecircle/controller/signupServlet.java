package com.sharecircle.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import com.sharecircle.entities.User;
import com.sharecircle.enums.UserStatus;
import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public signupServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		String message = null;
		try
		{
			String firstName = request.getParameter("firstName");
			String lastName =  request.getParameter("lastName");
			String userName = request.getParameter("userName");
			String email = request.getParameter("email");
			Long phoneNumber = Long.parseLong(request.getParameter("phone"));
			String password  = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");
			
			UserService userService = UserServiceFactory.getUserServiceInstance();
			
			Boolean userExists = userService.checkUser(userName);
			System.out.println(userExists);
			
			if(userExists)
			{
				String error = "Username " + userName + " Already Exists";
				request.setAttribute("error", error);
			}
			else
			{
				User user = new User();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setUserName(userName);
				user.setUserEmail(email);
				user.setUserPhoneNumber(phoneNumber);
				user.setPassword(password);
			
				UserStatus status = userService.addUser(user);
				
				if(status == UserStatus.SUCCESS)
				{	
					message = "Account Created Successfully !!";
					request.setAttribute("alert", "success");
					request.setAttribute("message", message);
				}
				else
				{
					message = "Failed to Created Account !!";
					request.setAttribute("alert", "error");
					request.setAttribute("message", message);
				}
			}
			
			System.out.println(firstName + "-->" + lastName + "-->" + userName + "-->" + email + "-->" + phoneNumber + "-->" + password + "-->" + confirmPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Something went Wrong !");
			message = "Something went Wrong ! !!";
			request.setAttribute("alert", "error");
			request.setAttribute("message", message);
		}
		finally
		{
			rd.forward(request, response);
		}
	}

}
