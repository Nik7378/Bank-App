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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		String mobile= request.getParameter("mobile");
		String aadhar= request.getParameter("aadhar");
		String password1= request.getParameter("passwd1");
		String password2= request.getParameter("passwd2");
		
		String action = request.getParameter("action");
		
		if(action!=null && action.equals("adduser")) {
		
		if(name!=null && age!=null && mobile!=null && aadhar!=null && password1.equals(password2)) {
			
			boolean b= new UserDao().adduser(name, age, mobile, aadhar, password1);
			
			if(b) {
				response.sendRedirect("login.jsp");
			}
			else {
				request.setAttribute("errorMsg", "User Already Exist !");
				request.getRequestDispatcher("adduser.jsp").include(request, response);
			}
		}
		else {
			request.setAttribute("errorMsg", "Password Does Not Match With Confirm Password !");
			request.getRequestDispatcher("adduser.jsp").include(request, response);
		}
		}
		else if(action!=null && action.equals("updateuser")) {
			
			HttpSession session = request.getSession();
			
			int id= Integer.parseInt(request.getParameter("id"));
			
			User user= new User();
			user.setId(id);
			user.setName(name);
			user.setAge(age);
			user.setMobile(mobile);
			user.setAadhar(aadhar);
			user.setPassword(password1);

			boolean b= new UserDao().updateUser(user);
			
			if(b) {
				session.setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}
		}
	}

}
