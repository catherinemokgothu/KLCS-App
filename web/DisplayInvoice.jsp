<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
  <title>Invoice page</title>
  <meta name="description" content="catherine website" />
  <meta name="keywords" content="enter your keywords here" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.easing.min.js"></script>
  <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
  <script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
  </script> 
</head>

<body>
  <div id="main">
	<div id="menubar">
	  <div id="welcome">
	    <h2><a href="#">Welcome To KLCS</a></h2>
	  </div><!--close welcome-->
      <div id="menu_items">
	 
	<nav>
	    <ul id="menu">
			<li><a href="index.html">Logout</a></li>
			<li><a href="removeFromCart.jsp">Remove</a></li>
			<li><a href="viewAllClient.jsp">All Clients</a></li>
			<li><a href="ViewEnquiry.jsp">Enquiry</a></li>
			<li><a href="admin_update.jsp">Update</a></li>
			<li><a href="DisplayInvoice.jsp">Invoice</a></li>
			</ul>
		</nav>
      </div><!--close menu-->
    </div><!--close menubar-->	
	
	    
	<article>
		<h3 align="center">HIRE / BUY OUR PRODUCT</h3>
		

			
				<form name="form3" action="person.do" method="post">
				
				<%
                    java.util.List<za.ac.tut.cart.ShoppingCart> cartList = (java.util.List<za.ac.tut.cart.ShoppingCart>)request.getAttribute("listItems");
                    java.util.List<za.ac.tut.person.Person> personList = (java.util.List<za.ac.tut.person.Person>)request.getAttribute("listPerson");

                %>



                <%
				if (!personList.isEmpty()) 
				{
				
				%>
					<h1>Overall Invoice.</h1>

				<%
				for (int y = 0; y < cartList.size(); y++) 
				{
				%>
                <table class="fixed" align="center">
				<textarea cols="125" rows="20" align="center" disabled="true" >
					 Booking Invoice
					 ---------------
					 Title        :<%=personList.get(y).getTittle()%>  
					 Full Name    :<%=personList.get(y).getName()%>
					 Surname   :<%=personList.get(y).getSuname()%>  
					 ID Number    :<%=personList.get(y).getIdNo()%>
					 Gender       :<%=personList.get(y).getGender()%>  
					 Email        :<%=personList.get(y).getEmail()%>
					 Items        :<%=personList.get(y).getItemDescription()%>  R:<%=cartList.get(y).getItemPrice()%> 
					 Type Of Room     :<%=list.get(y).getTypeOfroom()%>
					
					-----------------------------------
					 Total Amount     : =>R<%=personList.get(y).total()%>
					-----------------------------------
               </textarea>
               </table>
                <%
				}
				%>
				<%} 
				else 
				{%>

                <h1>No Results Found!</h1>
                <table>
                    <tr><td>
                            Invoice not created
                        </td></tr>
                </table>
				<%
				}
				%>
     
			</form>
		
		</article>
	
	
  
	
  <div id="footer">
		website designed by Catherine Mokgothu Student Number 212266825
  </div><!--close footer--> 
  
 
  
</body>
</html>
