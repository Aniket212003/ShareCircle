package com.sharecircle.service;

import com.sharecircle.entities.Item;
import com.sharecircle.enums.ItemStatus;

public interface ItemService 
{
	public abstract ItemStatus addItem(Item item);

}
