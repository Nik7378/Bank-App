package com.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDao;
import com.bank.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	User u= new User();
	UserDao ud = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		
		HttpSession session= request.getSession();
		
		u= ud.userLogin(mobile, password);
		
		if(u.getMobile().equals(mobile) && u.getPassword().equals(password)) {
			
			session.setAttribute("user", u);
			response.sendRedirect("index.jsp");
			
		}
		else {
			request.setAttribute("errorMsg", "Mobile.No or Password Does Not Match !");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}

	}

}
