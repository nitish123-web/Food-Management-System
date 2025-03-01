<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="valid.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<form action="food" method="post" onsubmit="return food()" align="center" style="margin-top: 1rem">
 <table border="1" align="center">
  <caption style="color: crimson"><h1>Add Food</h1></caption>
  
  <tr>
    <td><label for="f_name">Enter Name:</label></td>
    <td><input type="text" id="f_name" name="f_name" placeholder="Enter Name"></td>
    <td><span id="n_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="f_type">Enter Type:</label></td>
    <td><input type="text" id="f_type" name="f_type" placeholder="Enter Type"></td>
    <td><span id="t_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="f_cate">Enter Category:</label></td>
    <td><input type="text" id="f_cate" name="f_cate" placeholder="Enter Category"></td>
    <td><span id="c_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="f_price">Enter Price:</label></td>
    <td><input type="text" id="f_price" name="f_price" placeholder="Enter Price"></td>
    <td><span id="p_error" style="color: red"></span></td>
  </tr>
 </table>
  <button type="submit" name="action" value="add">submit</button>
  <button type="reset">clear</button>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>