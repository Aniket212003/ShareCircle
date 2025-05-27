package com.sharecircle.controller;

import java.io.IOException;

import com.sharecircle.dto.UserProfileDTO;
import com.sharecircle.enums.UserStatus;
import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/editProfileUpdateServlet")
public class editProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public editProfileUpdateServlet() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		try
		{
			HttpSession session = request.getSession(false);
			String message = null;
			UserService userService = UserServiceFactory.getUserServiceInstance();
			if (session == null || session.getAttribute("userName") == null) 
			{
				message = "Somthing went Wrong";
				request.setAttribute("error", message);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			String action = request.getParameter("save");
			
			if(action != null)
			{
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String userName = request.getParameter("username");
				String email = request.getParameter("email");
				Long phone = Long.parseLong(request.getParameter("phone"));
				String address = request.getParameter("address");
				String bio = request.getParameter("bio");
				
				UserProfileDTO user = new UserProfileDTO();
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setUserName(userName);
				user.setUserEmail(email);
				user.setUserPhoneNumber(phone);
				user.setLocation(address);
				user.setBio(bio);
				
				UserStatus update = userService.updateUserProfile(user);
				
				if(update == UserStatus.UPDATE_SUCCESS)
				{
					message = "Information Updated SuccessFully !!";
					request.setAttribute("alert", "success");
					request.setAttribute("message", message);
					request.getRequestDispatcher("editProfile.jsp").forward(request, response);
				}
				else
				{
					message = "Failed to Update!!";
					request.setAttribute("alert", "error");
					request.setAttribute("message", message);
					request.getRequestDispatcher("editProfile.jsp").forward(request, response);
				}
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			String message = "Somthing went Wrong";
			request.setAttribute("alert", "error");
			request.setAttribute("message", message);
			request.getRequestDispatcher("editProfile.jsp").forward(request, response);
		}
	}

}
