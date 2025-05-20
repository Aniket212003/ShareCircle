package com.sharecircle.factory;

import com.sharecircle.service.UserService;
import com.sharecircle.service.UserServiceImpl;

public class UserServiceFactory 
{
	private UserServiceFactory() {}
	
	private static UserService userService = null;
	
	public static UserService getUserServiceInstance()
	{
		try
		{
			if(userService == null)
			{
				userService = new UserServiceImpl();
			}
			
			return userService;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
