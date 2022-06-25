<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome: 
<%   
String name=(String)session.getAttribute("user"); %>
<%= name %><br>
result is: ${param["result"]}

</body>
</html>