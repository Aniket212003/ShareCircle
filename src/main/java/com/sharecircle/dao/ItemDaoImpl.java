package com.sharecircle.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sharecircle.entities.Item;
import com.sharecircle.enums.ItemStatus;
import com.sharecircle.util.HibernateUtil;

public class ItemDaoImpl implements ItemDao 
{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public ItemStatus addItem(Item item) 
	{
		Transaction txn = null;
		try(Session session = sessionFactory.openSession())
		{
			txn = session.beginTransaction();
			session.save(item);
			txn.commit();
			return ItemStatus.ADDED_SUCCESSFULLY;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			txn.rollback();
			return ItemStatus.FAILURE;
		}
	}

}
