<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%@ include file="header.jsp" %>
 <form action="login" method="post" onsubmit="return login()" align="center">
   <table border="1" style="margin-top: 2rem" align="center">
     <caption style="color: crimson"><h1>Log-in</h1></caption>
     
     <tr>
      <td><label for="type">select type:</label></td>
      <td>
        <select id="type" name="type">
          <option>select</option>
          <option value="user">user</option>
          <option value="admin">admin</option>
        </select>
      </td>
      <td><span id="s_error" style="color: red"></span></td>
     </tr>
     
     <tr>
     <td><label for="email">Enter Email:</label></td>
     <td><input type="email" id="email" name="email" placeholder="Enter Email"></td>
     <td><span id="e_error" style="color: red"></span></td>
     </tr>
  
     <tr>
     <td><label for="pass">Enter Password:</label></td>
     <td><input type="password" id="pass" name="pass" placeholder="Enter Password"></td>
     <td><span id="p_error" style="color: red"></span></td>
    </tr>
   </table>
   <button type="submit" name="action" value="login">submit</button>
   <button type="reset">clear</button>
 </form>
<%@ include file="footer.jsp" %> 
</body>
</html>