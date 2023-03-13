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
<jsp:include page="sidebar.jsp"></jsp:include>

<%User user= (User) session.getAttribute("user"); %>

<div id="main" class="d-flex justify-content-center">

<form action="UserServlet" method="post">
<h2 class="text-primary">Update User Details</h2><br>

	<input type="hidden" name="action" value="updateuser">
	<table class="border-0">
		<tr>
			<td>Id</td>
			<td><input type="text" name="id" value="<%=user.getId()%>" readonly/></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value="<%=user.getName()%>" required/></td>
		</tr>
		<tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" value="<%=user.getAge()%>" required/></td>
		</tr>
		<tr>
		<tr>
			<td>Mobile</td>
			<td><input type="text" name="mobile" value="<%=user.getMobile()%>" required/></td>
		</tr>
		<tr>
		<tr>
			<td>Aadhar</td>
			<td><input type="text" name="aadhar" value="<%=user.getAadhar()%>" required/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="passwd1" value="<%=user.getPassword()%>" required/></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary btn-md mt-4 rounded-3" type="submit" value="Save"/></td>
			<td><input class="btn btn-primary btn-md mt-4 rounded-3" type="reset"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>