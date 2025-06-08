package com.sharecircle.service;

import java.util.List;
import java.util.UUID;

import com.sharecircle.dao.ItemDao;
import com.sharecircle.dto.ItemDTO;
import com.sharecircle.entities.Item;
import com.sharecircle.entities.ItemImage;
import com.sharecircle.entities.Pincode;
import com.sharecircle.entities.User;
import com.sharecircle.enums.ItemStatus;
import com.sharecircle.factory.ItemDaoFactory;
import com.sharecircle.factory.PincodeServiceFactory;
import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.util.FileUploadUtil;

public class ItemServiceImpl implements ItemService
{
	ItemDao itemDao = ItemDaoFactory.getItemDaoInstance();
	@Override
	public ItemStatus addItem(ItemDTO dto) 
	{
		try
		{
			if(dto == null)
			{
				return null;
			}
			UserService userService = UserServiceFactory.getUserServiceInstance();
			PincodeService pincodeService = PincodeServiceFactory.getPincodeServiceInstance();
			
			User user = userService.getUserDeatils(dto.getUserId());
			Pincode pincode = pincodeService.getInfo(dto.getPincode());
			
			Item item = new Item();
			item.setItemId(UUID.randomUUID().toString());
			item.setItemName(dto.getItemName());
			item.setCategory(dto.getCategory());
			item.setOwner(user);
			item.setAddress(dto.getAddress());
			item.setDetailedDescription(dto.getDetailedDescription());
			item.setShortDescription(dto.getShortDescription());
			item.setStartDate(dto.getStartDate());
			item.setEndDate(dto.getEndDate());
			item.setIsAvailable(dto.getIsAvailable());
			item.setListingType(dto.getListingType());
			item.setPincode(pincode);
			item.setSellPrice(dto.getSellPrice());
			item.setRentDeposit(dto.getRentDeposit());
			item.setPickupOptions(dto.getPickupOptions());
			item.setRentPrice(dto.getRentPrice());
			
			List<String> savedNames = FileUploadUtil.store(dto.getFileParts());
			for (String filename : savedNames) 
			{
			    ItemImage img = new ItemImage();
			    img.setImageName(filename);
			    item.addImages(img);
			}
			
			return itemDao.addItem(item);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
