package com.sharecircle.factory;

import com.sharecircle.dao.ItemDao;
import com.sharecircle.dao.ItemDaoImpl;

public class ItemDaoFactory 
{
	private ItemDaoFactory() {}
	
	public static ItemDao itemDao = null;
	
	public static ItemDao getItemDaoInstance()
	{
		try
		{
			if(itemDao == null)
			{
				itemDao = new ItemDaoImpl();
			}
			
			return itemDao;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
