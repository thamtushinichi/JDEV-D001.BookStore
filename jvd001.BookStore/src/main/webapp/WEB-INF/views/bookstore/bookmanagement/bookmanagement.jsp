<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<html lang="en">
	<head>
		<title>Bootstrap Example</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="./css/mycss.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
		<script type="text/javascript">
		var url = '${pageContext.request.contextPath}/';
		</script>
	</head>
	<body>
		<%@ include file="../../comment/header.jsp"%>

		<!-- start code -->
		<div class="container-fluid bg-3 text-center">
			<div class="row text-center">
				<div class= "col-sm-offset-2 col-sm-2">
					<input type="text" class="form-control" id="txt1" placeholder="Category...">
				</div>
				<div class= "col-sm-2">
					<input type="text" class="form-control" id="txt1" placeholder="Title...">
				</div>
				<div class= "col-sm-2">
					<input type="text" class="form-control" id="txt1" placeholder="Publisher...">
				</div>
				<div class= "col-sm-2">
					<input type="text" class="form-control" id="txt1" placeholder="YearofPublishing...">
				</div>
				<div class= "col-sm-2">
					<button type="button" class="btn btn-primary" style="text-align: left;float: left;">Search</button>
				</div>

				<div class= "col-sm-5">

				</div>
				<div class= "col-sm-3">


				</div>
			</div>

		</br>
		<!-- <table style="width:100%" >
			<tr>
				<th>No</th>
				<th>Title</th> 
				<th>Image</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<tr>
				<td>1</td>
				<td><a href="#">Smith</a></td> 
				<td></td>
				<td>
					<button id ="btnEdit1" type="button" class="btn btn-info">Edit</button>
				</td>
				<td>
					<button id ="btnDelete1" type="button" class="btn btn-danger" onclick="btnDelete(event)">Delete</button>
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td><a href="#">Jackson</a></td> 
				<td></td>
				<td>
					<button id ="btnEdit2" type="button" class="btn btn-info">Edit</button>
				</td>
				<td>
					<button id ="btnDelete2" type="button" class="btn btn-danger" onclick="btnDelete(event)" >Delete</button>
				</td>
			</tr>
		</table> -->
		<div class="container-fluid bg-3 text-center">
			<div class="row text-center">
				<div class="col-sm-3">
					<img src="./images/kieu.jpg" class="image-responsive" alt ="No.1" width="60%" height="240"></br></br>
					<a href="#">Smith</a></br></br>
					<button id ="btnEdit1" type="button" class="btn btn-info">Edit</button>
					<button id ="btnDelete1" type="button" class="btn btn-danger" onclick="btnDelete(event)">Delete</button>
				</div>
				<div class="col-sm-3">
					<img src="./images/dac-nhan-tam.jpg" class="image-responsive" alt ="No.2" width="60%"  height="240"></br></br>
					<a href="#">Jackson</a></br></br>
					<button id ="btnEdit2" type="button" class="btn btn-info">Edit</button>
					<button id ="btnDelete2" type="button" class="btn btn-danger" onclick="btnDelete(event)">Delete</button>
				</div>
				<div class="col-sm-3">
					<img src="./images/dac-nhan-tam.jpg" class="image-responsive" alt ="No.2" width="60%"  height="240"></br></br>
					<a href="#">Jackson</a></br></br>
					<button id ="btnEdit2" type="button" class="btn btn-info">Edit</button>
					<button id ="btnDelete2" type="button" class="btn btn-danger" onclick="btnDelete(event)">Delete</button>
				</div>
				<div class="col-sm-3">
					<img src="./images/dac-nhan-tam.jpg" class="image-responsive" alt ="No.2" width="60%"  height="240"></br></br>
					<a href="#">Jackson</a></br></br>
					<button id ="btnEdit2" type="button" class="btn btn-info">Edit</button>
					<button id ="btnDelete2" type="button" class="btn btn-danger" onclick="btnDelete(event)">Delete</button>
				</div>
				
			</div>
		</div>

		<!-- insert book -->
	</br>
	<div class="container-fluid bg-3 text-center">
		<div class="row text-center">
			<div class= "col-sm-1"><button type="button" id="btnAddBook" class="btn btn-success" style="text-align: center;">Add Book</button></div>
		</div>
		<br><br>
		
		<div class="col-sm-7 text-right">
			<ul id="pagination-digg">
				<li class="previous-off">«Previous</li>
				<li class="active">1</li>
				<li><a href="?page=2">2</a></li>
				<li><a href="?page=3">3</a></li>
				<li><a href="?page=4">4</a></li>
				<li><a href="?page=5">5</a></li>
				<li><a href="?page=6">6</a></li>
				<li><a href="?page=7">7</a></li>
				<li class="next"><a href="?page=2">Next »</a></li>
			</ul>
		</div>
	</div>	
		<!-- end code -->




	</body>
</br>
<!-- <footer class="container-fluid text-center footer" style = "background-color:rgb(101, 103, 104);">
	<div class ="container-fluid bg-3 text-center">
		<div class="row">
			<div class ="col-sm-3">
				<h3 style ="text-align:left"><strong>Contact</strong></h3>
				<h5 style ="text-align:left">Green Academy , Khang Thong Tower , Nguyen Thi Minh Khai Street, Ho Chi Minh City</h5>
			</div>
			<div class ="col-sm-3">
			</br>
			<img src="./images/Capture.jpg" class ="image-responsive" style ="width:30%"/>
		</div>



		<div class ="col-sm-3">
			<h3 style ="text-align:left"><strong>Design details</strong></h3>
			<h5 style ="text-align:left"></h5>
		</div>
		<div class ="col-sm-3" style="position:relative">
			<h3 style ="text-align:left"><strong>Stay connected</strong></h3>
			<span class="glyphicon glyphicon-globe"></span>
			<span class="glyphicon glyphicon-earphone"></span>
			<span class="glyphicon glyphicon-cloud-download"></span>   
			<span style="display:inline-block; width: 140px;"></span>
		</div>
	</div>
	<div class ="row" >
	
		<div class = "col-sm-4">
			<h4 style ="text-align:left">Copyright@2011 - Shegy - All rights reserved.</h4>
		</div>
		<div class = "col-sm-5">
		</div>
		<div class = "col-sm-3">
			<h4 style ="text-align:right">Privacy policy | Regulations</h4>
		</div>
	
	</div>

</div>
</footer> -->
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