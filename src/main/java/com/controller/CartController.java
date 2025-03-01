package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.CartImpl;
import com.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartController extends HttpServlet{
	
	CartImpl c=new CartImpl();
	boolean b;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		  String action=request.getParameter("action");
		  if(action==null) {
			  String c_email=(String)session.getAttribute("c_email");
			  List<Cart> list = c.show_cart(c_email);
			  if(list!=null && !list.isEmpty()) {
				  session.setAttribute("c_list", list);
				  response.sendRedirect("cartlist.jsp");
			  }else {
				  response.sendRedirect("failed.jsp");
			  }
		  }
		  if(action!=null && action.equals("delete")) {
			int c_id=Integer.parseInt(request.getParameter("c_id"));
				boolean b=c.delete_cart(c_id);
				if(b) {
					response.sendRedirect("cart");
				}else {
					response.sendRedirect("failed.jsp");
				}
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String name=request.getParameter("f_name");
		String email=request.getParameter("c_email");
		int quan=Integer.parseInt(request.getParameter("f_quan"));
		int fid=Integer.parseInt(request.getParameter("f_id"));
		float price=Float.parseFloat(request.getParameter("f_price"));
		float tprice=Float.parseFloat(request.getParameter("t_price"));
		
		if(action!=null && action.equals("add")) {
			Cart cart = c.get_cart(fid);
			if(cart.getF_id()==fid) {
				quan=cart.getF_quantity()+quan;
				tprice=cart.getT_price()+tprice;
				b=c.update_cart(new Cart(fid, email, name, price, quan, tprice));
				if(b) {
					response.sendRedirect("cart");
				}else {
					response.sendRedirect("failed.jsp");
				}
		    }else {
			  b=c.add_tocart(new Cart(fid, email, name, price, quan, tprice));
			   if(b) {
				response.sendRedirect("cart");
			   }else {
				response.sendRedirect("failed.jsp");
			  }
		}
		}
	}

}
