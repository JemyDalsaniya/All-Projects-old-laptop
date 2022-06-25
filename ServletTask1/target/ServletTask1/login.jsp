<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
/* response.setHeader("Cache-Control","no-store"); 
 */ response.setHeader("Expires", "0");  
response.setHeader("Pragma","no-cache"); 
%>
<form action ="User_login" method="post">
	<table>

			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" /><br /> <br /><a href="register.html">New User</a>
</form>
</body>
</html>