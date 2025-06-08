package com.sharecircle.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Collection;

import com.sharecircle.dto.ItemDTO;
import com.sharecircle.enums.Category;
import com.sharecircle.enums.ItemStatus;
import com.sharecircle.enums.ListingType;
import com.sharecircle.enums.PickupOptions;
import com.sharecircle.factory.ItemServiceFactory;
import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.service.ItemService;
import com.sharecircle.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;




@WebServlet("/AddItemServlet")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
	    maxFileSize = 1024 * 1024 * 10,      // 10 MB
	    maxRequestSize = 1024 * 1024 * 100   // 100 MB
	)
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String message = null;
		
		if (session == null || session.getAttribute("userName") == null) 
		{
			message = "Somthing went Wrong";
			request.setAttribute("error", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		ItemService itemService = ItemServiceFactory.getItemServiceInstance(); 
		UserService userService = UserServiceFactory.getUserServiceInstance();
		
        try 
        {
        	ItemDTO itemDTO = new ItemDTO();
        	
        	Collection<Part> parts = request.getParts();            
            
            String userName = (String) session.getAttribute("userName");
            Integer userId = userService.getUserId(userName);
            String itemName = request.getParameter("itemName");
            String category = request.getParameter("category");
            String shortDescription = request.getParameter("shortDescription");
            String detailedDescription = request.getParameter("detailedDescription");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String listingType = request.getParameter("listingType");
            String rentPrice = request.getParameter("rentPrice");
            String rentDeposit = request.getParameter("rentDeposit");
            String sellPrice = request.getParameter("sellPrice");
            String pickupOptions = request.getParameter("pickupOptions");
            String pincode = request.getParameter("pincode");
            String address = request.getParameter("address");
            
            LocalDate sDate = null;
            LocalDate eDate = null;
            
            if(startDate != null)
            {
            	sDate = LocalDate.parse(startDate);
            }
            
            Double sPrice = null;
            
            
            
            if(listingType.equals("SHARE"))
            {
            	itemDTO.setUserId(userId);
            	itemDTO.setItemName(itemName);
	            itemDTO.setCategory(Category.valueOf(category));
	            itemDTO.setShortDescription(shortDescription);
	            itemDTO.setDetailedDescription(detailedDescription);
	            itemDTO.setStartDate(sDate);
	            itemDTO.setListingType(ListingType.valueOf(listingType));
	            itemDTO.setPickupOptions(PickupOptions.valueOf(pickupOptions));
	            itemDTO.setIsAvailable(true);
	            itemDTO.setPincode(pincode);
	            itemDTO.setAddress(address);
	            itemDTO.setFileParts(parts);
	            
            }
            else if(listingType.equals("RENT"))
            {
            	Double rPrice = null;
                Double dPrice = null;
                if(endDate != null)
                {
                	eDate = LocalDate.parse(endDate);
                }
                
                if(rentPrice != null)
                {
                	rPrice = Double.parseDouble(rentPrice);
                }
                
                if(rentDeposit != null)
                {
                	dPrice = Double.parseDouble(rentDeposit);
                }
                
                itemDTO.setUserId(userId);
                itemDTO.setItemName(itemName);
	            itemDTO.setCategory(Category.valueOf(category));
	            itemDTO.setShortDescription(shortDescription);
	            itemDTO.setDetailedDescription(detailedDescription);
	            itemDTO.setStartDate(sDate);
	            itemDTO.setEndDate(eDate);
	            itemDTO.setListingType(ListingType.valueOf(listingType));
	            itemDTO.setRentPrice(rPrice);
	            itemDTO.setRentDeposit(dPrice);
	            itemDTO.setPickupOptions(PickupOptions.valueOf(pickupOptions));
	            itemDTO.setIsAvailable(true);
	            itemDTO.setPincode(pincode);
	            itemDTO.setAddress(address);
            }
            else
            {
            	if(sellPrice != null)
                {
                	sPrice = Double.parseDouble(sellPrice);
                }
            	
            	itemDTO.setUserId(userId);
            	itemDTO.setItemName(itemName);
	            itemDTO.setCategory(Category.valueOf(category));
	            itemDTO.setShortDescription(shortDescription);
	            itemDTO.setDetailedDescription(detailedDescription);
	            itemDTO.setStartDate(sDate);
	            itemDTO.setListingType(ListingType.valueOf(listingType));
	            itemDTO.setSellPrice(sPrice);
	            itemDTO.setPickupOptions(PickupOptions.valueOf(pickupOptions));
	            itemDTO.setIsAvailable(true);
	            itemDTO.setPincode(pincode);
	            itemDTO.setAddress(address);
            }
            	            
	        ItemStatus status = itemService.addItem(itemDTO);
            
            if(status == ItemStatus.ADDED_SUCCESSFULLY)
            {
            	message = ItemStatus.ADDED_SUCCESSFULLY.getMessage();
            	request.setAttribute("alert", "success");
				request.setAttribute("message", message);
				request.getRequestDispatcher("addItem.jsp").forward(request, response);
            }
            else
            {
            	message = ItemStatus.FAILED.getMessage();
            	request.setAttribute("alert", "error");
				request.setAttribute("message", message);
				request.getRequestDispatcher("addItem.jsp").forward(request, response);
            }
            
//            out.println(
//				            itemName + " " +
//				            category + " " +
//				            shortDescription + " " +
//				            detailedDescription + " " +
//				            startDate + " " +
//				            endDate + " " +
//				            listingType + " " +
//				            rentPrice + " " +
//				            rentDeposit + " " +
//				            sellPrice + " " +
//				            pickupOptions + " " +
//				            pincode + " " +
//				            address
//				       );
            
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	message = ItemStatus.FAILURE.getMessage();
        	request.setAttribute("alert", "error");
			request.setAttribute("message", message);
			request.getRequestDispatcher("addItem.jsp").forward(request, response);
        }
        
	}

}
