package com.controller;

import java.io.IOException;

import com.dao.LoginImpl;
import com.model.Admin;
import com.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	LoginImpl l=new LoginImpl();
	boolean b;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 session.invalidate();
		 response.sendRedirect("index.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action=request.getParameter("action");
		String type=request.getParameter("type");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		if(type!=null && type.equals("admin")) {
			 session.setAttribute("type",type);
			if(action!=null && action.equals("login")) {
				b=l.admin_login(new Admin(email, pass));
				if(b) {
					session.setAttribute("a_email",email);
					response.sendRedirect("index.jsp");
				}else {
					response.sendRedirect("failed.jsp");
				}
			}
            if(action!=null && action.equals("change")) {
             String c_pass=request.getParameter("c_pass");
				b=l.admin_changepass(new Admin(email, c_pass));
				if(b) {
					response.sendRedirect("success.jsp");
				}else {
					response.sendRedirect("failed.jsp");
				}
			}
		}
        if(type!=null && type.equals("user")) {
        	session.setAttribute("type",type);	
			if(action!=null && action.equals("login")) {
				b=l.user_login(new Customer(email, pass));
				if(b) {
					session.setAttribute("c_email",email);
					response.sendRedirect("index.jsp");
				}else {
					response.sendRedirect("failed.jsp");
				}
			}
            if(action!=null && action.equals("change")) {
              String c_pass=request.getParameter("c_pass");	
				b=l.user_changepass(new Customer(email, c_pass));
				if(b) {
					response.sendRedirect("success.jsp");
				}else {
					response.sendRedirect("failed.jsp");
				}
			}
		}
	}

}
