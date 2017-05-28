<%@page import="jvd001.bookstore.app.dto.BookSearchCondition"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>BookManagement</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link 
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" 
	rel="stylesheet" />
<link
	href="<c:url value="/resources/css/bookmanagement/insertbook.css" />"
	rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
</head>
<body>
	<%@ include file="../../comment/header.jsp"%>

	<!-- start code -->
	<input type="hidden" name="userVO" id="users_id" value="${userVO.users_id == null ? '0':userVO.users_id}">
	<div class="container-fluid bg-3 text-center">
	
	<form method="post" action ="/bookstore/bookmanagement/search/" commandName="bookSearchCondition">
		<div class="row text-center">
			<div class="col-sm-offset-2 col-sm-2">
				<select class="form-control" name="category_id" id="category_id">
				<option value="0">NoOption</option>
				<c:forEach items="${listCategory}" var ="category">
			<option value="${category.category_id}">${category.category_name}</option>
				</c:forEach>
						</select>
			</div>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="txt1" name="title"
					placeholder="Title..." value="${bsc.title}"/>
			</div>
			<div class="col-sm-2">
				<input  type="text" class="form-control" id="txt1" name="publisher"
					placeholder="Publisher..." value="${bsc.publisher}"/>
			</div>
			<div class="col-sm-2">
				<input  type="text" class="form-control" id="txt1" name="year_of_publishing"
					placeholder="YearofPublishing..." value="${bsc.year_of_publishing}"/>
			</div>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-primary"
					style="text-align: left; float: left;" value="Search">Search</button>
			</div>

			<div class="col-sm-5"></div>
			<div class="col-sm-3"></div>
		</div>
		</form>
		</br>
		<div class="container-fluid bg-3 text-center">
		
		
		<div class="row text-center">
			<c:forEach items="${listBook }" var ="bookVO">
				<div class="col-sm-3">
				
					<img src="<c:url value="/resources/images/${bookVO.image}"/>" class="image-responsive" 
						width="60%" height="240"></br>
					</br> <a href="<c:url value='/bookmanagement/detail/${bookVO.book_Id}'/>" name ="idbook">${bookVO.title }</a></br>
					</br>
					
					<c:choose>
					<c:when test="${userVO.role_id==1}">
					<a href="<c:url value='/bookmanagement/edit/${bookVO.book_Id}'/>">
					<button  type="button"
						class="btn btn-info btnEditBook">Edit</button></a>
					<button  type="button" class="btn btn-danger btnDelete" onclick="BookManagement.initOnClickDeleteBook(${bookVO.book_Id})">
					Delete</button><br><br></a>
					</c:when>
						
					<%-- <c:when test="${userVO.role_id==2}"> --%>
					<c:when test="${userVO.users_id== bookVO.user.users_id}">
					<a href="<c:url value='/bookmanagement/edit/${bookVO.book_Id}'/>">
					<button  type="button"
						class="btn btn-info btnEditBook">Edit</button></a>
					</br>
					</c:when>
						<%-- </c:when> --%>
						
						</c:choose>
				</div>
				
			</c:forEach>
			<br>
		</div>
			
		<!-- insert book -->
		</br>
		<div class="container-fluid bg-3 text-center">
			<div class="row text-center">
				<div class="col-sm-1">
				<a href ="/bookstore/bookmanagement/addbook">
					<button type="button" id="btnAddBook" class="btn btn-success"
						style="text-align: center;">Add Book</button>
						</a>
				</div>
			</div>
			<br>
			<input id="sizeListBook" type="hidden" name="" value="${sizeListBook }">
			<input  id="pagenumber" type="hidden" name="" value="${pagenumber }">
			<div class="row text-center">
				<div class="col-sm-12">
					<div class="pagelist">
					<c:forEach var="i" begin="1" end="${pagenumber}">
					 <a id="N2" href="/bookstore/bookmanagement/${ i}" name="page"
							class="page">${ i}</a> 
					</c:forEach>
						
					</div>
				</div>
			</div>

		</div>
		<!-- end code -->



		<%@ include file="../../comment/footer.jsp"%>
</body>
</br>

<script 
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
<script type="text/javascript">
		var url = '${pageContext.request.contextPath}/';
</script>
<script type="text/javascript" src="<c:url value='/resources/js/bookmanagement/bookmanagement-main.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bookmanagement/bookmanagement-public.js' />"></script>
<script type="text/javascript">

	
	function btnDelete(event)
	{
		swal({
			title: "Are you sure?",
			text: "You will not be able to recover this imaginary file!",
			type: "warning",
			showCancelButton: true,
			confirmButtonClass: "btn-danger",
			confirmButtonText: "Yes, delete it!",
			cancelButtonText: "No, cancel plx!",
			closeOnConfirm: false,
			closeOnCancel: false
		},
		function(isConfirm) {
			if (isConfirm) {
				swal("Deleted!", "Your imaginary file has been deleted.", "success");
			} else {
				swal("Cancelled", "Your imaginary file is safe :)", "error");
			}
		});
	}
</script>
</html>