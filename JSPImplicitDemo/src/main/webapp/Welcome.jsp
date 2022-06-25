<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page errorPage="error.jsp"%>
	<%   
String name=request.getParameter("name");  
int num1=Integer. parseInt(request. getParameter("num1"));  
int num2=Integer. parseInt(request. getParameter("num2"));  
int result = num1/num2;
  
session.setAttribute("user",name);  
  
  %>
	<jsp:forward page="data.jsp">
		<jsp:param value="<%= result %>" name="result" />
	</jsp:forward>
</body>
</html>