<%@page import="com.model.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function total(){
	let t_price=0;
	let isquantity=false;
	let prices=document.getElementsByClassName("f_price");
	let quantities=document.getElementsByClassName("f_quan");
	let totalFields= document.getElementsByClassName("t_price");
	 
	 for (let i = 0; i < prices.length; i++) {
	        let price = parseFloat(prices[i].value);
	        let quantity = parseInt(quantities[i].value);
	        let total = price * quantity;
	        totalFields[i].value = total.toFixed(2);
	        t_price += total;
	        isquantity=true;
	    }
	 
	 if(isquantity){
		 document.getElementById("price").value=t_price;
		 t_price=0;
	  }else{
			for(let i = 0; i < totalFields.length; i++){
				  let price = parseFloat(totalFields[i].value);
				  t_price += price;   
			   }
		 document.getElementById("price").value=t_price;
		  t_price=0;
	  }	 	 	 
}
</script>
</head>
<body>
<%List<Cart> list=(List)session.getAttribute("c_list"); %>
<%@ include file="header.jsp" %>
<form action="placeorder" method="post" align="center">
  <input type="hidden" id="price" name="price">
 <table border="1" style="margin-top: 2rem" align="center">
   <caption style="color: crimson"><h1>Cart</h1></caption>  
   <tr>
     <th>Name</th>
     <th>Price</th>
     <th>Quantity</th>
     <th>Total</th>
     <th>Action</th>
   </tr>
   <% for(Cart c:list){ %> 
    <tr>
     <td><%=c.getF_name() %></td>
     <td><input type="text" class="f_price"  name="f_price" value="<%=c.getF_price() %>" style="width: 64px;" readonly="readonly"></td>
     <td><input type="number" class="f_quan" name="f_quan" value="<%=c.getF_quantity()%>" style="width: 64px; " ></td>
     <td><input type="text" class="t_price" name="t_price" value="<%=c.getT_price()%>"  style="width: 64px; "readonly="readonly"></td> 
     <td>
       <a href="cart?action=delete&c_id=<%=c.getC_id()%>" style="color: red">delete</a>
     </td>  
    </tr>
   <%}%>
 </table>
 <button type="submit" name="action" value="placeorder" onclick="total()">PlaceOrder</button>
 </form>
 <%@ include file="footer.jsp" %>
</body>
</html>