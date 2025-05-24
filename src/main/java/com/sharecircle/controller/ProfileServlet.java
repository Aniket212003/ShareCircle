package com.sharecircle.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import com.sharecircle.dto.UserProfileDTO;
import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.service.UserService;

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
			
			String userName = (String) session.getAttribute("userName");
			Integer userId = userService.getUserId(userName);
			
			UserProfileDTO userProfile = userService.getUserDetails(userId);
			
			if(userProfile != null)
			{
				request.setAttribute("userFullName", userProfile.getFullName());
				request.setAttribute("userName", userName);
				request.setAttribute("userEmail", userProfile.getUserEmail());
				request.setAttribute("userBio", userProfile.getBio());
				request.setAttribute("userItemSold", userProfile.getItemsSoledCount());
				request.setAttribute("userItemRented", userProfile.getItemsRentedCount());
				request.setAttribute("userItemShared", userProfile.getItemsSharedCount());
				request.setAttribute("userLocation", userProfile.getLocation());
				request.setAttribute("userJoined", userProfile.getCreatedAt());
				request.setAttribute("userProfileURL", userProfile.getProfileURL());
				request.setAttribute("userContact", userProfile.getUserPhoneNumber());
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			}
			else
			{
				message = "Profile Data Not Found";
				request.setAttribute("error", message);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			String message = "Somthing went Wrong";
			request.setAttribute("error", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
