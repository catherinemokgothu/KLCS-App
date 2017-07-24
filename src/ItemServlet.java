import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import za.ac.tut.product.ItemServices;
import za.ac.tut.product.Items;
import za.ac.tut.cart.ShoppingCart;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
//import java.time.LocalDateTime;
import za.ac.tut.person.Person;
import za.ac.tut.product.Items;
import za.ac.tut.person.PersonService;
import java.io.PrintWriter;

import java.util.List;

public class ItemServlet extends HttpServlet
{
	
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			ItemServices serviceItem = new ItemServices();
			PersonService servicePerson = new PersonService();
			
			try
			{
				serviceItem.open();
				HttpSession session = request.getSession();
				List<Items> listItems = serviceItem.retrieveAllItems();
				request.setAttribute("listOfitems",listItems);
				request.getRequestDispatcher("cataloque.jsp").forward(request,response);
				
			}
			catch(Exception ioe)
			{
				response.getWriter().println("Error Occured " + ioe.getMessage());
			}
			finally
			{
				
				try
				{
					serviceItem.close();
				}
				catch(Exception err)
				{
					response.getWriter().println("Error Occured " + err.getMessage());
				}
				
			}
			
		}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException
		{
			ItemServices itemObj = new ItemServices();
			String selection = request.getParameter("select");
			
			try
			{
				itemObj.open();
				HttpSession session = request.getSession(true);
			  
				ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");

				if (shoppingCart == null) 
				{
					shoppingCart = new ShoppingCart();
				}
				
				if (selection.equals("Add to cart")) 
				{
					String[] items = request.getParameterValues("productid");
					
					for(int x = 0; x < items.length; x++)
					{
						String itemIdNo = items[x];
						shoppingCart.addItem(itemObj.getItem(Integer.parseInt(itemIdNo)));
					
					}
					session.setAttribute("shoppingCart", shoppingCart);
					request.getRequestDispatcher("addToCart.jsp").forward(request,response);
					
				}
				else if(selection.equals("Remove From Cart"))
				{
					String[] items = request.getParameterValues("productid");
					
					for(int x = 0; x < items.length; x++)
					{
						String itemIdNo = items[x];
						shoppingCart.removeItem(Integer.parseInt(itemIdNo));
					
					}
					session.setAttribute("shoppingCart", shoppingCart);
					response.getWriter().print("<script type=\"text/javascript\">alert('You  successfully removed from cart');</script>)");
					request.getRequestDispatcher("addToCart.jsp").forward(request,response);
				}
				else if(selection.equals("Back<<<"))
				{
					String[] items = request.getParameterValues("productid");
					
					for(int x = 0; x < items.length; x++)
					{
						String itemIdNo = items[x];
						shoppingCart.addItem(itemObj.getItem(Integer.parseInt(itemIdNo)));
					
					}
					session.setAttribute("shoppingCart", shoppingCart);
					request.getRequestDispatcher("cataloque.jsp").forward(request,response);
				}
				else if(selection.equals("Add New Product"))
				{
					Items item = new Items();
					item.setItemDescription(request.getParameter("itemdescription"));
					item.setItemQty(Integer.parseInt(request.getParameter("itemqty")));
					item.setItemPrice(Double.parseDouble(request.getParameter("itemprice")));
					
					String image = "<img src=images/" + (request.getParameter("picture")) + " class=img-circle alt=cinque Terre" + "  width=150" + " height=150>";
					item.setItemImage(image);
					
					itemObj.saveItem(item);
					response.getWriter().print("<script type=\"text/javascript\">alert('You  successfully Added new Item');</script>)");
					request.getRequestDispatcher("displayAllItems.jsp").forward(request,response);
				}
				else if(selection.equals("View All Product"))
				{
					List<Items> listItems = itemObj.retrieveAllItems();
					session.setAttribute("listItems",listItems);
					request.getRequestDispatcher("listOfAllItems.jsp").forward(request,response);
				}
				else if(selection.equals("Delete Item"))
				{
					itemObj.deleteItems(Integer.parseInt(request.getParameter("productid")));
					String message = "Record is deleted !!";
					request.setAttribute("message", message);
					request.getRequestDispatcher("successDelete.jsp").forward(request,response);
				}
				else if(selection.equals("Back<<<<"))
				{
					List<Items> listItems = itemObj.retrieveAllItems();
					session.setAttribute("listItems",listItems);
					request.getRequestDispatcher("removeFromCart.jsp").forward(request,response);
				}
				else if(selection.equals("Update"))
				{
					Items items = new Items();
					items.setItemQty(Integer.parseInt(request.getParameter("itemqty")));
					items.setItemPrice(Double.parseDouble(request.getParameter("itemprice")));
					
					
					itemObj.updateItems(items);
					String message = "Record is sucessfully updated !!";
					request.setAttribute("message", message);
					request.getRequestDispatcher("successUpdate.jsp").forward(request,response);
				}
				else if(selection.equals("<<<<<Back"))
				{
					List<Items> listItems = itemObj.retrieveAllItems();
					session.setAttribute("listItems",listItems);
					request.getRequestDispatcher("admin_update.jsp").forward(request,response);
				}
				else if(selection.equals("Process"))
				{
					
					OutputStream output = new FileOutputStream(new File("C:\\Users\\Katelicius\\Downloads\\slip.pdf"));
					Document document = new Document();
					response.setContentType("images/pdf");
					PdfWriter.getInstance(document, output);
					document.open();
					
					document.addTitle("Khona Lana Construction Servicese[] Payment Slip");
					document.add(new Paragraph("Items Brought"));
					document.add(new Paragraph("---------------"));
					
					for(int  x = 0; x < shoppingCart.getList().size(); x++)
					{
						document.add(new Paragraph(shoppingCart.getList().get(x).getItemDescription() + " R" + shoppingCart.getList().get(x).getItemPrice()));
					}
					document.add(new Paragraph("Total Price :R" + Double.toString(shoppingCart.total())));
					
					document.add(new Paragraph("Catherine"));
					document.close();
					output.close();
					
					session.invalidate();
					response.sendRedirect("index.html");
					
				}
					
		}
		catch (Exception ex)
		{
				response.getWriter().print("Exception occured 1 nnnnn " + ex.getMessage());
		 
		}
		finally
		{
			try
			{
				itemObj.close();
			}
			catch(Exception ex)
			{
				response.getWriter().print("Exception occured 2 " + ex.getMessage());

			}
		}
	}
}