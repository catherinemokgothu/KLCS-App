import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.product.ItemServices;
import za.ac.tut.login.Login;
import za.ac.tut.product.Items;
import za.ac.tut.login.LoginService;
import za.ac.tut.person.Person;
import java.util.List;
import java.io.IOException;

public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		String selection = request.getParameter("login_submitted");
		LoginService servLogin = new LoginService();
		try
		{
			if(selection.equals("Login"))
			{
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				servLogin.open();
				
				Login login = servLogin.validateLogin(username,password);
				servLogin.close();
				HttpSession session = request.getSession(true);
				ItemServices itemServ = new ItemServices();
				
				if(login != null && login.getRole().equals("Client"))
				{
					session.setAttribute("login",login);
					
					
					try
					{
						itemServ.open();
						List<Items>  listItems = itemServ.retrieveAllItems();
						request.setAttribute("listItems",listItems);
						request.getRequestDispatcher("cataloque.jsp").forward(request,response);
					}
					catch(Exception ex)
					{
						response.getWriter().println("Error occured " + ex.getMessage());
					}
					finally
					{
						try
						{
							itemServ.close();
						}
						catch(Exception ex)
						{
							response.getWriter().println("Error occured " + ex.getMessage());
						}
					}
					
				}
				else if(login != null && login.getRole().equals("Admin"))
				{
					try
					{
						itemServ.open();
						List<Items>  listItems = itemServ.retrieveAllItems();
						request.setAttribute("listItems",listItems);
						request.getRequestDispatcher("testCataloque.jsp").forward(request,response);
					
					}
					catch(Exception ex)
					{
						response.getWriter().println("Error occured " + ex.getMessage());
					}
					finally
					{
						try
						{
							itemServ.close();
						}
						catch(Exception ex)
						{
							response.getWriter().println("Error occured " + ex.getMessage());
					
						}
					}
					
				}
				
				
			}
		}
		catch(Exception ex)
		{
			response.getWriter().println("Error occured " + ex.getMessage());
		}
	}

	
	
}