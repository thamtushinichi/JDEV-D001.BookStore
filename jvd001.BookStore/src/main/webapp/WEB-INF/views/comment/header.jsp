<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/bookstore/">Logo</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/bookstore/">Home</a></li>
				<c:choose>
    				<c:when test="${userVO.role_id==1}">
       					<!-- if user la admin-->
       					<li><a href="#">User Management</a></li>
       				<li><a href="/bookstore/categorymanagement/category">Category Management</a></li>
       				<li><a href="/bookstore/bookmanagement">Book Management</a></li>
   					 </c:when>    
   					 <c:when test="${userVO.role_id==2}">
       					<!-- if user la user-->
       					
       				<li><a href="/bookstore/bookmanagement">Book Management</a></li>
       				 
   					 </c:when>   
   				 <c:otherwise>
      			<!-- else -->
       			
    			</c:otherwise>
			</c:choose>
				<li><a href="#">Contact</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">

				<c:choose>
					<c:when test="${userVO.users_id>0||userVO.username!=null}">
						<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
								Hello ${userVO.fullname}</a></li>
								<li><a href="/bookstore/logout"><span class="glyphicon glyphicon-log-in"></span>
								Log Out</a></li>
						
					</c:when>
					<c:otherwise>
						<li><a href="/bookstore/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
						<li><a href="/bookstore/signup"><span
								class="glyphicon glyphicon-log-in"></span> Sign Up</a></li>
						
					</c:otherwise>
				</c:choose>


			</ul>
		</div>
	</div>
</nav>