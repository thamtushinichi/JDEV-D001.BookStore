<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Detail - Book</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet" />
</head>
<body>
<%@ include file="../../comment/header.jsp"%>
<form id="team">
			<div class="container-fluid bg-3">
				<div class="ibox-title">
				<div class="row top-buffer">
				<div class="col-sm-3">
					<h2>Detail - Book</h2>
					</div>
					<br>
				</div>
					
				</div>
				</br>
				<div class="row top-buffer">
					<div class="col-sm-2">
						<label>Title</label>
						<input type="text" class="form-control" id="txt1">
					</div>

					<div class="col-sm-2">
						<label>Author</label>
						<input type="text" class="form-control" id="txt1">
					</div>

					<div class="col-sm-2">
						<label>Category </label>
						<input type="text" class="form-control" id="txt1">
					</div>

					<div class="col-sm-2">
						<label>Publishing house</label>
						<input type="text" class="form-control" id="txt1">
					</div>

					<div class="col-sm-2">
						<label>Year of publishing</label>
						<input type="text" class="form-control" id="txt1">
					</div>
				</div>
				<br>
				<div class="row top-buffer">
					<div class="col-sm-3">
						<label>Image</label>
						<img src="<c:url value="/resources/images/${bookVO.image}"/>" class="image-responsive" 
						width="60%" height="240"></br>
					</div>
				<div class="col-sm-9">
						<label>Description</label>
						<input type="text" class="form-control" id="txt1">
					</div>
				</div>
				<br>
				<div class="row top-buffer text-center">
					<div class="col-sm-12">
						<button type="button" class="btn btn-success" >DownLoad</button>
					</div>
				</div>
				</div>
		</form>
<%@ include file="../../comment/footer.jsp"%>
</body>
</html>