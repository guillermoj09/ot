<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>SAMTECH | Tareas</title>
<link rel="shortcut icon" href="resources/img/favicon.ico" />
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

	<div class="middle-box text-center loginscreen animated fadeInDown">
		<div>
			<br>
			<br>
			<br>
			<br>
			<img src="resources/img/logohome.png"><br>
			<br>
			<h3>Bienvenido a Samtech</h3>
			<p>Ordenes de Trabajo (Tareas).</p>
			<p>Ingresar Usuario y Contraseña.</p>
			
			<form class="m-t" role="form"  method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Username"
						required="" id="username" name="userName">
				
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						required="" id="password" name="password">
					<div id="resultado" style="margin-top:15px;"></div>
				</div>
				<button type="button" id="enviar" class="btn btn-primary block full-width m-b">Login</button>


			</form>
			<p class="m-t">
				<small>Copyright</strong> SAMTECH &copy; 2017
				</small>
			</p>
		</div>
	</div>

	<!-- Mainly scripts -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function(){
			
		
			$("#enviar").click(function(){
				
				var vusername = $("#username").val();
				var vpassword = $("#password").val();
				if(vusername != "" && vpassword != ""){
					
					$.ajax({
						type : 'POST',
			   			url : 'loginform.html',
			   			data : {
			   				username : vusername,
			   				password : vpassword,	   				
			   			},
			   			success : function(respuesta) {

			   				if(respuesta == 'U0'){
			   					$("#resultado").html("<label id='-error' class='error' for=''>Credenciales usuario/password incorrectas</label>");
			   				}
			   				if(respuesta == 'P0'){
			   					$("#resultado").html("<label id='-error' class='error' for=''>Credenciales usuario/password incorrectas</label>");
			   				}
			   				if(respuesta == 'OK'){
			   					location.href = 'principal.html';								
			   				}
			   			}
					})
					
				}else{
					$("#resultado").html("");
   					$("#resultado").html("<label id='-error' class='error' for=''>Por favor, completar campos requeridos</label>");
				}

			});
		});
	</script>
</body>
	
</html>