<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product Price</th>
        </tr>
 
        <c:forEach var="product" items="${ProductList}">
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.productPrice}</td>
            </tr>
        </c:forEach>
    </table>
 
    <%--For displaying Previous link except for the initial page --%>
   <%--  <c:if test="${currentPage != 1}">
        <td><a href="products?page=${currentPage - 1}">Previous</a></td>
    </c:if> --%>
 
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="products?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    <%--For displaying Next  --%>
   <%--  <c:if test="${currentPage lt noOfPages}">
        <td><a href="products?page=${currentPage + 1}">Next</a></td>
    </c:if> --%>
</body>
</html>