<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
  <title>View All page</title>
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
		<h3 align="center">Records of All Registered Customers</h3>
		<h3 align="center">----------------------------------------------=</h3>
				
			   <%
               java.util.List<za.ac.tut.person.Person> personList = (java.util.List<za.ac.tut.person.Person>)request.getAttribute("listPerson");

               
                if (personList != null) 
				{
               %>
				 <table class="fixed" align="center">

                        <col width="300px" />
                        <col width="250px" />
                        <col width="300px" />
                        <col width="200px" />
                        <col width="200px" />

                        <tr>
							<td><center><strong>Select </strong></center></td>
							<td><center><strong>Title</strong></center></td>
							<td><center><strong>Gender </strong></center></td>
							<td><center><strong>Name</strong></center></td>
							<td><center><strong>Surname</strong></center></td>
							<td><center><strong>Id No</strong></center></td>
							<td><center><strong>Email Address</strong></center></td>

                        </tr>
                        <%
                        for (int x = 0 ; x < personList.size(); x++) 
						{
							Person person = personList.get(x);
                        %>
                        <col width="300px" />
                        <col width="250px" />
                        <col width="300px" />
                        <col width="200px" />
                        <col width="200px" />
                        <tr>
                            <td><center><input type="radio" name="personid" id="personid" value="<%=person.getId()%>"></center></td>
							<td><center><%=person.getTitle()%></center></td>
							<td><center><%=person.getGender()%></center></td>
							<td> <center><%=person.getName()%></center></td>
							<td><center><%=person.getSurname()%></center></td>
							<td><center><%=person.getIdNo()%></center></td>
							<td><center><%=person.getEmailAddress()%></center></td>
                        </tr>

                        <%
                                }

                            }
                        %>
		</article>
	
	
  
	
  <div id="footer">
		website designed by Catherine Mokgothu Student Number 212266825
  </div><!--close footer--> 
  
 
  
</body>
</html>
