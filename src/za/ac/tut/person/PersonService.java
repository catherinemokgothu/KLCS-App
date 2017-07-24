package za.ac.tut.person;

import java.io.Serializable;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import za.ac.tut.person.Client;
import za.ac.tut.person.Person;
import za.ac.tut.person.Enquiry;
import java.util.List;
import javax.persistence.Query;


public class PersonService  implements Serializable
{	
	EntityManager entityObj;
	EntityManagerFactory factoryObj;
	
	public void open()
	{
		factoryObj = Persistence.createEntityManagerFactory("dataLink");
		entityObj = factoryObj.createEntityManager();
	}
	
	//add the client method
	public void registerClient(Client client) throws Exception
	{
		entityObj.getTransaction().begin();
		entityObj.persist(client);
		entityObj.getTransaction().commit();
	}
	
	//Add Enquiry
	public void addEnquiry(Enquiry enquiry)throws Exception
	{
		entityObj.getTransaction().begin();
		entityObj.persist(enquiry);
		entityObj.getTransaction().commit();
	}
	
	//Method to view all the Enquiry
	public List<Enquiry> viewAllEnquiry()throws Exception
	{
		Query q = entityObj.createQuery("select enquiry from Enquiry enquiry");
		List<Enquiry> listEnquiry = q.getResultList();
		return listEnquiry;
	}
	
	//Method to view Customers
	public List<Client> getAllClient()throws Exception
	{
		Query query = entityObj.createQuery("Select client from Client client");
		List<Client> list = query.getResultList();
		return list;
		
	}
	//get List of Person
	public List<Person> getAllPerson()throws Exception
	{
		Query query = entityObj.createQuery("Select person from Person person ");
		List<Person> listPerson = query.getResultList();
		return listPerson;
		
	}
	
	//get person
	public Person getPerson(int personId)
	{
		Query query = entityObj.createQuery("Select person from Person person where person.id ="+ personId);
		Person person = (Person)query.getResultList().get(0);
		return person;
	}
	
	//Retuen person passed on id
	public List<Person> getPersonList(Person persons)throws Exception
	{
		Query query = entityObj.createQuery("Select person from Person person where person.idNo ="+persons.getIdNo());
		List<Person> listPerson = query.getResultList();
		return listPerson;
		
	}
	
	public void close()
	{
		entityObj.close();
		factoryObj.close();
	}
	
	

}