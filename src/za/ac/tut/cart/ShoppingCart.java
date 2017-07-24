package za.ac.tut.cart;
import  za.ac.tut.product.Items;
import java.util.Vector;

public class ShoppingCart
{
	private Vector<Items> list = new Vector<Items>();
	
	public void addItem(Items item)
	{
		list.add(item);	
	}
	
	public Vector<Items> getList()
	{
		return list;	
	}
	
	public void removeItem(int productID)
	{
		for(Items item: list)
		{
			if (item.getItemID() == productID)
			{
				list.remove(item);
			}
		}
		
	}
	public void updateQty(int productID,int qty)
	{
		//for(Product product: list)
		for(int i = 0; i < list.size();++i)
			
		{
			Items product = list.get(i);
			if (product.getItemID() == productID)
			{
				list.remove(product);
				product.setItemQty(qty);
				list.add(product);
			}
		}
		
	}
	public double total()
	{
		double price=0;
		for(Items product: list)
		{
			price+=(product.getItemPrice() * product.getItemQty());
		}
		return price;
		
	}
	
}