<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%@ include file="header.jsp" %>
<form action="customer" method="post" onsubmit="return customer()" align="center">
 <table border="1" style="margin-top: 2rem" align="center">
  <caption style="color: crimson"><h1>Registration</h1></caption>
  
  <tr>
    <td><label for="c_name">Enter Name:</label></td>
    <td><input type="text" id="c_name" name="c_name" placeholder="Enter Name"></td>
    <td><span id="n_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="c_email">Enter Email:</label></td>
    <td><input type="email" id="c_email" name="c_email" placeholder="Enter Email"></td>
    <td><span id="e_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="c_pass">Enter Password:</label></td>
    <td><input type="password" id="c_pass" name="c_pass" placeholder="Enter Password"></td>
    <td><span id="p_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="c_con">Enter Contact:</label></td>
    <td><input type="tel" id="c_con" name="c_con" placeholder="Enter Contact"></td>
    <td><span id="c_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="c_add">Enter Address:</label></td>
    <td><input type="text" id="c_add" name="c_add" placeholder="Enter Address"></td>
    <td><span id="a_error" style="color: red"></span></td>
  </tr>
 </table>
  <button type="submit" name="action" value="add">submit</button>
  <button type="reset">clear</button>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>