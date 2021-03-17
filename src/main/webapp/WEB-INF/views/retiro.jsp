<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
<link rel="shortcut icon" href="resources/img/favicon.ico" />
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">
    <link href="resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/plugins/dataTables/datatables.min.css"
	rel="stylesheet">

<title>SAMTECH | Tareas</title>
</head>
	<body>
		
    <%@include file="menu.jsp"%>
	<div id="page-wrapper" class="gray-bg">
	
		<div class="row border-bottom">
	        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
						href="#"><i class="fa fa-bars"></i> </a>
				</div>
            	<ul class="nav navbar-top-links navbar-right">
	                <li>
	                    <span class="m-r-sm text-muted welcome-message">Bienvenido
								a Samtech Tareas.</span>
	                </li>                          
	                <li><a href="logout.html"> <i class="fa fa-sign-out"></i>Salir</a></li>
	            </ul>
	        </nav>
        </div>
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-sm-4">
                    <h2>Tareas</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="principal.html">Principal</a>
                        </li>                
                        <li>
                            <strong>Retiro de equipo</strong>
                        </li>
                    </ol>
                </div>
            </div>
		<div class="wrapper wrapper-content animated fadeInRightBig">
			<div class="row">
				<div class="col-lg-8 col-md-offset-2">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Datos</h5>
							<div class="ibox-tools">
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
								</a> 
								<a class="close-link"> <i class="fa fa-times"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							 <form class="form-horizontal">
                                <p>Ingrese Gps a retirar</p>
                                <div class="form-group"><label class="col-lg-2 control-label">Id device</label>
                                    <div class="col-lg-10"><input type="text" placeholder="ingrese gps" class="form-control"> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-sm btn-white" type="button">Buscar</button>
                                    </div>
                                </div>
                            </form>
							
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script src="resources/js/jquery-3.1.1.min.js"></script>    
		
	<!-- Mainly scripts -->
		<script src="resources/js/popper.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
		<script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
		
		<script src="resources/js/plugins/dataTables/datatables.min.js"></script>
		
    <!-- Custom and plugin javascript -->
    <script src="resources/js/inspinia.js"></script>
    <script src="resources/js/plugins/pace/pace.min.js"></script>
    <script src="resources/js/plugins/sweetalert/sweetalert.min.js"></script>
    		
	</body>
</html>