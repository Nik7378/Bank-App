<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
</head>
<body>
<%String message= (String) request.getAttribute("errorMsg"); %>
<%if(message!=null){ %>

<h3 class="text-danger mb-7 mt-10 d-flex justify-content-center"><%=message %></h3><br>

<%} %>
<jsp:include page="sidebar.jsp"></jsp:include>

<div id="main" class="d-flex justify-content-center">
<form action="UserServlet" method="post">
<br>
<h2 class="text-primary ">Registration Form</h2><br>
	<input type="hidden" name="action" value="adduser">
	<table class="border-0">
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" required/></td>
		</tr>
		<tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" required/></td>
		</tr>
		<tr>
		<tr>
			<td>Mobile</td>
			<td><input type="text" name="mobile" required/></td>
		</tr>
		<tr>
		<tr>
			<td>Aadhar</td>
			<td><input type="text" name="aadhar" required/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="passwd1" required/></td>
		</tr>
		<tr>
			<td>Confirm-Password</td>
			<td><input type="password" name="passwd2" required/></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary btn-md mt-4 rounded-3" type="submit" value="Register"/></td>
			<td><input class="btn btn-primary btn-md mt-4 rounded-3" type="reset"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>