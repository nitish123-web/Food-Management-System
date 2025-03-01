<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<% String type=(String)session.getAttribute("type"); %>
 <%@ include file="header.jsp" %>
 <form action="login" method="post" onsubmit="return login()" align="center">
  
  <input type="hidden" id="type" name="type" value="<%=type%>">
  
  <%if(c_email!=null && a_email==null){ %>
  <input type="hidden" id="email" name="email" value="<%=c_email%>">
  <%}%>
  
  <%if(c_email==null && a_email!=null){ %>
  <input type="hidden" id="email" name="email" value="<%=a_email%>">
  <%}%>
  
   <table border="1" style="margin-top: 2rem" align="center">
     <caption style="color: crimson"><h1>Change-Password</h1></caption>
     
     <tr>
     <td><label for="o_pass">Old Password:</label></td>
     <td><input type="password" id="o_pass" name="o_pass" placeholder="Enter Old Password"></td>
     <td><span id="o_error" style="color: red"></span></td>
     </tr>
     
     <tr>
     <td><label for="n_pass">New Password:</label></td>
     <td><input type="password" id="n_pass" name="n_pass" placeholder="Enter New Password"></td>
     <td><span id="n_error" style="color: red"></span></td>
    </tr>
    
    <tr>
     <td><label for="c_pass">Confirm Password:</label></td>
     <td><input type="password" id="c_pass" name="c_pass" placeholder="Enter Confirm Password"></td>
     <td><span id="c_error" style="color: red"></span></td>
    </tr>
    
   </table>
   <button type="submit" name="action" value="change">submit</button>
   <button type="reset">clear</button>
 </form>
<%@ include file="footer.jsp" %> 
</body>
</html>