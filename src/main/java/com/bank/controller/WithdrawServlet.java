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
import com.bank.dao.WithdrawDao;
import com.bank.model.User;
import com.bank.model.Withdraw;


@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	
	Withdraw wd= new Withdraw();
	WithdrawDao wdao= new WithdrawDao();
	DepositDao depod= new DepositDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user= (User) session.getAttribute("user");
		
		String action= request.getParameter("action");
		
		if(action!=null && action.equals("delete")) {
			
			int id= Integer.parseInt(request.getParameter("id"));
			
			boolean b= wdao.deleteWithdraw(id);
			
			if(b) {
				response.sendRedirect("WithdrawServlet");
			}

		}
		else if(action!=null && action.equals("edit")){
			
			int id= Integer.parseInt(request.getParameter("id"));
			
			Withdraw wd= wdao.getWithdraw(id);
			
			session.setAttribute("wd", wd);
			
			response.sendRedirect("updatewithdraw.jsp");
			
		}
		else {

			List<Withdraw> wdList = wdao.getWithdrawList(user.getId());
			session.setAttribute("wdList", wdList);
			response.sendRedirect("withdrawlist.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		User user= (User) session.getAttribute("user");
		
		Double withdraw= Double.parseDouble(request.getParameter("withdrawamount"));
		String description= request.getParameter("description");
		int userId= Integer.parseInt(request.getParameter("userid"));		
		
		if(action!=null && action.equals("addwithdraw")) {
						
				wd.setWithdraw(withdraw);
				wd.setDescription(description);
				wd.setUserId(userId);
				
				boolean b= new WithdrawDao().addWithdraw(wd);
		
				if(b) {
					response.sendRedirect("index.jsp");
				}
				else {
					response.sendRedirect("addwithdraw.jsp");
				}
		}
		
		else if(action!=null && action.equals("updatewithdraw")) {
			
			wd.setWithdraw(withdraw);
			wd.setDescription(description);
			wd.setUserId(userId);
			
			int id = Integer.parseInt(request.getParameter("id"));
			wd.setId(id);
			
			boolean b= new WithdrawDao().updateWithdraw(wd);
			
			if(b) {
				response.sendRedirect("WithdrawServlet");
			}
		}

	}

}
