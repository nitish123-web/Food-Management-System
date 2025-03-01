package com.controller;

import java.io.IOException;

import com.dao.CartImpl;
import com.dao.OrderImpl;
import com.model.Cart;
import com.model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeorder")
public class OrderController extends HttpServlet {
	
	OrderImpl o=new OrderImpl();
	CartImpl ct=new CartImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String email=(String)session.getAttribute("c_email");
		 float t_price=Float.parseFloat(request.getParameter("price"));
		  Order order=o.place_order(email);
		   order.setT_price(t_price);
		   if(order!=null) {
			  boolean b=ct.clear_cart(email);
			 if(b) {
				 request.setAttribute("order", order);
				 request.getRequestDispatcher("bill.jsp").forward(request, response);	 
	          }else {
				 response.sendRedirect("failed.jsp");
			 }
		 }
	  }	   
}
