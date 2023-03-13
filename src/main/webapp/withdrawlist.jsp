<%@page import="java.util.List"%>
<%@page import="com.bank.model.Withdraw"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/main.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="sidebar.jsp"></jsp:include>
<h2 class="text-primary d-flex justify-content-center mt-5">Withdraw Transaction List</h2>

<div id="main" class="d-flex justify-content-center">
<%List<Withdraw> wdList= (List<Withdraw>) session.getAttribute("wdList");
int count =1;
%>
<table cellpadding="20">
	<tr>
		<th class="text-bg-primary">ID</th>
		<th class="text-bg-primary">Withdraw</th>
		<th class="text-bg-primary">Date</th>
		<th class="text-bg-primary">Description</th>
		<th class="text-bg-primary">User ID</th>
		<th class="text-bg-primary" colspan="2">Action</th>
	</tr>
	
	<%for(Withdraw i:wdList){ %>
	<tr>
		<td><%=count++%></td>
		<td><%=i.getWithdraw()%></td>
		<td><%=i.getWithdrawDate()%></td>
		<td><%=i.getDescription()%></td>
		<td><%=i.getUserId()%></td>
		<td><a href="WithdrawServlet?action=edit&id=<%= i.getId() %>">Edit</a></td>
		<td><a href="WithdrawServlet?action=delete&id=<%= i.getId() %>">Delete</a></td>	
	</tr>
	<%} %>
</table>
</div>
</body>
</html>