package za.ac.tut.product;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="tblitems")
public class Items implements Serializable
{
	@Id
	@GeneratedValue
	private int itemID;
	private String itemDescription;
	private String itemImage;
	private int itemQty;
	private double itemPrice;
	
	public  Items()
	{
	
	}
	
	public Items(int itemID,String itemDescription,String itemImage,int itemQty,double itemPrice)
	{
		this.itemID = itemID;
		this.itemDescription = itemDescription;
		this.itemImage = itemImage;
		this.itemQty = itemQty;
		this.itemPrice = itemPrice;
	}
	
	public void setItemId(int itemID)
	{
		this.itemID = itemID;
	}
	
	public int getItemID()
	{
		return itemID;
	}
	
	public void setItemDescription(String itemDescription)
	{
		this.itemDescription = itemDescription;
	}
	
	public String getItemDescription()
	{
		return itemDescription;
	}
	
	public void setItemImage(String itemImage)
	{
		this.itemImage = itemImage;
	}
	
	public String getItemImage()
	{
		return itemImage;
	}
	
	public void setItemQty(int itemQty)
	{
		this.itemQty = itemQty;
	}
	
	public int getItemQty()
	{
		return itemQty;
	}
	
	public void setItemPrice(double itemPrice)
	{
		this.itemPrice = itemPrice;
	}
	
	public double getItemPrice()
	{
		return itemPrice;
	}
	
	
	
	

}