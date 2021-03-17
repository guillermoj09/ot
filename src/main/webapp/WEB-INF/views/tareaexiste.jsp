<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cl.samtech.ot.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link href="resources/css/plugins/dataTables/datatables.min.css"
	rel="stylesheet">


<link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">


<link
	href="resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css"
	rel="stylesheet">

</head>

<body>
	<script type="text/javascript">
		function limpiar(){
			document.getElementById("crearEstanqueForm").id.value = "";
			document.getElementById("crearEstanqueForm").nombre.value = "";
			document.getElementById("crearEstanqueForm").capEsta.value = "";
			document.getElementById("crearEstanqueForm").capAdver.value = "";
			document.getElementById("crearEstanqueForm").capInsu.value = "";
			document.getElementById("crearEstanqueForm").valSup.value = "";
			document.getElementById("crearEstanqueForm").valInf.value = "";
			document.getElementById("crearEstanqueForm").latitud.value = "";
			document.getElementById("crearEstanqueForm").longitud.value = "";
			document.getElementById("crearEstanqueForm").volSup.value = "";
			document.getElementById("crearEstanqueForm").volInf.value = "";
		}			  	
		
		function validar(){
						
			error=0;
				
			
			if(error==0){
				document.getElementById("crearReservaForm").submit();
			}
			
			
		}
		
		
		
	</script>



	<div id="wrapper">

		<%@include file="menu.jsp"%>

		<div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
						href="#"><i class="fa fa-bars"></i> </a>

				</div>
				<ul class="nav navbar-top-links navbar-right">
					<li><span class="m-r-sm text-muted welcome-message">Bienvenido
							a Samtech Tareas.</span></li>

					


					<li><a href="logout.html"> <i class="fa fa-sign-out"></i>
							Salir
					</a></li>
				</ul>

				</nav>
			</div>

			<div class="row wrapper border-bottom white-bg page-heading">
				<div class="col-sm-4">
					<h2>Tareas</h2>
					<ol class="breadcrumb">
						<li>Principal</li>						
						<li class="active"><strong>Crear Tarea</strong></li>
					</ol>
				</div>
			</div>

			<div class="wrapper wrapper-content animated fadeInRightBig">
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox">
							<div class="ibox-title">
								<h5>Crear Tarea</h5>
							</div>

							<div class="ibox-content">
								<div class="row">
									<div class="col-sm-12 b-r">
										<h3 class="m-t-none m-b">Tarea No ha sido Grabada!</h3>
										<p>Asegurese que la Tarea este bien completada.</p>
										<p>Si continua el error comuniquese con el Administrador del Sistema.</p>
										<br>
										<br>
										<div>
											<button class="btn btn-sm btn-primary pull-left m-t-n-xs"
												type="button" onClick="history.back()">
												<strong>Volver</strong>
											</button>

										</div>


									</div>

								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			
			
			
			
			<div class="footer">
				<div>
					<strong>Copyright</strong> SAMTECH &copy; 2017
				</div>
			</div>

		</div>
	</div>


	<!-- Mainly scripts -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="resources/js/plugins/dataTables/datatables.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="resources/js/inspinia.js"></script>
	<script src="resources/js/plugins/pace/pace.min.js"></script>

	<script>
		$(document).ready(function(){
            $('.dataTables-example').DataTable({
                pageLength: 25,
                responsive: true,
                dom: '<"html5buttons"B>lTfgitp',
                buttons: [
                    { extend: 'copy'},
                    {extend: 'csv'},
                    {extend: 'excel', title: 'Estanques'},
                    {extend: 'pdf', title: 'Estanques'},

                    {extend: 'print',
                     customize: function (win){
                            $(win.document.body).addClass('white-bg');
                            $(win.document.body).css('font-size', '10px');

                            $(win.document.body).find('table')
                                    .addClass('compact')
                                    .css('font-size', 'inherit');
                    }
                    }
                ]

            });

        });
	</script>

</body>

</html>
