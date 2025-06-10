package com.sharecircle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	
	@Override
	public List<Item> getAllItem() 
	{
		try(Session session = sessionFactory.openSession())
		{
			Query<Item> query = session.createQuery("select distinct i " +
		            "from Item i " +
		            "   left join fetch i.images img " +
		            "   join fetch i.owner u",
		            Item.class);
			return query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
