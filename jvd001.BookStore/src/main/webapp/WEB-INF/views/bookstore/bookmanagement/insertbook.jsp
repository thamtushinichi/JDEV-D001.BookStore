<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Example</title>

<!-- LINK LIB CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet" />
<link href="<c:url value="/resources/css/bookmanagement/insertbook.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">

<!-- LINK LIB JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
<script type="text/javascript">
var url = '${pageContext.request.contextPath}/';
</script>
<script type="text/javascript" src="<c:url value='/resources/js/bookmanagement/insertbook-main.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bookmanagement/insertbook-public.js' />"></script>
</head>
<body>
	<!-- start code -->
	<div id="total">
		<!-- HEADER -->
		<%@ include file="../../comment/header.jsp"%>
		<form id="frmAddBook">
		<input type="hidden" name="message" id="message" value="${message }">
			<div class="container-fluid bg-3">
				<div class="ibox-title text-center">
					<h2>Add Book</h2>
				</div>
				<div class="row top-buffer">
					<div class="col-sm-offset-2 col-sm-8">
						<label>Title</label>
						<input type="text" class="form-control" id="title" name="title">
					</div>
				</div>
				<div class="row top-buffer">	
					<div class="col-sm-offset-2 col-sm-8">
						<label>Author</label>
						<input type="text" class="form-control" id="author" name="author">
					</div>
				</div>
				<div class="row top-buffer">	
					<div class="col-sm-offset-2 col-sm-8">
						<label>Category</label>
						<select class="form-control selectpicker" name="category_Ids" id="category_Ids" multiple>
							<c:forEach items="${categoryLists }" var="categoryList">
								<option value="${categoryList.category_id }">${categoryList.category_name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row top-buffer">	
					<div class="col-sm-offset-2 col-sm-8">
						<label>Publishing house</label>
						<input type="text" class="form-control" id="publisher" name="publisher">
					</div>
				</div>
				<div class="row top-buffer">
					<div class="col-sm-offset-2 col-sm-8">
						<label>Year of publishing</label>
						<input type="text" class="form-control onlynumber" id="year_Of_Publishing" name="year_Of_Publishing" maxlength="4">
					</div>
				</div>
				<div class="row top-buffer">
					<div class="col-sm-offset-2 col-sm-8">
						<label>Description</label>
						<textarea rows="5" class="form-control" id="description" name="description"></textarea>
					</div>
				</div>
				<div class="row top-buffer">
					<div class="col-sm-offset-2 col-sm-8">
						<label>Image</label>
						<input type="file" class="form-control" id="file" name="file">
					</div>
				</div>
				<div class="row top-buffer">
					<div class="col-sm-offset-2 col-sm-8">
						<label>Book</label>
						<input type="file" class="form-control" id="" name="">
					</div>
				</div>
				<div class="row top-buffer text-center">
					<div class="col-sm-12">
						<button type="button" class="btn btn-success" id="btnSave">Save</button>
					</div>
				</div>
			</div>
		</form>
			<!-- end code -->
			<!-- -Footer -->
			<%@ include file="../../comment/footer.jsp"%>
	</div>
	</body>
	<br>

<!-- <script type="text/javascript">
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

</script> -->
</html>