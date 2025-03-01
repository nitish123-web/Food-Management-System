<%@page import="com.model.Customer"%>
<%@page import="com.dao.CustomerImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%@ include file="header.jsp" %>
<%
  CustomerImpl cd=new CustomerImpl();
  Customer c=cd.get_customerbyemail(c_email);
%>
<form action="customer" method="post" onsubmit="return customer()" align="center">

 <input type="hidden" id="c_email" name="c_email" value="<%=c.getC_email()%>">
 
 <table border="1" align="center" style="margin-top: 1rem">
  <caption style="color: crimson"><h1>EditProfile</h1></caption>
  <tr>
    <td><label for="c_name">Enter Name:</label></td>
    <td><input type="text" id="c_name" name="c_name" placeholder="Enter Name" value="<%=c.getC_name()%>"></td>
    <td><span id="n_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="c_con">Enter Contact:</label></td>
    <td><input type="tel" id="c_con" name="c_con" placeholder="Enter Contact" value="<%=c.getC_contact()%>"></td>
    <td><span id="c_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="c_add">Enter Address:</label></td>
    <td><input type="text" id="c_add" name="c_add" placeholder="Enter Address" value="<%=c.getC_address()%>"></td>
    <td><span id="a_error" style="color: red"></span></td>
  </tr>
 </table>
  <button type="submit" name="action" value="update">submit</button>
  <button type="reset">clear</button>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>