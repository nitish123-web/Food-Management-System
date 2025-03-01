<%@page import="com.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%List<Customer> list=(List)session.getAttribute("c_list"); %>
<%@ include file="header.jsp" %>
 <table border="1" style="margin-top: 2rem" align="center">
   <caption style="color: crimson"><h1>CustomerList</h1></caption>
   
   <tr>
     <th>Name</th>
     <th>Email</th>
     <th>Password</th>
     <th>Contact</th>
     <th>Address</th>
     <th>Action</th>
   </tr>
   <% for(Customer c:list){ %>
   
   <tr>
     <td><%=c.getC_name() %></td>
     <td><%=c.getC_email() %></td>
     <td><%=c.getC_pass()%></td>
     <td><%=c.getC_contact()%></td>
     <td><%=c.getC_address()%></td>
     <td>
       <a href="customer?action=delete&c_email=<%=c.getC_email()%>" style="color: red;text-decoration: none;">delete</a>
     </td>
   </tr>
   <%}%>
 </table>
 <%@ include file="footer.jsp" %>
</body>
</html>