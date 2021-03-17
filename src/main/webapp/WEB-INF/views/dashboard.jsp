<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cl.samtech.ot.*"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SAMTECH | Tareas ESCONDIDA</title>
<link rel="shortcut icon" href="resources/img/favicon.ico" />
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/plugins/dataTables/datatables.min.css"
	rel="stylesheet">
    
<link href="resources/css/plugins/c3/c3.min.css" rel="stylesheet">
</head>

<body class="">



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
                <li>
                    <span class="m-r-sm text-muted welcome-message">Bienvenido
							a Samtech Tareas.</span>
                </li>
                           


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
                        <li>
                            <a href="principal.html">Principal</a>
                        </li>                
                        <li>
                            <strong>Tareas</strong>
                        </li>
                    </ol>
                </div>
            </div>
            <%
							String  tareasactuales = (String)request.getAttribute("tareasactuales");
							
							String[] a = tareasactuales.split(",");
						   
						      
							
							
							%>

            <div class="wrapper wrapper-content animated fadeInRightBig">
					<div class="row">
						<div class="col-lg-3">							
							<div class="ibox float-e-margins">
	                            <div class="ibox-title">
	                                <span class="label label-success pull-right">Total Creadas</span>
	                                <h5>Tareas</h5>
	                            </div>
	                           <div class="ibox-content">
	                                <h1 class="no-margins text-center text-success"><%=a[0] %></h1>
	                                <div class="stat-percent font-bold text-success">100% </i></div>
	                               
	                            </div>
                        	</div>							
						</div>
						<div class="col-lg-3">							
							<div class="ibox float-e-margins">
	                            <div class="ibox-title">
	                                <span class="label label-info pull-right">Total Planificadas</span>
	                                <h5>Tareas</h5>
	                            </div>
	                           <div class="ibox-content">
	                                <h1 class="no-margins text-center text-info"><%=a[1] %></h1>
	                                <div class="stat-percent font-bold text-info"><%=a[4] %>% </i></div>
	                               
	                            </div>
                        	</div>							
						</div>
						<div class="col-lg-3">							
							<div class="ibox float-e-margins">
	                            <div class="ibox-title">
	                                <span class="label label-primary pull-right">Total Terminadas</span>
	                                <h5>Tareas</h5>
	                            </div>
	                           <div class="ibox-content">
	                                <h1 class="no-margins text-center text-navy"><%=a[2] %></h1>
	                                <div class="stat-percent font-bold text-navy"><%=a[5] %>% </i></div>
	                               
	                            </div>
                        	</div>							
						</div>
						<div class="col-lg-3">							
							<div class="ibox float-e-margins">
	                            <div class="ibox-title">
	                                <span class="label label-danger pull-right">Total Atrasadas</span>
	                                <h5>Tareas</h5>
	                            </div>
	                           <div class="ibox-content">
	                                <h1 class="no-margins text-center text-danger"><%=a[3] %></h1>
	                                <div class="stat-percent font-bold text-danger"><%=a[6] %>% </i></div>
	                               
	                            </div>
                        	</div>							
						</div>
						
						
						
				</div>
				
				
				
				<div class="row">
         
                    <div class="col-lg-12">
						<div class="ibox-content">
						<div class="ibox-title">
	                               
	                                <h5>Tareas Planificadas versus terminadas (Marzo)</h5>
	                            </div>
                            <div>
                                <div id="slineChart" ></div>
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
        <script src="resources/js/plugins/d3/d3.min.js"></script>
    <script src="resources/js/plugins/c3/c3.min.js"></script>
 
    <script>
    var chart1 = c3.generate({
        padding: {
		        top: 10,
		        right: 30,
		        bottom: 0,
		        left: 30,
			},
            bindto: '#slineChart',
            data:{
            	x: 'x',
                columns: [
                	
                	<%
					if (request.getAttribute("tareasgrafico") != null
							&& !(request.getAttribute("tareasgrafico")).equals("")) {
						datosgrafico dg = (datosgrafico) request.getAttribute("tareasgrafico");
				%>
				<%=dg.getFechaGrafico() %>,
                	<%=dg.getPlanificadas() %>,
                    <%=dg.getRealizadas() %>
                  
                	<%}%>
                ],colors:{
                    Total: '#DCDCDC',
                    'Planificadas': '#85C1E9',
						'Terminadas': '#2ECC71'				
                },
                type: 'spline',
				types: {
					Planificadas: 'bar'
    			}
            },axis : {
					x : {
						type : 'timeseries',
						tick: {
							rotate: 90,
						    format: '%d-%m-%Y',
						    culling: {
							                    max: 1
            				}
						}

					},
					y: {
					            padding: {top: 10, bottom: 0},
					            show: true
    				}

				}
        });
        
        
        
       
    </script>


</body>

</html>
