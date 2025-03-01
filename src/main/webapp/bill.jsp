<%@page import="com.model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%@ include file="header.jsp" %>
<form class="main" align="center">
<%Order od=(Order)request.getAttribute("order"); %>
OrderId:<%=od.getO_id() %><br>
EmailId:<%=od.getC_email() %><br>
TotalPrice:<%=od.getT_price() %><br>
Date:<%=od.getO_date() %>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>