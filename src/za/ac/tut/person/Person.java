/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.person;

import za.ac.tut.person.Address;
import za.ac.tut.login.Login;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

/**
 *
 * @author LAB1017PCLEC
 */
 @Entity
 @Inheritance(strategy=InheritanceType.JOINED)
 @DiscriminatorColumn(name="subType")
 @Table(name="tblperson")
public class Person 
{
	@Id
	@Column(name="personID")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String title;
    private String name;
	private String surname;
	private String gender;
	private String dateOfBirth;
	private String idNo;
	public String emailAddress;
	private String confirmPassword;
	
	
	@OneToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="fkAddressID")
	private Address address;
	
	@OneToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="fkLoginID")
	private Login login;

    public Person() {
    }

    
   	public Person(int id,String title ,String name ,String surname ,String gender,String dateOfBirth,String idNo,String emailAddress,String confirmPassword,Address address,Login login)
	{
		this.id = id;
		this.title = title;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.idNo = idNo;
		this.emailAddress = emailAddress;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.login = login;
	
	}
	
	public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
       this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setSurname(String surname)
	{
		 this.surname = surname;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
		
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	public  void setIdNo(String idNo)
	{
		this.idNo = idNo;
	}
	
	public  String getIdNo()
	{
		return idNo;
	}
	
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	
	public  void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
	
	
	public  String getConfirmPassword()
	{
		return confirmPassword;
	}
	
	public Login getLogin()
	{
		return login;
	}
	
	public void setLogin(Login login)
	{
		this.login = login;
	}
	
	
	
	
    
            
}
