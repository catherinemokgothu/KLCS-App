package za.ac.tut.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity

public class Address
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  int addressID;
	private String residentialAddress;
	private String town;
	private int areaCode;
	
	public Address()
	{
	
	}
	
	public Address(int addressID, String residentialAddress, String town, int areaCode)
	{
		this.addressID = addressID;
		this.residentialAddress = residentialAddress;
		this.town = town;
		this.areaCode = areaCode;
	
	}
	
	public void setResidentialAddress(String residentialAddress)
	{
		this.residentialAddress = residentialAddress;
	}
	
	public String getResisdentitalAddress()
	{
		return residentialAddress;
	}
	
	public void setTown(String town)
	{
		this.town = town;
	}
	
	public String getTown()
	{
		return town;
	}
	
	public void setAreaCode(int areaCode)
	{
		this.areaCode = areaCode;
	}
	
	public int getAreaCode()
	{
		return areaCode;
	}
}