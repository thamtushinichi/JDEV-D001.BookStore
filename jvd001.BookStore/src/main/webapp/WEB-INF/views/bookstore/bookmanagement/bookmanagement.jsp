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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<link 
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" 
	rel="stylesheet" />
<link
	href="<c:url value="/resources/css/bookmanagement/insertbook.css" />"
	rel="stylesheet">
	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css"/>
<!-- templatemo -->
	<link href="<c:url value="/resources/css/bookmanagement/templatemo_style.css"/>" rel="stylesheet"/>
	<!-- templatemo -->
</head>
<body>
<input type="hidden" name="userVO" id="users_id" value="${userVO.users_id == null ? '0':userVO.users_id}">
<%@ include file="../../comment/header.jsp"%>
 <div id="templatemo_container">
	
	<!-- start code -->
	 <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p> <span>100%</span> free for
        new account</p>
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
    </div> <!-- end of header -->
    
	<div class="container-fluid bg-3 text-center">
	
	<form method="post" action ="/bookstore/bookmanagement/search/" commandName="bookSearchCondition" id="formSearch">
	<input type="hidden" name="message" id="message" value="${message }">
		<div class="row text-center">
			<div class="col-sm-offset-2 col-sm-2">
				<select class="form-control" name="category_id" id="category_id">
				<option value="0">NoOption</option>
				<c:forEach items="${listCategory}" var ="category">
			<option value="${category.category_id}" ${category.category_id==bsc.category_id ? 'selected':''}>${category.category_name}</option>
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
				<input  type="text" class="form-control onlynumber" id="txt1" name="year_of_publishing"
				maxlength="4"	placeholder="YearofPublishing..." value="${bsc.year_of_publishing}"/>
			</div>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-primary"
					style="text-align: left; float: left;" value="Search">Search</button>
			</div>

			<div class="col-sm-5"></div>
			<div class="col-sm-3"></div>
		</div>
		</form>
		</div>
		<!-- Right content -->
		<c:set var = "count" value = "${0}"/>
		<div id="templatemo_content">
		<div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<h1>Categories</h1>
                <ul>
                     <c:forEach items="${listCategory}" var ="category">
                        <li style="font-size: 13px"><p>${category.category_name}</p></li>
                    </c:forEach>
            	</ul>
            </div>
			<div class="templatemo_content_left_section">
            	<h1>Add New Book</h1>
                <ul>
                    <li><a href ="/bookstore/bookmanagement/addbook">
					<button type="button" id="btnAddBook" class="btn btn-success"
						style="text-align: center;">Add Book</button>
						</a></li>
            	</ul>
            </div>
           </div>
		<div id="templatemo_content_right">
		<c:forEach items="${listBook}" var ="bookVO">
		<c:set var = "count" value = "${count+1}"/>
		<div class="templatemo_product_box">
		<h1>${bookVO.title}<span>(by ${bookVO.author })</span></h1>
		 
		 <img src="<c:url value="/resources/images/${bookVO.image}"/>" alt="image"
						width="78" height="128"/>
			
		<div class="product_info">
		<h3>Free</h3>
        <div class="detail_button"> <a href="<c:url value='/bookmanagement/detail/${bookVO.book_Id}'/>" name ="idbook">Detail</a></div>
		<c:choose>
					<c:when test="${userVO.role_id==1}">
					<div class="buy_now_button"><a href="<c:url value='/bookmanagement/edit/${bookVO.book_Id}'/>">Edit</a></div>
					<button  type="button" class="btn btn-danger btn-sm" style="width: 78px" onclick="BookManagement.initOnClickDeleteBook(${bookVO.book_Id})">
					Delete</button>
					</c:when>
					<c:when test="${userVO.users_id== bookVO.user.users_id}">
					<div class="buy_now_button"><a href="<c:url value='/bookmanagement/edit/${bookVO.book_Id}'/>">Edit</a></div>
					</c:when>
		</c:choose>
		
		
		</div>
		  <div class="cleaner">&nbsp;</div>
		</div>
		
		<c:choose>
		<c:when test="${count%2 !=0 }">
		<div class="cleaner_with_width">&nbsp;</div>
		</c:when>
		 <c:otherwise>
		  <div class="cleaner_with_height">&nbsp;</div>
		  </c:otherwise>
		  
		</c:choose>
		</c:forEach>
		</div>
		<div class="cleaner_with_height">&nbsp;</div>
		</div>
		
		<!-- Right content -->
		
			
		<!-- insert book -->
		
		
		<!-- end code -->
		</div> <!-- end container -->
		<div class="container-fluid bg-3 text-center">
			<!-- <div class="row text-center">
				<div class="col-sm-1">
				<a href ="/bookstore/bookmanagement/addbook">
					<button type="button" id="btnAddBook" class="btn btn-success"
						style="text-align: center;">Add Book</button>
						</a>
				</div>
			</div> -->
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
		<%@ include file="../../comment/footer.jsp"%>
</body>


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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
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