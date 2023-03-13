<%@page import="com.bank.dao.WithdrawDao"%>
<%@page import="com.bank.dao.DepositDao"%>
<%@page import="com.bank.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%User user= (User)session.getAttribute("user"); 
DepositDao depod= new DepositDao();
WithdrawDao wdao= new WithdrawDao();
%>
<jsp:include page="sidebar.jsp"></jsp:include>
<div id="main">
<h2 class="text-primary">Transaction Details</h2><br>
<table class="border-0">
<tr>
	<th class="text-primary"><h2>Total Deposit = </h2></th>
	<td><h2><%=depod.getTotalDeposit(user) %></h2></td>
</tr>
<tr>	
	<th class="text-primary"><h2>Total Withdraw = </h2></th>
	<td><h2><%=wdao.getTotalWithdraw(user) %></h2></td>
</tr>
<tr>	
	<th class="text-primary"><h2>Balance = </h2></th>
	<%Double Balance = depod.getTotalDeposit(user) - wdao.getTotalWithdraw(user);%>
	<td><h2><%=Balance%></h2></td>
</tr>
</table>

<%if(Balance < 1000){ %>
<h2 class="text-danger">Please Maintain Minimum Balance of Rs.1000</h2>
<br>
<a href="adddeposit.jsp">Click here to Add Money</a>
<%} %>
</div>
</body>
</html>