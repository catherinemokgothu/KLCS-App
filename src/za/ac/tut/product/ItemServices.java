package za.ac.tut.product;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import za.ac.tut.product.Items;
import java.util.List;
import java.io.Serializable;

public class ItemServices implements Serializable
{
	private EntityManagerFactory factory;
	private EntityManager entity;
	
	public void open()throws Exception
	{
		factory = Persistence.createEntityManagerFactory("dataLink");
		entity = factory.createEntityManager();
	}
	
	public void saveItem(Items items)throws Exception
	{
		entity.getTransaction().begin();
		entity.persist(items);
		entity.getTransaction().commit();
	}
	
	public List<Items> retrieveAllItems() throws Exception
	{
		Query query = entity.createQuery("Select item from Items item");
		List<Items> listItems = query.getResultList();
		return listItems;
		
	}
	
	public void deleteItems(int itemID)throws Exception
	{
		Items itemObj = getItem(itemID);
		if (itemObj  != null)
		{
			entity.getTransaction().begin();
			entity.remove(itemObj);
			entity.getTransaction().commit();
			
		}
		
	}
	public void updateItems(Items items)throws Exception
	{
		Items itemObj = getItem(items.getItemID());
		if (itemObj != null)
		{
			entity.getTransaction().begin();
			itemObj.setItemQty(items.getItemQty());
			itemObj.setItemPrice(items.getItemPrice());
			entity.getTransaction().commit();
			
		}
		
	}
	public Items getItem(int itemID) throws Exception
	{
		
		return entity.find(Items.class,itemID);
	}
	
	public void close()throws Exception
	{
		entity.close();
		factory.close();
	}


}