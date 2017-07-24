package za.ac.tut.person;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="tblEnquiry")
public class Enquiry
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int enquiryID;
	private String name;
	private String email;
	private String message;
	
	
	public Enquiry()
	{

		
	}
	
	public Enquiry(int enquiryID, String name, String email, String message)
	{
		this.enquiryID = enquiryID;
		this.name = name;
		this.email = email;
		this.message = message;
	
	}
	
	public void setEnquiryID(int enquiryID)
	{
		this.enquiryID = enquiryID;
	}
	
	public int getEnquiryID()
	{
		return enquiryID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
		
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return email;
	}
	
		
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}