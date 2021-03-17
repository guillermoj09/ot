<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="model.Ot"%>
<%@ page import="model.Instalacion"%>
<%@ page import="model.Agenda"%>
<%@ page import="model.SamHardware"%>
<%@ page import="model.SamFichaHardware"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SAMTECH | Tareas Samtech</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.css"rel="stylesheet">
<link href="resources/css/plugins/clockpicker/clockpicker.css" rel="stylesheet">

<link href="resources/css/plugins/select2/select2.min.css" rel="stylesheet">
<link href="resources/css/plugins/switchery/switchery.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
   <link href="resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<!-- Sign -->
<link href="resources/jsing/jquery.signaturepad.css" rel="stylesheet">
<link rel="shortcut icon" href="resources/img/favicon.ico" />	
<style type="text/css">
	#signArea {
	width:  auto;
	margin: 0px auto;
}
</style>
</head>

<body>

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
					<li><span class="m-r-sm text-muted welcome-message">Bienvenido a Samtech Tareas.</span></li>
					<li><a href="logout.html"> <i class="fa fa-sign-out"></i>
							Salir
					</a></li>
				</ul>

			</nav>
		</div>
		<%
			Agenda t = (Agenda) request.getAttribute("tarea");
			String fechaCreacion = "";
			if (t.getFechaComienzo() == null) {

				fechaCreacion = "";
			} else {
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(t.getFechaComienzo().getTime());

				Date DD = new Date();
				DD.setTime(t.getFechaComienzo().getTime());

				fechaCreacion = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(DD);
				//fechaCreacion=DD.toString();
			}

			String fechaInicio = "";
			String prioridad = "";
		%>
		<div class="wrapper wrapper-content animated fadeInRightBig">
			<div class="row">
				<div class="col-lg-8 col-md-offset-2">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Datos</h5>
							<div class="ibox-tools">
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
								</a> 
							</div>
						</div>
						<div class="ibox-content">
							<div class="row">
								<div class="col-md-6 col-sm-6 col-xs-6">
									<h3 class="text-center">Actividad</h3>
									<h3 class="text-center">Fecha Comienzo</h3>
									<h3 class="text-center">Empresa</h3>
									<h3 class="text-center">Contacto</h3>
									<h3 class="text-center">Telefono</h3>
									<h3 class="text-center">Patentes</h3>
									<h3 class="text-center">Direccion</h3>
									<h3 class="text-center">Descripcion</h3>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-6">
									<p class="text-center"><%=t.getTitulo()%>.
									</p>
									<p class="text-center"><%=fechaCreacion%></p>
									<p class="text-center"><%=t.getEmpresa()%></p>
									<p class="text-center"><%=t.getContacto()%></p>
									<p class="text-center"><%=t.getTelefono()%></p>
									<p class="text-center"><%=t.getPatentes()%></p>
									<p class="text-center"><%=t.getDireccion()%></p>
									<p class="text-center"><%=t.getDescripcion()%></p>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="row">
					<div class="col-lg-8 col-md-offset-2">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Instalaciones</h5>
							<% Integer InstaPend =  (Integer)request.getAttribute("InstaPendiente");
								Integer InstaInstaldas =  (Integer)request.getAttribute("InstaInstaladas"); %>
							<h2 class="text-center">Instaladas  <%=InstaInstaldas %> / <%=InstaPend %></h2>
							<div class="ibox-tools">
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a> 
								
							</div>
						</div>
						<div class="ibox-content">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>ID</th>
										<th>Patente</th>
										<th>Estado</th>
										<th>Editar</th>
									</tr>
								</thead>
								<tbody>
						<%
							int verificador = 0;
							if (request.getAttribute("ot") != null || !(request.getAttribute("ot")).equals("")) {
								Ot ot = (Ot) request.getAttribute("ot");
								if (ot.getInstalacions() != null) {
									List<Instalacion> insta = ot.getInstalacions();
									for (Instalacion f : insta) {
										if(f.getEstado() == 2){
										%>
										<tr>
											<td><%=f.getIdDevice()%></td>
											<td>
												<%
												if (f.getPatente() != null) {
													out.print(f.getPatente());
												} else {
													out.print("- - - -");
												}
												%>
											</td>
											<%	if (f.getEstado() == 2) {
													
											%>
											<td class="estado">Listo</td>
											<%
												} 
											
											%>
											<td><a href="editartarea.html?op=2&id_insta=<%=f.getId()%>&lc=<%=request.getParameter("lc")%>&idGps=<%=f.getIdDevice()%>&id=<%=ot.getId()%>"
												class="btn btn-primary btn-xs"> Modificar</a>
											</td>
		
										</tr>
										<% } } } }%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<form action="finalizartarea.html" name="FinalizarForm" id="FinalizarForm"  method="post">
				<div class="row">
					<div class="col-lg-8 col-md-offset-2">
						<div class="ibox ">
							<div class="ibox-title">
								<h5>Observaciones</h5>
							</div>
							<div class="ibox-content">
								<div class="form-group">
									<label for="comment">Comentario: </label>
									<textarea class="form-control" rows="5" required id="observaciones"
										name="observaciones"></textarea>
									<div id="obs"></div>
								</div>
								
								<h2 class="text-center">Datos Cliente</h2>
								
								<div class="form-group">
									<label>Nombre de quien acepta</label> <input type="text"
										name="nombrecliente" class="form-control" required id="nombrecliente">
									<div id="nomcli"></div>
								</div>
								
								<div class="form-group">
									<label>Rut :</label> <input type="text" name="rutcliente"
										class="form-control"  id="rutcliente" onchange="verificarRut(this)">
									<div id="divrut"></div>	
								</div>
								<div class="form-group">
									<label>Cargo :</label> <input type="text" class="form-control"
										name="cargo"  required id="cargo">
									<div id="divcargo"></div>
								</div>
								<div class="form-group">
									<label>Email :</label> <input type="text" required class="form-control"
										name="email" id="email" >
									<div id="divemail"></div>
								</div>
								<div class="form-group">
									<label>Hora inicio trabajo: </label>
									<div class="input-group clockpicker" data-autoclose="true">									
		                                <input type="text" class="form-control" name="horainicio" id="horainicio" value="" >
		                                <span class="input-group-addon">
		                                    <span class="fa fa-clock-o"></span>
		                                </span>
		                            </div>
								</div>
							</div>
							<%
								Ot ot = (Ot) request.getAttribute("ot");
								Long id_ot = ot.getId();
							%>

							<input type="hidden" name="folio" id="folio" value="<%=t.getEmpresa()%>" /> 
							<input type="hidden" name="anexo" id="anexo" value="<%=t.getFolioAnexo()%>" /> 
							<input type="hidden" name="id_ot" id="id_ot" value="<%=id_ot%>" />
							<input type="hidden" name="fechaInicio" value="<%=fechaCreacion%>">
							<input type="hidden" name="img_val" id="img_val" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="ibox">
							<div class="form-group custom-input-space has-feedback">
								<div class="page-body clearfix">
									<div class="row">
										<div class="col-md-4 col-md-offset-4">
											<div id="signArea">
												<canvas class="sign-pad" id="sign-pad" height="200" width="330"></canvas>

											</div>
											<button class="btn btn-primary m-t-n-xs" type="button"
												id="clear" tabindex="10">
												<strong> Limpiar</strong>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">			
					<div class="col-md-3 col-md-offset-5">
							<!--  <button class="btn btn-primary m-t-n-xs" type="button" onClick="validarGPS()" id="guardar_usu" tabindex="9">-->
							<% //if(InstaInstaldas == InstaPend){ %>
								
								<input type="button" class="btn btn-danger m-t-n-xs"  id="btnSaveSign" onclick="validarForm()" value="Finalizar OT">
									
							<% //} %>
					</div>
				</div>
			</form>
		</div>

	</div>

	 <!-- Mainly scripts -->
    <script src="resources/js/jquery-3.1.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Peity -->
    <script src="resources/js/plugins/peity/jquery.peity.min.js"></script>
	
    <!-- Custom and plugin javascript -->
    <script src="resources/js/inspinia.js"></script>
    <script src="resources/js/plugins/pace/pace.min.js"></script>
	
	<script src="resources/js/plugins/select2/select2.full.min.js"></script>    
	<script src="resources/js/plugins/switchery/switchery.js"></script>
    <!-- iCheck -->
    <script src="resources/js/plugins/iCheck/icheck.min.js"></script>

    <!-- Peity -->
    <script src="resources/js/demo/peity-demo.js"></script>
    
	<!-- SIGNATURE -->
	<script src="resources/jsing/numeric-1.2.6.min.js.descarga"></script>
	<script src="resources/jsing/bezier.js.descarga"></script>
	<script src="resources/jsing/jquery.signaturepad.js.descarga"></script>
	<script src="resources/jsing/json2.min.js.descarga"></script>	
	<script	src="resources/jsing/html2canvas.js.descarga"></script>
	
	<!-- Clock picker -->
    <script src="resources/js/plugins/clockpicker/clockpicker.js"></script>
	<!-- RUT -->
	<script type="text/javascript" src="resources/js/jquery.rut.chileno.min.js"></script>
	<script src="resources/js/plugins/sweetalert/sweetalert.min.js"></script>
	
	<script>

		
		function validarForm(){
			var contador = 0;
			if($("#observaciones").val() == "" ){
				$("#obs").html("<label id='-error' class='error' for=''>Por favor, rellene campo.</label>");
			}else{
				contador++;
				$("#obs").html("");
			}
			
			if($("#nombrecliente").val() == ""){
				$("#nomcli").html("<label id='-error' class='error' for=''>Por favor, rellene campo.</label>");
			}else{
				contador++;
				$("#nomcli").html("");
			}
			
			if($("#cargo").val() == ""){
				$("#divcargo").html("<label id='-error' class='error' for=''>Por favor, rellene campo.</label>");
			}else{
				contador++;
				$("#divcargo").html("");
			}
			
			if($("#email").val() == ""){
				$("#divemail").html("<label id='-error' class='error' for=''>Por favor, rellene campo.</label>");
				
				
			}else{
				var validate = validateEmail();
				if(!validate){
					document.getElementById("divemail").innerHTML  = "<label id='-error' class='error' for=''>Ingrese el email correctamente</label>";
				}else{
					contador++;
					$("#divemail").html("");
				}
				
			}
		
			
			if($("#rutcliente").val() == ""){
				$("#divrut").html("<label id='-error' class='error' for=''>Por favor, rellene campo.</label>");
				
			}else{
				contador++;
				$("#divrut").html("");
			}
			
			
			console.log("contador "+contador);
			if(contador >= 5){
				console.log("entro");
				html2canvas(document.getElementById("sign-pad"),{
					onrendered : function(canvas) {
						document.getElementById('img_val').value = canvas.toDataURL("image/png");
						//alert(document.getElementById('img_val').value);
						validar = $('#signArea').signaturePad().validateForm();
						if(validar){
							document.getElementById("FinalizarForm").submit();							
						}else{
							swal("Por favor, introducir firma");
						}
						
					}
				});
					
			}
		}
		
		
		function validateEmail() {
			var email = $("#email").val();
			console.log(email);
            var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
            var validate = emailReg.test( email );
            return validate; 
        }
		
		var validacion=0;
		function verificarRut(event){
			console.log('click')
			 $('#rutcliente').rut({
			      fn_error : function(input){
			    	 // alert('El rut: ' + input.val() + ' es incorrecto');
			    	 if($("#rutcliente").val() != ""){
	                      swal({
	                    	  title: "Rut Incorrecto!",
	                          text: "Por favor ingrese el rut nuevamente!",
	                          type: "warning",
	                          closeOnConfirm: true
	                          },
	                      function (isConfirm) {
	                        	validacion++;
	                          if (isConfirm) {
	                        	  if(validacion > 2){
	                        		  $("#rutcliente").val("");
	                        		  validacion=0;
	                        	  }else{
	                        		  $("#rutcliente").focus();
	                        	  }
	                        	 
	                          }
	                      });
			    	 }
			    	
			    	 
			      },
			      placeholder: false
			});
			console.log(validacion);
		}	
		
		
		
		
		$(document).ready(function(e) {
		
			$('.clockpicker').clockpicker();
	
			
			$('#signArea').signaturePad({
				drawOnly : true,
				drawBezierCurves : true,
				lineTop : 190,
			});

			document.getElementById('clear').addEventListener('click',function() {
				$('#signArea').signaturePad().clearCanvas();
			});

		
			

		});
	</script>
</body>
</html>