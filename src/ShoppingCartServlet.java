import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import za.ac.tut.product.ItemServices;
import za.ac.tut.product.Items;
import za.ac.tut.cart.ShoppingCart;
import java.io.IOException;

import java.util.List;
import za.ac.tut.login.*;


public class ShoppingCartServlet extends HttpServlet
{
	
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
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
					
					if(login != null)
					{
						session.setAttribute("login",login);
						ItemServices itemServ = new ItemServices();
						
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
					
				}
			}
			catch(Exception ex)
			{
				response.getWriter().println("Error occured " + ex.getMessage());
			}		
			
			}
			
			public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException
			{
				ItemServices itemObj = new ItemServices();
				HttpSession session = request.getSession();

				String parameter = request.getParameter("select");
				
				
				try
				{	
					ShoppingCart basket = (ShoppingCart)session.getAttribute("basket");
					
					if (basket == null)
					{					
						 basket = new ShoppingCart();
					}
					
					if(parameter.equals("Add to cart"))
					{
						String[] listOfitems = request.getParameterValues("productid");
						for (String productID:listOfitems)
						{
							basket.addItem(itemObj.getItem(Integer.parseInt(productID)));
						}
						session.setAttribute("basket",basket);
						//request.getRequestDispatcher("addToCart.jsp").forward(request,response);
						response.getWriter().print("Please work");
						
					}
						
					/*
					switch (parameter)
					{
						case "Add to cart":
						
							String[] items = request.getParameterValues("itemno");
							ShoppingCart shoppingCurt = (ShoppingCart)session.getAttribute("shoppingCurt");
							if (shoppingCurt == null) {
								shoppingCurt = new ShoppingCart();

							}
							for (String item1 : items) {
								Items item = itemObj.getItem(Integer.parseInt(item1));
								shoppingCurt.addItems(item);
							}
							session.setAttribute("shoppingCurt", shoppingCurt);
							request.getRequestDispatcher("addToCart.jsp").forward(request, response);
							
							break;
						
						case "Remove_From_Cart":
							ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCurt");
							if (shoppingCart != null) {
								String[] removeItems = request.getParameterValues("itemno");
								for (String removeItem : removeItems) {
									int intIndex = Integer.parseInt(removeItem);
									shoppingCart.removeItems(intIndex);
								}
							}
							session.setAttribute("shoppingCurt", shoppingCart);
							RequestDispatcher dispatcher = request.getRequestDispatcher("addToCart.jsp");
							dispatcher.forward(request, response);
							break;*/
					

				} 
				catch (Exception ex)
				{
					response.getWriter().print("Exception occured" + ex.getMessage());
				} 
			}
}