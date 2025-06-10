package com.sharecircle.controller;

import java.io.IOException;
import java.util.List;

import com.sharecircle.dto.ItemDTO;
import com.sharecircle.enums.Category;
import com.sharecircle.factory.ItemServiceFactory;
import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.service.ItemService;
import com.sharecircle.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dashboardLoadServlet")
public class dashboardLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public dashboardLoadServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		try
		{
			HttpSession session = request.getSession(false);
			String message = null;
			UserService userService = UserServiceFactory.getUserServiceInstance();
			ItemService itemService = ItemServiceFactory.getItemServiceInstance();
			
			if (session == null || session.getAttribute("userName") == null) 
			{
				message = "Somthing went Wrong";
				request.setAttribute("error", message);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			Category categories[] = Category.values();
			request.setAttribute("categories", categories);
			
			ItemDTO itemDTO = itemService.getAllItems();
			String itemName = itemDTO.getItemName();
			Boolean isAvailable = itemDTO.getIsAvailable();
			String available = null;
			if(isAvailable)
			{
				available = "Available";
			}
			String fullName = itemDTO.getOwner().getFirstName() + " " + itemDTO.getOwner().getLastName();
			String shortDes = itemDTO.getShortDescription() + " by " + fullName;
			
//			System.out.println("Item Details : " +
//						itemName + " " +
//						shortDes + " " +
//						isAvailable + " " +
//						fullName + " " 
//					);
			
			List<String> images = itemDTO.getImageNames();
			String image = images.get(0);
			String imageURL = "uploads\\item_images\\" + image;
			request.setAttribute("itemName", itemName);
			request.setAttribute("shortDes", shortDes);
			request.setAttribute("availabilty", available);
			request.setAttribute("image", imageURL);
			
			
			
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
 			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
