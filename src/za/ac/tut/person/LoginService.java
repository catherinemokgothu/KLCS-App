package za.ac.tut.login;

import java.io.Serializable;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import za.ac.tut.person.Person;

public class LoginService implements Serializable
{
	private EntityManagerFactory factory;
	private EntityManager entity;
	
	public void open()throws Exception
	{
		factory = Persistence.createEntityManagerFactory("dataLink");
		entity = factory.createEntityManager();
	}
	
	public Login validateLogin(String username, String password)
	{
		Query query = entity.createQuery("Select login from Login login where login.username ='"+username+"' and login.password ='"+password+"'");
		Login loginObj = (Login)query.getResultList().get(0);
		return loginObj;
	
	}
	
	public void close()throws Exception
	{
		entity.close();
		factory.close();
	}
	
	
	
}