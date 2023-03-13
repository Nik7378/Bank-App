<%@page import="com.bank.dao.WithdrawDao"%>
<%@page import="com.bank.dao.DepositDao"%>
<%@page import="com.bank.dao.UserDao"%>
<%@page import="com.bank.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC BANK APPLCATION</title>
</head>
<body>

<%User user= (User)session.getAttribute("user"); 
DepositDao depod= new DepositDao();
WithdrawDao wdao= new WithdrawDao();
%>

<jsp:include page="sidebar.jsp"></jsp:include>

<div id="main">
<h1 class="text-primary">ABC BANK APPLCATION</h1>

<%if(user!=null){ %>
<h2>Welcome, <%=user.getName() %></h2>
<%} %>
<img src="resources/bank.jpeg" class="img-fluid" alt="Responsive image">
</div>
</body>
</html>