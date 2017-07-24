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
			<li><a href="#">Logout</a></li>
			<li><a href="login.html">Rent Items</a></li>
			<li><a href="viewProduct.html">Our Product</a></li>
			<li><a href="enquiry.html">Enquiry</a></li>
        </ul>
		</nav>
      </div><!--close menu-->
    </div><!--close menubar-->	
	
	    
	<article>
		<h3 align="center">Our specials</h3>
			<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
			<c:choose>
			<c:when test = "${sessionScope.login != nul}">
				<c:choose>
					<c:when test = "${sessionScope.login.role=='Client'}">
		
						<form name="form3"action="item.do" method="post">
						<table class="fixed" align="center">
					
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
						<c:forEach var="item" items="${sessionScope.listItems}">
						<tr>
							<td><center><input type="checkbox" name="itemno" value="${item.itemID}"></center></td>
							<td><center>${item.itemImage}</center></td>
							<td><center>${item.itemDescription}</center></td>
							<td><center>${item.itemPrice}</center></td>
						</tr>
						</c:forEach>
					
					</table>
					<tr>
						<button name="select"  id="select" value="ADD_TO_CART">Add to Cart</button>
					</tr>
			</form>
		</c:when>
		<c:otherwise>
			<jsp.foward page="login.html">
		</c:otherwise>
		</c:choose>
		</c:when>
		<c:otherwise>
			<jsp.foward page="login.html">
		</c:otherwise>
		</c:choose>
		</article>
	
	
  
	
  <div id="footer">
		website designed by Catherine Mokgothu Student Number 212266825
  </div><!--close footer--> 
  
 
  
</body>
</html>
