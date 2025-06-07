package com.sharecircle.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sharecircle.entities.Pincode;
import com.sharecircle.util.HibernateUtil;

public class PincodeDaoImpl implements PincodeDao 
{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Pincode getInfo(String pincode) 
	{
		try(Session session = sessionFactory.openSession())
		{
			Pincode pincodeClass = session.get(Pincode.class, pincode);
			
			if(pincodeClass == null)
			{
				return null;
			}
			
			return pincodeClass;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
