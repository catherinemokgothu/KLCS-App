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
		<h3 align="center">HIRE / BUY OUR PRODUCT</h3>
		

			
				<form name="form3" action="item.do" method="post">
				
			   <%
               java.util.Vector<za.ac.tut.product.Items> list = (java.util.Vector<za.ac.tut.product.Items>)request.getAttribute("listItems");

               
                if (list != null) 
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
                            for (int y = 0; y < list.size(); y++) {
                        %>
                        <col width="300px" />
                        <col width="250px" />
                        <col width="300px" />
                        <col width="200px" />
                        <col width="200px" />
                        <tr>
                            <td><center><input type="checkbox" name="productid" id="productid" value="<%=list.get(y).getItemID()%>"></center></td>
							<td><center><%=list.get(y).getItemImage()%></center></td>
							<td> <center><%=list.get(y).getItemDescription()%></center></td>
							<td><center><%=list.get(y).getItemPrice()%></center></td>
                        </tr>

                        <%
                                }

                            }
                        %>
                    </table>
					
					<p><center>Item Description :<input type="text" name="itemdescription" required /></p></center>
					<p><center>Item Quantity :<input type="text" name="itemqty" required"/></p></center>
					<p><center>Item Price:<input type="text" name="itemprice" required /></p></center>
					<p><center>Import Item Picture :<input type="file" value="picture" name="picture"></p></center>
					<p><center><input type="submit" name="select" id="select" value="Add New Product"/> </center></p></br>
						
                    
			</form>
		
		</article>	
		
  <div id="footer">
		website designed by Catherine Mokgothu Student Number 212266825
  </div><!--close footer--> 
  
 
  
</body>
</html>
