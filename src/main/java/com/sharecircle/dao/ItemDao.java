package com.sharecircle.dao;

import com.sharecircle.entities.Item;
import com.sharecircle.enums.ItemStatus;

public interface ItemDao 
{
	public abstract ItemStatus addItem(Item item);
}
