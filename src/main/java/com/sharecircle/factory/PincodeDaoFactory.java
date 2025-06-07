package com.sharecircle.factory;

import com.sharecircle.dao.PincodeDao;
import com.sharecircle.dao.PincodeDaoImpl;

public class PincodeDaoFactory 
{
	private PincodeDaoFactory() {}
	 
	public static PincodeDao pincodeDao = null;
	
	public static PincodeDao getPincodeDaoFactoryInstance()
	{
		try 
		{
			if(pincodeDao == null)
			{
				pincodeDao = new PincodeDaoImpl();
			}
			
			return pincodeDao;
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
