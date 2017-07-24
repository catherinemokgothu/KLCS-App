/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.person;
import  za.ac.tut.login.Login;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;

/**
 *
 * @author LAB1017PCLEC
 */
 @Entity
 @DiscriminatorValue("Client")
 @Table(name="tblclient")
public class Client extends Person
{
	@Id
	@Column(name="personID")
    private int clientID;

    public Client() {
		super();
    }

    public Client(int id,int clientID,String title,String name, String surname,String gender,String dateOfBirth,String idNo,String emailAddress,String confirmPassword, Address address,Login login)
    {
		super(id,title , name , surname , gender, dateOfBirth, idNo,emailAddress, confirmPassword, address,login);
		this.clientID = clientID;
	
	}

    public int getClientID() {
        return clientID;
    }

    public void setStudentNo(int clientID) {
        this.clientID = clientID;
    }
    
    
  
    
}
