<%@page import="com.bank.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/main.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
</head>
<body>

<%User user= (User)session.getAttribute("user"); %>

<div id="sidebar">
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="index.jsp">Home</a></button>

<%if(user!=null){ %>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="adddeposit.jsp">Deposit Money</a></button>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="addwithdraw.jsp">Withdraw Money</a></button>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="DepositServlet">Deposit List</a></button>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="WithdrawServlet">Withdraw List</a></button>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="balance.jsp">Check Balance</a></button>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="updateuser.jsp">Edit Profile</a></button>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="LoginServlet">Logout</a></button>

<%} %>

<%if(user==null){ %>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="adduser.jsp">Open New Account</a></button>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="login.jsp">Login to Account</a></button>
<button type="button" class="btn btn-outline-primary btn-md mt-4 w-100 rounded-5"><a href="aboutus.jsp">About US</a></button>
<%} %>

</div>
</body>
</html>