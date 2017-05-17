<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style>
  
  <tab3>
  {
	padding-right:4cm;
  }
  .btn {
  -webkit-border-radius: 60;
  -moz-border-radius: 60;
  border-radius: 60px;
  font-family: Arial;
  color: #181a17;
  font-size: 18px;
  background: #0994f0;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}

  tab2
  {
	font-size:30px;
	text-align:left;
	color:rgb(193, 219, 200);
	font-family:Arial;
	
  }
  tab1{text-align:left;
  
  font-size:30px;
  color:black;
  }
  p{
	color: black;
  }
  .right1 {

  color: rgb(3, 193, 213);
  }

  strong{
  color-background: black;
  color: black;
  }
  .button1{
  background-color: rgb(27, 118, 255);
  
 
  }
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
	.carousel-inner > .item > img,
  	.carousel-inner > .item > a > img {
      width: 20%;
      margin: auto;
  }
  </style>
</head>
<body>
<%@ include file="../../comment/header.jsp"%>



<div class="jumbotron">
  <div class="container text-center">
    <p><h2 ><strong><font color="red">You've logged out successfully!</font></strong></h2></p>
    
    <p><h2 ><strong><font color="red"></font></strong></h2></p>
	
  </div>
</div>


<%@ include file="../../comment/footer.jsp"%>
</body>
</html>