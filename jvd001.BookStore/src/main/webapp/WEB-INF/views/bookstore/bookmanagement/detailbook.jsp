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
						<img src="<c:url value="/resources/images/${bookVO.image}"/>" class="image-responsive" 
						width="90%" height="240"></br>
					</div>
					<div class="col-sm-2">
						<label>Title</label>
						<input type="text" class="form-control" id="txt1" name ="title" value="${bookVO.title}"  disabled="disabled">
					</div>

					<div class="col-sm-2">
						<label>Author</label>
						<input type="text" class="form-control" id="txt1" name = "author" value="${bookVO.author }" disabled="disabled">
					</div>

					<div class="col-sm-2">
						<label>Category </label>
						<select class="form-control" name="category_id" id="category_id">
				<!-- <option value="0">NoOption</option> -->
				<c:forEach items="${listCategory}" var ="category">
			<option value="${category.category_id}">${category.category_name}</option>
				</c:forEach>
						</select>
					</div>

					<div class="col-sm-2">
						<label>Publishing house</label>
						<input type="text" class="form-control" id="txt1" name ="publisher" value="${bookVO.publisher }" disabled="disabled"/>
					</div>

					<div class="col-sm-2">
						<label>Year of publishing</label>
						<input type="text" class="form-control" id="txt1" name ="year_Of_Publishing" value="${bookVO.year_Of_Publishing }" disabled="disabled"/>
					</div>
					<div class="col-sm-9">
					<br>
						<label>Description</label>
						<input type="text" class="form-control" id="txt1" name ="description" value="${bookVO.description }" disabled="disabled"/>
					</div>
					
					<div class="col-sm-2">
					<br>
					<br>
						<%-- <a href="<c:url value="/resources/book/${bookVO.image}"/>"><button type="button" class="btn btn-success" >DownLoad</button></a> --%>
						<a href="<c:url value="/bookmanagement/detail/download/${bookVO.book_Id }"/>"><button type="button" class="btn btn-success" >DownLoad</button></a>
					</div>
				</div>
				</div>
				<br>
				<div class="row top-buffer">
					
				
				<br>
				<div class="row top-buffer text-center">
					
				</div>
				</div>
		</form>
<%@ include file="../../comment/footer.jsp"%>
</body>
</html>