<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Detail - Book</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet" />
<!-- templatemo -->
	<link href="<c:url value="/resources/css/bookmanagement/templatemo_style.css"/>" rel="stylesheet"/>
<!-- templatemo -->
<!-- <style type="text/css">
	body {
	margin: 0;
	padding: 0;
	line-height: 1.5em;
	font-family: Verdana, Arial, san-serif;
	font-size: 18px;
	color: #ffffff;
	background: #4b4743;
}
</style> -->
</head>
<body>
<%@ include file="../../comment/header.jsp"%>
<input type="hidden" name="userVO" id="users_id" value="${userVO.users_id == null ? '0':userVO.users_id}">
<form id="team">
<div id="templatemo_container">
    <div id="templatemo_content">
        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">
            	<h1>Categories of Book</h1>
                <ul>
                    <c:forEach items="${listCategory}" var ="category">
                        <li style="font-size: 13px"><p>${category.category_name}</p></li>
                    </c:forEach>
            	</ul>
            	<h1>Download</h1>
            	<ul>
            	
            	<%-- <li><a href="<c:url value="/resources/book/${bookVO.image}"/>"><button type="button" class="btn btn-success" >DownLoad</button></a></li> --%>
				<li><a href="<c:url value="/bookmanagement/detail/download/${bookVO.book_Id }"/>"><button type="button" class="btn btn-success" >DownLoad</button></a></li>
				
				</ul>
            </div>
        </div>
         <div id="templatemo_content_right">
             <h1 style="font-size: 28px">${bookVO.title} <span style="font-size: 28px">(by ${bookVO.author})</span></h1>
              <div class="image_panel img-thumbnail"><img src="<c:url value="/resources/images/${bookVO.image}"/>" alt="CSS Template Cinque Terre" width="490" height="396" /></div>
             	
              <ul style="float: left;">
              <li style="font-size: 14px;">Title: <a>${bookVO.title }</a></li>
                  <li style="font-size: 14px;">Author: <a>${bookVO.author }</a></li>
                  <li style="font-size: 14px">Publishing House: <a>${bookVO.publisher }</a></li>
                   <li style="font-size: 14px">Year of publishing: <a>${bookVO.year_Of_Publishing }</a></li>
              </ul>
              <div style="float: left;">
              <p style="font-size: 13px">Description : ${bookVO.description }</p>
              </div>
              <div class="cleaner_with_height">&nbsp;</div>
         </div>
         <div class="cleaner_with_height">&nbsp;</div>
    </div>
</div>
</form>
<%-- <form id="team">
			<div class="container-fluid bg-3">
				<div class="ibox-title">
				<div class="row top-buffer">
				<div class="col-sm-3">
					<h2>Detail - Book</h2>
					</div>
					<br>
				</div>
				</div>
				
				<div class="row top-buffer">
				<div class="col-sm-2">
						<img src="<c:url value="/resources/images/${bookVO.image}"/>" class="image-responsive" 
						width="100%" height="240">
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
					<div class="col-sm-5">
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
						<a href="<c:url value="/resources/book/${bookVO.image}"/>"><button type="button" class="btn btn-success" >DownLoad</button></a>
						<a href="<c:url value="/bookmanagement/detail/download/${bookVO.book_Id }"/>"><button type="button" class="btn btn-success" >DownLoad</button></a>
					</div>
				</div>
				</div>
		</form> --%>
<%@ include file="../../comment/footer.jsp"%>
</body>
</html>