<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript">
var url = '${pageContext.request.contextPath}';
</script>
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
            background-color: white;
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
        .hideme{
    		display:none;
    		visibility:hidden;
		}
		.showme{
    		display:inline;
    		visibility:visible;
		}
		.alert{
			font-weight:normal;
			color: red;
		}
    </style>
</head>
<body>
	<%@include file="../../comment/header.jsp" %>
    <p align="right"><input class="searchtxtbox" type="text" name="Search" placeholder="Search"></p><br>
    <h1>Catagory Management</h1>
    <div class="content">
    <c:if test="${!empty listCategory}">
    	<table  border="1">
      		<tr>
        		<th>ID</th>
        		<th>Catagory Name</th> 
        		<c:if test = "${userVO.role_id == 1}">
        			<th>Function</th>
        		</c:if>
     		 </tr>
      		<c:forEach items="${listCategory}" var="category">
      			<tr>
					<td width=10%>${category.category_id}</td>
					<td>${category.category_name}</td>
					<c:if test = "${userVO.role_id == 1}">
						<td width=20%>
							<button class="btn btn-warning" type="button" onclick="btnedit(event,${category.category_id})">Edit</button>
							<button class="btn btn-danger" type="button" onclick="btndelete(event,${category.category_id})">Delete</button>
						</td>
					</c:if>
				</tr>
      		</c:forEach>
      		<c:url var="addAction" value="/categorymanagement/category/add" ></c:url>
      			<form:form  action="${addAction}" commandName="category">
      				<tr>
      					<c:if test = "${userVO.role_id == 1}">
      						<td>
      							<c:if test="${!empty category.category_name}">
      								Editing: ${category.category_id}
      								<form:input class="hideme" path="category_id" />
      								<form:hidden class="hideme" path="category_id" />
      							</c:if>
							</td>
							<td>
								<form:input path="category_name" />
								<b class="alert">${error_msg}</b>
							</td>
						</c:if>
						<c:if test = "${userVO.role_id == 1}">
            				<td>
            					<c:if test="${empty category.category_name}"> 
            						<input class="btn-success btn btn-block" type="submit" value="<spring:message text="Insert"/>" /> 
            					</c:if>
            					<c:if test="${!empty category.category_name}"> 
            						<input class="btn-warning btn" type="submit" value="<spring:message text="Update"/>" /> 
            						<button class="btn-danger btn" type="button" onclick="btncancel(event)">Cancel</button>
            					</c:if>
            				</td>
            			</c:if>
      				</tr>
      			</form:form>
    	</table>
    </c:if>
    <br/>
    </div>
    <script>
    function btncancel(event){
    	window.location= url + "/categorymanagement/category/";
    }
    function btnedit(event,id){
    	window.location= url + "/categorymanagement/category/edit/" + id;
    }
    function btnupdate(event,id,name){
    	swal({
            title: "An input!",
            text: "Write something interesting:",
            type: "input",
            showCancelButton: true,
            closeOnConfirm: false,
            animation: "slide-from-top",
            inputPlaceholder: "Write something",
            inputValue: name
          },
          function(inputValue){
            if (inputValue === false) return false;
            if (inputValue === name) {
                swal.showInputError("You need to write something else!");
                return false
              }
            if (inputValue === "") {
              swal.showInputError("You need to write something!");
              return false
            }
            //window.location= url + "/categorymanagement/category/edit/" + id +"/"+ name;
            swal("Nice!", "You wrote: " + inputValue, "success");
          });
    }

    function btndelete(event,id){
    swal({
      title: "Are you sure?",
      text: "You will not be able to recover!",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#DD6B55",
      confirmButtonText: "Yes, delete it!",
      closeOnConfirm: false
    },
    function(isConfirm){
  		if(isConfirm){
  			window.location= url + "/categorymanagement/category/remove/" + id;
  		}
    });
    }
    </script>
</body>
</html>