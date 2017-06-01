<%@page import="jvd001.bookstore.app.dto.BookSearchCondition"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/css/bookmanagement/insertbook.css" />"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css" />
<!-- templatemo -->
<link
	href="<c:url value="/resources/css/bookmanagement/templatemo_style.css"/>"
	rel="stylesheet" />
<!-- templatemo -->
</head>
<body>
	<%@ include file="../../comment/header.jsp"%>
	<div id="templatemo_container">

		<!-- start code -->
		<div id="templatemo_header">
			<div id="templatemo_special_offers">
				<p>
					<span>100%</span> free for new account
				</p>
				<!-- <a href="subpage.html" style="margin-left: 50px;">Read more...</a> -->
			</div>
			<div id="templatemo_new_books">
				<ul>
					<li>Harry Potter</li>
					<li>THe Hobbit</li>
					<li>Lord Of The Ring</li>
				</ul>
				<!-- <a href="subpage.html" style="margin-left: 50px;">Read more...</a> -->
			</div>
		</div>
		<!-- end of header -->


	<div class="templatemo_header">
		<div class="templatemo_special_offers text-center">
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
	<div class="form-group">
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