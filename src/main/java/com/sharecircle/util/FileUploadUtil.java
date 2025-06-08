package com.sharecircle.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.http.Part;

public class FileUploadUtil 
{
	private FileUploadUtil() {}
	private static final String UPLOAD_DIR = "uploads\\item_images";
	private static final String APPLICATION_PATH = "D:\\\\Aniket\\\\STUDY\\\\Java\\\\WEB eclipse\\\\WebEclipse-Projects\\\\ShareCircle-Research-Project\\\\src\\\\main\\\\webapp";
			
	public static List<String> store(Collection<Part> parts) throws IOException 
	{
        String uploadPath = APPLICATION_PATH + File.separator + UPLOAD_DIR;

        // Create uploads folder if it doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) 
        {
            uploadDir.mkdirs();
        }
        
	    List<String> filenames = new ArrayList<>();
	    for (Part part : parts) 
	    {
	      if ("itemImages".equals(part.getName()) && part.getSize()>0) 
	      {
	        String filename = UUID.randomUUID() + "_" + extractFileName(part);
	        part.write(uploadDir + File.separator + filename);
	        filenames.add(filename);
	      }
	    }
	    
	    return filenames;
	  }
	
	private static String extractFileName(Part part) 
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
