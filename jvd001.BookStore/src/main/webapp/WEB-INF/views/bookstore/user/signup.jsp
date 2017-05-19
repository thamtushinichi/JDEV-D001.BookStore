<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Sign Up</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
<
tab3
>
{
padding-right


:


4
cm
;


  

}
.btn {
	-webkit-border-radius: 60;
	-moz-border-radius: 60;
	border-radius: 60px;
	font-family: Arial;
	color: #181a17;
	font-size: 18px;
	background: #0994f0;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
}

.btn:hover {
	background: #3cb0fd;
	background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
	background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
	text-decoration: none;
}

tab2 {
	font-size: 30px;
	text-align: left;
	color: rgb(193, 219, 200);
	font-family: Arial;
}

tab1 {
	text-align: left;
	font-size: 30px;
	color: black;
}

p {
	color: black;
}

.right1 {
	color: rgb(3, 193, 213);
}

strong {
	color-background: black;
	color: black;
}

.button1 {
	background-color: rgb(27, 118, 255);
}
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 20%;
	margin: auto;
}
</style>
</head>
<body>
	<%@ include file="../../comment/header.jsp"%>

	</br>
	<div class="container-fluid bg-3 text-center">
		<div class="row">
			<div class="col-sm-2">
				<img src="./images/bookstore-logo_1x.jpg" width="136px"
					height="128px" />
			</div>
			<div class="col-sm-3">
				</br> </br>
				<tab1>BOOK<tab2>STORE</tab2></tab1>
			</div>
			<div class="col-sm-3"></div>
			<div class="col-sm-4">
				</br> </br> <span style="font-size: 30px">CALL NOW!<span
					style="font-size: 30px; color: rgb(193, 219, 200);">
						1-800-123-4567</span></span>
			</div>
		</div>
	</div>
	</br>

	<div class="jumbotron">
		<div class="container text-center">
			<p>
			<h2>
				<strong>REGISTER</strong>
			</h2>
			</p>
			</br>
			<p>
			<h2>
				<strong><font color="red">${status}</font></strong>
			</h2>
			</p>
		</div>
	</div>
	<div class="container">
		<form:form id="signupForm" method="post" modelAttribute="user">
			<h2>Sign Up</h2>
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">Full
					Name</label>
				<div class="col-sm-9">
					<input type="text" id="inputFullname" name="fullname"
						placeholder="Full Name" class="form-control" autofocus
						value="${user.fullname}"> <span class="help-block">Last
						Name, First Name, eg.: Smith, Harry</span>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<input type="email" id="inputEmail" name="email"
						placeholder="Email" class="form-control" value="${user.email}">
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-sm-3 control-label">Username</label>
				<div class="col-sm-9">
					<input type="username" id="username" name="username"
						placeholder="Username" class="form-control" value="${user.username}">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-9">
					<input type="password" id="password" name="password"
						placeholder="Password" class="form-control"value="${user.password}">
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-sm-3 control-label">Address</label>
				<div class="col-sm-9">
					<input type="address" id="address" name="address"
						placeholder="Address" class="form-control"value="${user.address}">
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-3">Gender</label>
				<div class="col-sm-6">
					<div class="row">
						<label class="radio-inline" value="${user.sex}"><input type="radio" name="sex"
							value="0">Male</label> <label class="radio-inline"><input
							type="radio" name="sex" value="1">Female</label> <label
							class="radio-inline"></label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3 col-md-2">
					<button type="submit" class="btn btn-primary btn-block">Register</button>
				</div>
			</div>
		</form:form>
		<!-- /form -->
		<a href="/bookstore/login" class="register"> Already have an
			Account? Login </a>
	</div>
	<!-- ./container -->



	</br>
	</br>
	</br>
	<%@ include file="../../comment/footer.jsp"%>
</body>
</html>