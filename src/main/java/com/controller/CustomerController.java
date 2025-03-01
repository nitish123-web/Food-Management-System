package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.CustomerImpl;
import com.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customer")
public class CustomerController extends HttpServlet{
	
	CustomerImpl cd=new CustomerImpl();
	boolean b;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action=request.getParameter("action");
		
		if(action==null) {
			List<Customer> list = cd.get_allcustomer();
			 if(list!=null && !list.isEmpty()) {
				 session.setAttribute("c_list", list);
				 response.sendRedirect("customerlist.jsp");
			 }else {
				 response.sendRedirect("failed.jsp"); 
			 }
		}
		if(action!=null && action.equals("delete")) {
		  String c_email=request.getParameter("c_email");
		   b=cd.delete_customerbyemail(c_email);
		   if(b) {
			  response.sendRedirect("customer"); 
		   }else {
			  response.sendRedirect("failed.jsp");  
		   }
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String name=request.getParameter("c_name");
		String email=request.getParameter("c_email");
		String pass=request.getParameter("c_pass");
		String address=request.getParameter("c_add");
		long con=Long.parseLong(request.getParameter("c_con"));
		
		if(action!=null && action.equals("add")) {
		 b=cd.add_customer(new Customer(name, email, pass, address, con));	
		   if(b) {
			  response.sendRedirect("success.jsp"); 
		   }else {
			  response.sendRedirect("failed.jsp");  
		   }
		}
		if(action!=null && action.equals("update")) {
		  Customer c=new Customer();
		  c.setC_name(name);c.setC_address(address);
		  c.setC_contact(con);c.setC_email(email);
		  b=cd.update_customerbyemail(c);
			   if(b) {
				  response.sendRedirect("success.jsp"); 
			   }else {
				  response.sendRedirect("failed.jsp");  
			   }
			}	
	}
}
