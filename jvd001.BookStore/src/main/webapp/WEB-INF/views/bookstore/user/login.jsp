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
					<strong>LOGIN</strong>
				</h2>
				</p>

				<c:if test="${userVO.users_id>0||userVO.username!=null}">
					<p>
					<h2>
						<strong><font color="red">You've logged in
								successfully!</font></strong>
					</h2>
					</p>
				</c:if>

				<c:if test="${user.username!=null&&userVO.users_id==null}">
					<p>
					<h2>
						<strong><font color="red">Username or Password was
								wrong!</font></strong>
					</h2>
					</p>
				</c:if>

			</div>
		</div>

		<!-- login -->
		<c:if test="${userVO.users_id==null}">
			<div class="form-group">
				<form:form id="loginForm" method="post" modelAttribute="user">
					<div class="card card-container">

						<p id="profile-name" class="profile-name-card"></p>
						<form class="form-signin">
							<input type="username" id="inputUsername" name="username"
								class="form-control" placeholder="Username" required=""
								autofocus value="${user.username}"> <input
								type="password" id="inputPassword" name="password"
								class="form-control" placeholder="Password" required=""
								value="${user.password}">
							<div class="text-center">
								<button class="btn btn-lg btn-primary btn-signin" type="submit">Sign
									in</button>
							</div>
				</form:form>
				<a href="/bookstore/signup" class="register"> Don't have an
					account? Register </a>
			</div>
		</c:if>



		<%@ include file="../../comment/footer.jsp"%>
</body>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
<script type="text/javascript">
	var url = '${pageContext.request.contextPath}/';
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bookmanagement/bookmanagement-main.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bookmanagement/bookmanagement-public.js' />"></script>
<script type="text/javascript">
	function btnDelete(event) {
		swal({
			title : "Are you sure?",
			text : "You will not be able to recover this imaginary file!",
			type : "warning",
			showCancelButton : true,
			confirmButtonClass : "btn-danger",
			confirmButtonText : "Yes, delete it!",
			cancelButtonText : "No, cancel plx!",
			closeOnConfirm : false,
			closeOnCancel : false
		}, function(isConfirm) {
			if (isConfirm) {
				swal("Deleted!", "Your imaginary file has been deleted.",
						"success");
			} else {
				swal("Cancelled", "Your imaginary file is safe :)", "error");
			}
		});
	}
</script>
</html>