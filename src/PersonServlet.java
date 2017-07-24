import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.person.Person;
import za.ac.tut.person.Client;
import za.ac.tut.login.Login;
import za.ac.tut.person.Enquiry;
import za.ac.tut.service.PersonService;
import za.ac.tut.person.Address;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.util.List;

public class PersonServlet extends HttpServlet
{	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PersonService servicePerson = new PersonService();
		try
		{
			servicePerson.open();
			List<Person> listPerson = servicePerson.getAllPerson();
			request.setAttribute("listPerson", listPerson);
			request.getRequestDispatcher("viewAllClient.jsp").forward(request,response);
			
		}
		catch(Exception ex)
		{
			response.getWriter().print("Error occured "+ ex.getMessage());
		}
		finally
		{
			try
			{
				servicePerson.close();
			}
			catch(Exception ex)
			{
				response.getWriter().print("Error occured "+ ex.getMessage());
			}
		}
	}


	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{	
		String selection = request.getParameter("submit1");
		PersonService servicePerson = new PersonService();
		RequestDispatcher dispatcher = null;
		
		try
		{
			Address address = new Address();
			Client client = new Client();
			servicePerson.open();
			if(selection.equals("Submit Registration"))
			{
				
				address.setResidentialAddress(request.getParameter("residentialAddress"));
				address.setTown(request.getParameter("town"));
				address.setAreaCode(Integer.parseInt(request.getParameter("areaCode")));
				
				client.setTitle(request.getParameter("title"));
				client.setName(request.getParameter("name"));
				client.setSurname(request.getParameter("surname"));
				client.setGender(request.getParameter("gender"));
				client.setDateOfBirth(request.getParameter("dateOfBirth"));
				client.setIdNo(request.getParameter("idNo"));
				client.setEmailAddress(request.getParameter("emailAddress"));
				client.setConfirmPassword(request.getParameter("confirmPassword"));
				client.setAddress(address);
				Login login = new Login();
				login.setPassword(request.getParameter("password"));
				login.setUsername(request.getParameter("username"));
				login.setRole("Client");
				client.setLogin(login);
	
				servicePerson.registerClient(client);
				response.getWriter().print("<script type=\"text/javascript\">alert('You are successfully registered');</script>)");
				dispatcher = request.getRequestDispatcher("register.html");
				dispatcher.include(request,response);
				
			}
			else if(selection.equals("Send Enquiry"))
			{
				response.getWriter().print("<script type=\"text/javascript\">alert('You are successfully registered');</script>)");
				Enquiry enquiry = new Enquiry();
				enquiry.setName(request.getParameter("myname"));
				enquiry.setEmail(request.getParameter("myemail"));
				enquiry.setMessage(request.getParameter("mymessage"));
				
				servicePerson.addEnquiry(enquiry);
				request.getRequestDispatcher("successEnquiry.jsp").forward(request,response);
					
			}

		}
		catch(Exception ex)
		{
			response.getWriter().println("Error Occured  " + ex.getMessage());
		} 
		finally
		{
			try
			{
				servicePerson.open();
			}
			catch(Exception ex)
			{
				response.getWriter().println("Error Occured  " + ex.getMessage());
			}
		
		}

	}
}