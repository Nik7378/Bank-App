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

<div id="main" class="d-flex justify-content-center">
<%String message= (String) request.getAttribute("errorMsg"); %>

<%if(message!=null){ %>

<h3 style="color:red"><%=message %></h3>

<%} %>

<form action="LoginServlet" method="post">
<h2 class="text-primary">Login Page</h2><br>

	<table class="border-0">
		<tr>
			<td>Mobile.No</td>
			<td><input type="text" name="mobile" required/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" required/></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary btn-md mt-4 rounded-3" type="submit" value="Login"/></td>
			<td><input class="btn btn-primary btn-md mt-4 rounded-3" type="reset"/></td>
		</tr>
	</table>
	<br><br>
	<a href="adduser.jsp">Don't have an Account? Click here to Open New Account</a>
</form>
</div>
</body>
</html>