<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<link rel="stylesheet" href="custom/style.css" />
<style type="text/css">
table {
	background-color: #626262 !important;
	color: white;
	font-size: 17px;
}

table.table-bordered {
	border: 2px solid black;
	margin-top: 20px;
}

table.table-bordered>tbody>tr>td {
	border: 1px solid black;
}

td, h2 {
	text-align: center;
}
</style>

</head>
<body class="bg-info bg_custom_color">
	<div class="container">
		<h2>Student Details</h2>
		<table class="table table-bordered table-dark table_border">
			<thead>

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<td>Edit/Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentDetails}" var="studentDetails">
					<tr>
						<td>${studentDetails.firstName}</td>
						<td>${studentDetails.lastName}</td>
						 <td><a href="Update?userId=${studentDetails.id}&user=edit"><i
								class="fa fa-pencil-square-o fa-lg " aria-hidden="true"></i></a>
							&nbsp;&nbsp;<a href="Delete?id=${studentDetails.id}" class="delete"><i
								class="fa fa-trash fa-lg " aria-hidden="true"></i></a></td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>