package com.sharecircle.service;

import com.sharecircle.dao.PincodeDao;
import com.sharecircle.entities.Pincode;
import com.sharecircle.factory.PincodeDaoFactory;

public class PincodeServiceImpl implements PincodeService {

	PincodeDao pincodeDao = PincodeDaoFactory.getPincodeDaoFactoryInstance();
	@Override
	public Pincode getInfo(String pincode) 
	{
		if(pincode == null || pincode.isEmpty())
		{
			return null;
		}
		
		return pincodeDao.getInfo(pincode);
	}

}
