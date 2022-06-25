<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  
	<%-- <% out.println("Hello inside scriplet tag \n"); %>

	
	<%= "Hello inside expression tag " %>
	<%! int square(int n){
	 return n*n;} %>
	<%= "Square is: "+square(5) %> --%>
	
	<%@ include file="header.jsp" %>  
	
	<%-- <%@ page errorPage="errorpage.jsp" %>
	<% int a=5/0; %> --%>
	<%= "inside index.jsp file" %>

	<%@ include file="footer.jsp" %>  
	
</body>
</html>