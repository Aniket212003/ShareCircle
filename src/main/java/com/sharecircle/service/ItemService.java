package com.sharecircle.service;

import java.util.List;

import com.sharecircle.dto.ItemDTO;

import com.sharecircle.enums.ItemStatus;

public interface ItemService 
{
	public abstract ItemStatus addItem(ItemDTO item);
	public abstract ItemDTO getAllItems();

}
