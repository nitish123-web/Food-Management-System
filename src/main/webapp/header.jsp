<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
  String c_email=(String)session.getAttribute("c_email");
  String a_email=(String)session.getAttribute("a_email");
%>
 <div id="templatemo_container">
		<div id="templatemo_header">
			<div id="site_title"></div>
		</div>
		<!-- end of header -->

		<div id="templatemo_menu">
		   <%if(a_email==null && c_email==null){ %>
			<ul>
				<li class="current">
				<a href="index.jsp"><b>Home</b></a></li>
				<li><a href="login.jsp"><b>Login</b></a></li>
				<li><a href="addcustomer.jsp"><b>Registration</b></a></li>
				<li><a href="contactus.jsp"><b>Contact</b></a></li>
			</ul>
			<%} %>
			
			 <%if(a_email!=null && c_email==null){ %>
			<ul>	
				<li><a href="food"><b>FoodMenu</b></a></li>
				<li><a href="addfood.jsp"><b>AddFood</b></a></li>
				<li><a href="customer"><b>Customer</b></a></li>
				<li><a href="feedback"><b>Feedback</b></a></li>
				<li><a href="changepass.jsp"><b>ChangePassword</b></a></li>
				<li><a href="login"><b>Logout</b></a></li>
			</ul>
			<%} %>
			 <%if(a_email==null && c_email!=null){ %>
			<ul>
				<li><a href="food"><b>FoodMenu</b></a></li>
				<li><a href="cart"><b>Cart</b></a></li>
				<li><a href="updatecustomer.jsp"><b>EditProfile</b></a></li>
				<li><a href="addfeedback.jsp"><b>Feedback</b></a></li>
				<li><a href="changepass.jsp"><b>ChangePassword</b></a></li>
				<li><a href="login"><b>Logout</b></a></li>
			</ul>
			<%} %>
		</div>
</body>
</html>