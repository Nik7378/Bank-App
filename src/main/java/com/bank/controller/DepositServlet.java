package com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.DepositDao;
import com.bank.model.Deposit;
import com.bank.model.User;


@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	
	Deposit dep= new Deposit();
	DepositDao depod= new DepositDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user= (User) session.getAttribute("user");
		
		String action= request.getParameter("action");
		
		if(action!=null && action.equals("delete")) {
			
			int id= Integer.parseInt(request.getParameter("id"));
			
			boolean b= depod.deleteDeposit(id);
			
			if(b) {
				response.sendRedirect("DepositServlet");
			}

		}
		else if(action!=null && action.equals("edit")){
			
			int id= Integer.parseInt(request.getParameter("id"));
			
			Deposit dep= depod.getDeposit(id);
			
			session.setAttribute("dep", dep);
			
			response.sendRedirect("updatedeposit.jsp");
			
		}
		else {

			List<Deposit> depList = depod.getDepositList(user.getId());
			session.setAttribute("depList", depList);
			response.sendRedirect("depositlist.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		User user= (User) session.getAttribute("user");
		
		Double deposit= Double.parseDouble(request.getParameter("depositamount"));
		String description= request.getParameter("description");
		int userId= Integer.parseInt(request.getParameter("userid"));
		
		if(action!=null && action.equals("adddeposit")) {
			
			dep.setDeposit(deposit);
			dep.setDescription(description);
			dep.setUserId(userId);
			
			boolean b= new DepositDao().addDeposit(dep);
			
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("adddeposit.jsp");
			}
		}
		
		else if(action!=null && action.equals("updatedeposit")) {
			
			dep.setDeposit(deposit);
			dep.setDescription(description);
			dep.setUserId(userId);
			
			int id = Integer.parseInt(request.getParameter("id"));
			dep.setId(id);
			
			boolean b= new DepositDao().updateDeposit(dep);
			
			if(b) {
				response.sendRedirect("DepositServlet");
			}
		}

	}

}
