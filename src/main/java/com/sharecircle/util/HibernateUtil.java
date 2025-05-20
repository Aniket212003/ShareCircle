package com.sharecircle.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sharecircle.config.HibernateConfiguration;

public class HibernateUtil 
{
	private HibernateUtil() {}
	
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
			try
			{
				Configuration configuration = new Configuration();
				configuration.configure(HibernateConfiguration.FILE_NAME);
				sessionFactory = configuration.buildSessionFactory();
			}
			catch(Exception e)
			{
				System.out.println("SessionFactory Not Created !!");
				e.printStackTrace();
				return null;
			}
			
		}
		
		return sessionFactory; 
	}
	
	public static void closeSessionFactory()
	{
		try
		{
			if(sessionFactory!=null)
				sessionFactory.close();
		}
		catch(Exception e)
		{
			System.out.println("SessionFactory Not Closed !!");
			e.printStackTrace();
		}
	}
}
