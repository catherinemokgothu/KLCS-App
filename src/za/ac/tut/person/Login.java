package za.ac.tut.login;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Login implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
	private String username;
	private String password;
	private String role;
	
	public Login()
	{
	
	}
	
	public Login(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public Login(int userID, String username, String password,String role)
	{
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	
	public int getUserID()
	{
		return userID;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword()
	{
		return password;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getRole()
	{
		return role;
	}
	
	

}