<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
  <title>Cataloque page</title>
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
		<h3 align="center">List Of All Items</h3>
		

			
				<form name="form3" action="item.do" method="post">
				
			   <%
               java.util.List<za.ac.tut.product.Items> itemList = (java.util.List<za.ac.tut.product.Items>)session.getAttribute("listItems");

               
                if (itemList != null) 
				{
               %>
				 <table class="fixed" align="center">

                        <col width="200px" />
                        <col width="150px" />
                        <col width="200px" />
                        <col width="100px" />
                        <col width="100px" />

                        <tr>
							<td><center><strong>SELECT </strong></center></td>
							<td><center><strong>PICTURES(S)</strong></center></td>
							<td><center><strong>DESCRIPTION</strong></center></td>
							<td><center><strong>COST</strong></center></td>

                        </tr>
                        <%
                            for (za.ac.tut.product.Items item : itemList) {
                        %>
                        <col width="300px" />
                        <col width="250px" />
                        <col width="300px" />
                        <col width="200px" />
                        <col width="200px" />
                        <tr>
                            <td><center><input type="radio" name="productid" id="productid" value="<%=item.getItemID()%>"></center></td>
							<td><center><%=item.getItemImage()%></center></td>
							<td><center><%=item.getItemDescription()%></center></td>
							<td><center><%=item.getItemPrice()%></center></td>
                        </tr>

                        <%
                                }

                            }
                        %>
                    </table>    
					<p><center><input type="submit" name="select" id="select" value="Delete Item"/> </center></p></br>
			</form>
		
		</article>	
		
  <div id="footer">
		website designed by Catherine Mokgothu Student Number 212266825
  </div><!--close footer--> 
  
 
  
</body>
</html>
