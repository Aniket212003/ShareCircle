package com.sharecircle.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sharecircle.dao.ItemDao;
import com.sharecircle.dao.UserDao;
import com.sharecircle.dto.ItemDTO;
import com.sharecircle.dto.UserProfileDTO;
import com.sharecircle.entities.Item;
import com.sharecircle.entities.ItemImage;
import com.sharecircle.entities.Pincode;
import com.sharecircle.entities.User;
import com.sharecircle.enums.ItemStatus;
import com.sharecircle.factory.ItemDaoFactory;
import com.sharecircle.factory.PincodeServiceFactory;
import com.sharecircle.factory.UserDaoFactory;
import com.sharecircle.factory.UserServiceFactory;
import com.sharecircle.util.FileUploadUtil;

public class ItemServiceImpl implements ItemService
{
	ItemDao itemDao = ItemDaoFactory.getItemDaoInstance();
	UserDao userDao = UserDaoFactory.getUserDaoInstance();
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
	@Override
	public ItemDTO getAllItems() 
	{
		List<Item> items = itemDao.getAllItem();
		Item item = items.get(0);
		ItemDTO dto = new ItemDTO();
		
		List<String> names = item.getImages().stream()
	            .map(ItemImage::getImageName)
	            .collect(Collectors.toList());
		
		dto.setItemName(item.getItemName());
		dto.setCategory(item.getCategory());
		dto.setShortDescription(item.getShortDescription());
		dto.setDetailedDescription(item.getDetailedDescription());
		dto.setStartDate(item.getStartDate());
		dto.setEndDate(item.getEndDate());
		dto.setListingType(item.getListingType());
		dto.setSellPrice(item.getSellPrice());
		dto.setRentDeposit(item.getRentDeposit());
		dto.setRentPrice(item.getRentPrice());
		dto.setIsAvailable(item.getIsAvailable());
		dto.setPickupOptions(item.getPickupOptions());
		dto.setPincode(item.getPincode().getPincode());
		dto.setImageNames(names);
		
		User user = item.getOwner();
		UserProfileDTO userDTO = new UserProfileDTO();
		
		System.out.println(user);
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		
		dto.setOwner(userDTO);
		return dto;
		
	}
	

}
