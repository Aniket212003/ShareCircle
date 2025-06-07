package com.sharecircle.factory;

import com.sharecircle.service.PincodeService;
import com.sharecircle.service.PincodeServiceImpl;

public class PincodeServiceFactory 
{
	private PincodeServiceFactory() {}
	
	public static PincodeService pincodeService = null;
	
	public static PincodeService getPincodeServiceInstance()
	{
		try
		{
			if(pincodeService == null)
			{
				pincodeService = new PincodeServiceImpl();
			}
			
			return pincodeService;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
