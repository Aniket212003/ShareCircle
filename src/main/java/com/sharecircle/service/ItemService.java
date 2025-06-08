package com.sharecircle.service;

import com.sharecircle.dto.ItemDTO;
import com.sharecircle.enums.ItemStatus;

public interface ItemService 
{
	public abstract ItemStatus addItem(ItemDTO item);

}
