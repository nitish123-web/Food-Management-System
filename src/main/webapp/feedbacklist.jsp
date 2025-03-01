<%@page import="com.model.Feedback"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%List<Feedback> list=(List)session.getAttribute("f_list"); %>
<%@ include file="header.jsp" %>
 <table border="1" style="margin-top: 2rem" align="center">
   <caption style="color: crimson"><h1>FeedBackList</h1></caption>
   
   <tr>
     <th>Email</th>
     <th>Review</th>
     <th>Advice</th>
     <th>Rank</th>
     <th>Action</th>
   </tr>
   <% for(Feedback f:list){ %>
   
   <tr>
     <td><%=f.getC_email()%></td>
     <td><%=f.getReview()%></td>
     <td><%=f.getAdvice()%></td>
     <td><%=f.getRank()%></td>
     <td>
       <a href="feedback?action=delete&c_email=<%=f.getC_email()%>" style="color: red;text-decoration: none;">delete</a>
     </td>
   </tr>
   <%}%>
 </table>
 <%@ include file="footer.jsp" %>
</body>
</html>