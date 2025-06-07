package com.sharecircle.service;

import com.sharecircle.dao.ItemDao;
import com.sharecircle.entities.Item;
import com.sharecircle.enums.ItemStatus;
import com.sharecircle.factory.ItemDaoFactory;

public class ItemServiceImpl implements ItemService
{
	ItemDao itemDao = ItemDaoFactory.getItemDaoInstance();
	@Override
	public ItemStatus addItem(Item item) 
	{
		if(item == null)
		{
			return null;
		}
		
		return itemDao.addItem(item);
	}

}
