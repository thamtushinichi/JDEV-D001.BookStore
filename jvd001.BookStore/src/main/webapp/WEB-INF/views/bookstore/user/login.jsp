<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

</br>
<div class="container-fluid bg-3 text-center">
	<div class="row">
		<div class="col-sm-2">
		<img src="./images/bookstore-logo_1x.jpg" width="136px" height = "128px"/>
		</div>
		<div class="col-sm-3">
		</br></br>
			<tab1>BOOK<tab2>STORE</tab2></tab1>
		</div>
		<div class="col-sm-3">
			
		</div>
		<div class="col-sm-4">
		</br></br>
			<span style="font-size:30px">CALL NOW!<span style="font-size:30px;color:rgb(193, 219, 200);"> 1-800-123-4567</span></span>
		</div>
	</div>
</div>
  </br>

<div class="jumbotron">
  <div class="container text-center">
    <p><h2 ><strong>LOGIN</strong></h2></p>
	</br>
	
  </div>
</div>

<div class="container">
        <div class="card card-container">
            
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
                <div class="text-center">
                	<button class="btn btn-lg btn-primary btn-signin" type="submit">Sign in</button>
                </div>
                
            </form><!-- /form -->
            <a href="#" class="register">
                Don't have an account? Register
            </a>
        </div><!-- /card-container -->
    

</br></br></br>
<footer class="container-fluid text-center" style = "background-color:rgb(101, 103, 104);">
  <div class ="container-fluid bg-3 text-center">
  <div class="row">
	<div class ="col-sm-3">
		<h3 style ="text-align:left"><strong>Contact</strong></h3>
		<h5 style ="text-align:left">Green Academy , Khang Thong Tower , Nguyen Thi Minh Khai Street, Ho Chi Minh City</h5>
	</div>
	<div class ="col-sm-3">
		</br>
		<img src="./images/Capture.jpg" class ="image-responsive" style ="width:100%"/>
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
		 <span class="glyphicon glyphicon-globe"></span>
		 <span class="glyphicon glyphicon-earphone"></span>
		 <span class="glyphicon glyphicon-cloud-download"></span> 
		 <span class="glyphicon glyphicon-globe"></span>
		 <span class="glyphicon glyphicon-earphone"></span>
		
		<span style="display:inline-block; width: 140px;"></span>
	</div>
  </div>
  </div>
  </footer>
  <div class="container-fluid" style = "background-color:rgb(86, 88, 86);">
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
</body>
</html>