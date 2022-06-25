<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="student" scope="session" value="${sessionScope.details}" />
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>User login form</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" href="custom/style.css" />
<!-- Fontawesome CSS CDN -->
</head>

<body class="bg-info bg_custom_color">
	<div class="container">
	
		<form action="Register" method="post" class="px-3" id="login_form">
			<!-- Login Form Start -->
			<div class="row justify-content-center wrapper" id="login-box">
				<div class="col-lg-10 my-auto myShadow">
					<div class="row">
						<div class="col-lg-7 bg-white p-4">
							<h1 class="text-center font-weight-bold text-primary">Add
								Student</h1>
							<hr class="my-3" />
							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"> <i
										class="far fa-user fa-lg fa-fw"></i></span>
								</div>
								<input type="text" id="mail" name="fname"
									class="form-control rounded-0" placeholder="First Name"
									value="${student.firstName}" />

							</div>
							<div class="input-group input-group-lg form-group">
								<div class="input-group-prepend">
									<span class="input-group-text rounded-0"><i
										class="far fa-user fa-lg fa-fw"></i></span>
								</div>
								<input type="text" id="mail" name="lname"
									class="form-control rounded-0" placeholder="Last Name"
									value="${student.getLastName()}" />
							</div>
							<div class="form-group">
								<input type="submit" id="login-btn" value="Submit"
									class="btn btn-primary btn-lg btn-block myBtn" />
							</div>
						</div>
						<div
							class="col-lg-5 d-flex flex-column justify-content-center myColor p-4">
							<h1 class="text-center font-weight-bold text-white">Hello
								Friends!</h1>
							<hr class="my-3 bg-light myHr" />
							<p class="text-center font-weight-bolder text-light lead">Enter
								your personal details and start your journey with us!</p>
							<a href="view.jsp" id="register-link"
								class="btn btn-outline-light btn-lg align-self-center font-weight-bolder mt-4 myLinkBtn">View
								Student</a>

						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- jQuery CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- <script src="custom/js/loginValidation.js"></script> -->

</body>

</html>