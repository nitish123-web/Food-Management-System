package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.dao.FoodImpl;
import com.model.Food;


@WebServlet("/food")
public class FoodController extends HttpServlet {
	
	FoodImpl fd=new FoodImpl();
	boolean b;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action=request.getParameter("action");
		 if(action==null) {
			List<Food> list = fd.get_all_food();
			if(list!=null && !list.isEmpty()) {
			  session.setAttribute("f_list", list);
			  response.sendRedirect("foodList.jsp");
			}else {
				response.sendRedirect("failed.jsp");
			}
		 }
		 if(action!=null && action.equals("delete")) {
			 int f_id=Integer.parseInt(request.getParameter("f_id"));
				b=fd.delete_food_byid(f_id);
				if(b) {
					response.sendRedirect("food");
				}else {
					response.sendRedirect("failed.jsp");
				} 
		 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getParameter("action");
		 String name=request.getParameter("f_name");
		 String type=request.getParameter("f_type");
		 String cat=request.getParameter("f_cate");
		 float price=Float.parseFloat(request.getParameter("f_price"));
		 
		 if(action!=null && action.equals("add")) {
			 b=fd.add_food(new Food(name, type, cat, price));
			  if(b){
					response.sendRedirect("food");
				}else {
					response.sendRedirect("failed.jsp");
				} 
		 }
		 if(action!=null && action.equals("update")) {
		   int f_id=Integer.parseInt(request.getParameter("f_id"));	 
		   Food f=new Food(name, type, cat, price);
		   f.setF_id(f_id);
			b=fd.update_food_byid(f);
			  if(b){
					response.sendRedirect("food");
				}else {
					response.sendRedirect("failed.jsp");
				} 
		 }
		 
	}

}
