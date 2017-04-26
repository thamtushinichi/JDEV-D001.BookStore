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
<link href="<c:url value="/resources/css/insertbook/insertbook.css" />" rel="stylesheet">

<!-- LINK LIB JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

<style type="text/css">

</style>
<script type="text/javascript">
</script>
</head>
<body>
	<!-- start code -->
	<div id="total">
		<!-- HEADER -->
		<%@ include file="../../comment/header.jsp"%>
		<form id="team">
			<div class="container-fluid bg-3">
				<div class="ibox-title">
					<h2>Add Book</h2>
				</div>
				<div class="row top-buffer">
					<div class="col-sm-3">
						<label>Title</label>
						<input type="text" class="form-control" id="txt1">
					</div>
					<div class="col-sm-3">
						<label>Author</label>
						<input type="text" class="form-control" id="txt1">
					</div>
					<div class="col-sm-3">
						<label>Category</label>
						<input type="text" class="form-control" id="txt1">
					</div>
					<div class="col-sm-2">
						<label>Publishing house</label>
						<input type="text" class="form-control" id="txt1">
					</div>
					<div class="col-sm-1">
						<label>Year of publishing</label>
						<input type="text" class="form-control" id="txt1">
					</div>
				</div>
				<div class="row top-buffer">
					<div class="col-sm-7">
						<label>Image</label>
						<input type="text" class="form-control" id="team" name="team">
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-success" style="margin: auto 0px -58px">Upload image</button>
					</div>
				</div>
				<div class="row top-buffer">
					<div class="col-sm-7">
						<label>Book</label>
						<input type="text" class="form-control" id="team" name="team">
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-success" style="margin: auto 0px -58px">Upload book</button>
					</div>
				</div>
				<div class="row top-buffer text-center">
					<div class="col-sm-12">
						<button type="button" class="btn btn-success" >Save</button>
					</div>
				</div>
			</div>
		</form>
			<!-- end code -->
			<!-- -Footer -->
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