package com.sharecircle.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.UUID;

import com.sharecircle.entities.Item;
import com.sharecircle.entities.ItemImage;
import com.sharecircle.entities.Pincode;
import com.sharecircle.enums.Category;
import com.sharecircle.enums.ListingType;
import com.sharecircle.enums.PickupOptions;

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
	private static final String UPLOAD_DIR = "uploads\\item_images";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String message = null;
		if (session == null || session.getAttribute("userName") == null) 
		{
			message = "Somthing went Wrong";
			request.setAttribute("error", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		
		//String userName = (String) session.getAttribute("userName");
		
		String applicationPath = "D:\\Aniket\\STUDY\\Java\\WEB eclipse\\WebEclipse-Projects\\ShareCircle-Research-Project\\src\\main\\webapp";
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;

        // Create uploads folder if it doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        
        try 
        {
        	Item item = new Item();
        	ItemImage itemImage = new ItemImage();
            // Process each file part
            for (Part part : request.getParts()) 
            {
                if (part.getName().equals("itemImages") && part.getSize() > 0) 
                {
                    
                    String fileName = UUID.randomUUID().toString() + "_" + extractFileName(part);
                    System.out.println("Saving to: " + uploadPath + File.separator + fileName);
                    part.write(uploadPath + File.separator + fileName);
                    itemImage.setImageName(fileName);
                    item.addImages(itemImage);
                    // Here you would typically save the filename to your database
                    // along with other item information
                }
            }
            
            
            
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
            Double rPrice = null;
            Double dPrice = null;
            Double sPrice = null;
            
            if(startDate != null || !startDate.isEmpty())
            {
            	sDate = LocalDate.parse(startDate);
            }
            
            if(endDate != null || !endDate.isEmpty())
            {
            	eDate = LocalDate.parse(endDate);
            }
            
            if(rentPrice != null || !rentPrice.isEmpty())
            {
            	rPrice = Double.parseDouble(rentPrice);
            }
            
            if(rentDeposit != null || !rentDeposit.isEmpty())
            {
            	dPrice = Double.parseDouble(rentDeposit);
            }
            
            if(sellPrice != null || !sellPrice.isEmpty())
            {
            	sPrice = Double.parseDouble(sellPrice);
            }
            
            Pincode pincodeClass = PinCodeService.getInfo(pincode);
            
            item.setItemId(UUID.randomUUID().toString());
            item.setItemName(itemName);
            item.setCategory(Category.valueOf(category));
            item.setShortDescription(shortDescription);
            item.setDetailedDescription(detailedDescription);
            item.setStartDate(sDate);
            item.setEndDate(eDate);
            item.setListingType(ListingType.valueOf(listingType));
            item.setRentPrice(rPrice);
            item.setRentDeposit(dPrice);
            item.setSellPrice(sPrice);
            item.setPickupOptions(PickupOptions.valueOf(pickupOptions));
            item.setPincode(pincodeClass);
            item.setAddress(address);
            
            itemImage.setItem(item);
            
            
            
            
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
        }
        
	}
	
	private String extractFileName(Part part) 
	{
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) 
        {
            if (s.trim().startsWith("filename")) 
            {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
	
	

}
