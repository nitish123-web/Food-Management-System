package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.FeedbackImpl;
import com.model.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/feedback")
public class FeedbackController extends HttpServlet{
	
	FeedbackImpl fd=new FeedbackImpl();
	boolean b;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	String action=request.getParameter("action");
		if(action==null) {
		  List<Feedback> list = fd.get_allfeedback();
		  if(list!=null && !list.isEmpty()) {
			  session.setAttribute("f_list", list);
			  response.sendRedirect("feedbacklist.jsp");
		  }else {
			  response.sendRedirect("failed.jsp");
		  }
		}
		if(action!=null && action.equals("delete")) {
			String c_email=request.getParameter("c_email");
			b=fd.delete_feedback(c_email);
			if(b) {
				response.sendRedirect("feedback");
			}else {
				response.sendRedirect("failed.jsp");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String c_email=request.getParameter("c_email");
		String review=request.getParameter("review");
		String advice=request.getParameter("advice");
		int rank=Integer.parseInt(request.getParameter("rank"));
		
		if(action!=null && action.equals("add")) {
			b=fd.add_feedback(new Feedback(c_email, review, rank, advice));
			if(b) {
				response.sendRedirect("success.jsp");
			}else {
				response.sendRedirect("failed.jsp");
			}
		}
		
	}

}
