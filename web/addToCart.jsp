<%@page import="za.ac.tut.cart.ShoppingCart"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">



<head>
  <title>View Product page</title>
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
			<li><a href="login.html">Logout</a></li>
			<li><a href="viewProduct.html">Our Product</a></li>
			<li><a href="enquiry.html">Enquiry</a></li>
        </ul>
		</nav>
      </div><!--close menu-->
    </div><!--close menubar-->	
	
	    
	<article>
		<h3 align="center">HIRE / BUY OUR PRODUCT</h3>
			<%
                ShoppingCart cartObj = (ShoppingCart)session.getAttribute("shoppingCart");
              
                if (!cartObj.getList().isEmpty()) 
				{
           %>
				<form name="form3" action="item.do" method="post">
				<table class="fixed" align="center">
					<h1 align="center"> Number of Items : <%=cartObj.getList().size()%></h1>
					<h1> Total : R<%=cartObj.total()%></h1>
					<col width="300px" />
					<col width="250px" />
					<col width="130px" />
					<col width="130px" />
					<col width="130px" />
					
						<tr>
						<td><center><strong>SELECT</strong></center></td>
						<td><center><strong>PICTURE</strong></center></td>
						<td><center><strong>DESCRIPTION</strong></center></td>
						<td><center><strong>PRICE</strong></center></td>
						</tr>
						
						<%
							for(int x = 0 ; x < cartObj.getList().size(); x++)
							{
						%>
						
						<tr>
							<td><center><input type="checkbox" name="productid" value="<%=cartObj.getList().get(x).getItemID()%>"/></center></td>
							<td><center><%=cartObj.getList().get(x).getItemImage()%></center></td>
							<td><center><%=cartObj.getList().get(x).getItemDescription()%></center></td>
							<td><center><%=cartObj.getList().get(x).getItemPrice()%></center></td>
						</tr>
						<%
							}
				}
				%>
				</table>
				<tr>
					<p><input type="submit" name="select" id="select" value="Back<<<"/> <input  type="submit" name="select" id="select" value="Remove From Cart" /> <input type="submit" name="select" id="select" value="Process" /></p>
				</tr>
			</form>
		
		</article>
	
	
  
	
  <div id="footer">
		website designed by Catherine Mokgothu Student Number 212266825
  </div><!--close footer--> 
  
 
  
</body>
</html>
