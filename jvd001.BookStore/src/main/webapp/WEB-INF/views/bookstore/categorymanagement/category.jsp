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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
        h1{
            text-align: center;
        }
        .content{
            width: auto;
            margin-left: auto;
            margin-right: auto;
        }
        table{
            width: 100%;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }
        table *{
            padding: 5px;
        }
         table th{
            text-align: center;
            background-color:azure;
        }
        table tr:nth-child(even) {
            background-color: white;
        }
        table tr:nth-child(odd) {
            background-color: #dddddd;
        }
        .searchtxtbox{
            -moz-border-radius: 10px;
            -webkit-border-radius: 10px;
            border-radius:10px;
            text-align: left;
            
        }
        .btn-block {
            -moz-border-radius: 20px;
            -webkit-border-radius: 20px;
            border-radius: 20px;
        }
    </style>
</head>
<body>
	<%@include file="../../comment/header.jsp" %>
    <p align="right"><input class="searchtxtbox" type="text" name="Search" placeholder="Search"></p><br>
    <h1>Catagory Management</h1>
    <div class="content">
    <c:if test="${!empty listCategory}">
    <table class="table-bordered" border="1">
      <tr>
        <th>ID</th>
        <th>Catagory Name</th> 
        <th>Function</th>
      </tr>
      <c:forEach items="${listCategory}" var="category">
      	<tr>
			<td>${category.id}</td>
			<td>${category.name}</td>
			<td><button class="btn btn-warning" type="button" onclick="btnadd(event)">Update</button> <button class="btn btn-danger" type="button" onclick="btndelete(event)">Delete</button></td>
		</tr>
      </c:forEach>
      <!-- <tr>
        <td>1</td>
        <td>Comedy</td>
        <td><button class="btn btn-warning" type="button" onclick="btnadd(event)">Update</button> <button class="btn btn-danger" type="button" onclick="btndelete(event)">Delete</button></td>
      </tr>
      <tr>
        <td>2</td>
        <td>Horror</td>
        <td><button class="btn btn-warning" type="button" onclick="btnadd(event)">Update</button> <button class="btn btn-danger" type="button" onclick="btndelete(event)">Delete</button></td>
      </tr>
      <tr>
        <td>3</td>
        <td>Literary</td>
        <td><button class="btn btn-warning" type="button" onclick="btnadd(event)">Update</button> <button class="btn btn-danger" type="button" onclick="btndelete(event)">Delete</button></td>
      </tr>
        <tr>
            <td>4</td>
            <td colspan="2"><button class="btn-success btn-lg btn-block" type="button" onclick="btnadd(event)">Insert</button></td>
        </tr>-->
    </table>
    </c:if>
    <br/>
    </div>
    <script>
    function btnupdate(event){
        swal("Good job!", "You clicked the button!", "success");
    }
    function btnadd(event){
    swal({
          title: "An input!",
          text: "Write something interesting:",
          type: "input",
          showCancelButton: true,
          closeOnConfirm: false,
          animation: "slide-from-top",
          inputPlaceholder: "Write something"
        },
        function(inputValue){
          if (inputValue === false) return false;

          if (inputValue === "") {
            swal.showInputError("You need to write something!");
            return false
          }

          swal("Nice!", "You wrote: " + inputValue, "success");
        });
    }
    function btndelete(event){
    swal({
      title: "Are you sure?",
      text: "You will not be able to recover!",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#DD6B55",
      confirmButtonText: "Yes, delete it!",
      closeOnConfirm: false
    },
    function(){
      swal("Deleted!", "Your imaginary file has been deleted.", "success");
    });
    }
    </script>
</body>
</html>