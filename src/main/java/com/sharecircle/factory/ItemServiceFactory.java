package com.sharecircle.factory;

import com.sharecircle.service.ItemService;
import com.sharecircle.service.ItemServiceImpl;

public class ItemServiceFactory 
{
	private ItemServiceFactory() {}
	
	public static ItemService itemService = null;
	
	public static ItemService getItemServiceInstance()
	{
		try
		{
			if(itemService == null)
			{
				itemService = new ItemServiceImpl();
			}
			
			return itemService;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
