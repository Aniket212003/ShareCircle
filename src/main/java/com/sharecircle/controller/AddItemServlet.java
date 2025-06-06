package com.sharecircle.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

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
		
		//out.println("Heyy this is " + userName + " logged In !" );
		
		String applicationPath = "D:\\Aniket\\STUDY\\Java\\WEB eclipse\\WebEclipse-Projects\\ShareCircle-Research-Project\\src\\main\\webapp";
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;

        // Create uploads folder if it doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        System.out.println("Application path: " + applicationPath);
        System.out.println("Upload path: " + uploadPath);
        System.out.println("Upload directory exists: " + uploadDir.exists());
        System.out.println("Upload directory writable: " + uploadDir.canWrite());
        
        try 
        {
            // Process each file part
            for (Part part : request.getParts()) 
            {
                if (part.getName().equals("itemImages") && part.getSize() > 0) 
                {
                    // Generate unique filename
                    String fileName = UUID.randomUUID().toString() + "_" + extractFileName(part);
                    System.out.println("Saving to: " + uploadPath + File.separator + fileName);
                    // Save file
                    part.write(uploadPath + File.separator + fileName);
                    
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
            Integer pincode = Integer.parseInt(request.getParameter("pincode"));
            String address = request.getParameter("address");
            
            out.println(
				            itemName + " " +
				            category + " " +
				            shortDescription + " " +
				            detailedDescription + " " +
				            startDate + " " +
				            endDate + " " +
				            listingType + " " +
				            rentPrice + " " +
				            rentDeposit + " " +
				            sellPrice + " " +
				            pickupOptions + " " +
				            pincode + " " +
				            address
				       );
            
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
	
	

}
