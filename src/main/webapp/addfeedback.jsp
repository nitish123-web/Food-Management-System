<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
 <%@ include file="header.jsp" %>
<form action="feedback" method="post" onsubmit="return feedback()" align="center">
 
 <input type="hidden" id="c_email" name="c_email" value="<%=c_email%>">
 
 <table border="1" align="center" style="margin-top: 1rem">
  <caption style="color: crimson"><h1>Add FeedBack</h1></caption>
  
  <tr>
    <td><label for="review">Enter Review:</label></td>
    <td><input type="text" id="review" name="review" placeholder="Enter Review"></td>
    <td><span id="r_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="advice">Enter Advice:</label></td>
    <td><input type="text" id="advice" name="advice" placeholder="Enter Advice"></td>
    <td><span id="a_error" style="color: red"></span></td>
  </tr>
  
  <tr>
    <td><label for="rank">Enter Rank:</label></td>
    <td><input type="number" id="rank" name="rank" max="5" min="1" ></td>
    <td><span id="r_error" style="color: red"></span></td>
  </tr>
 </table>
  <button type="submit" name="action" value="add">submit</button>
  <button type="reset">clear</button>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>