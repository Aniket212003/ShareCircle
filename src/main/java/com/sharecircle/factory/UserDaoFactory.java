package com.sharecircle.factory;

import com.sharecircle.dao.UserDao;
import com.sharecircle.dao.UserDaoImpl;

public class UserDaoFactory 
{
	private UserDaoFactory() {}
	
	private static UserDao userDao = null;
	
	public static UserDao getUserDaoInstance()
	{
		try
		{
			if(userDao == null)
			{
				userDao = new UserDaoImpl();
			}
			
			return userDao;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}