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
<%User user= (User) session.getAttribute("user"); %>

<jsp:include page="sidebar.jsp"></jsp:include>
<div id="main" class="d-flex justify-content-center">

<%String message= (String) request.getAttribute("errorMsg"); %>

<%if(message!=null){ %>

<h3 style="color:red"><%=message %></h3>

<%} %>
<form action="WithdrawServlet" method="post">
<h2 class="text-primary">Withdraw Money</h2><br>

<input type="hidden" name="action" value="addwithdraw">
	<table class="border-0">
		<tr>
			<td>Withdraw Amount</td>
			<td><input type="number" name="withdrawamount" required/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td>
				<textarea rows="3" cols="21" name="description" required></textarea>
			</td>
		</tr>
		<tr>
			<td>User</td>
			<td>
			<input type="hidden" name="userid" value="<%=user.getId() %>"> 
			<input type="text"  value="<%=user.getName() %>" readonly> 
			</td>
		</tr>
		<tr>
			<td><input class="btn btn-primary btn-md mt-4 rounded-3" type="submit" value="Withdraw Money"/></td>
			<td><input class="btn btn-primary btn-md mt-4 rounded-3" type="reset"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>