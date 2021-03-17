<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>SAMTECH | Tareas</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link rel="shortcut icon" href="resources/img/favicon.ico" />
</head>
<body>
	<h3>Login Form</h3>
	<FONT color="blue"> User Name="UserName" and password="password"
	</FONT>
	<form:form action="loginform.html" commandName="loginForm">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Username"
				required="">
		
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="Password"
				required="">
			<div id="capapass" style="margin-top:15px;"></div>
		</div>
		<button type="button" class="btn btn-primary block full-width m-b">Login</button>
	</form:form>

	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/inspinia.js"></script>
	
	<script>
	
	</script>
</body>
</html>