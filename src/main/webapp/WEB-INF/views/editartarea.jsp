	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cl.samtech.ot.*"%>
<%@ page import="model.*"%>
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
<!-- Sweet Alert -->	
<link href="resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

<link href="resources/css/plugins/dropzone/basic.css" rel="stylesheet">
<link href="resources/css/plugins/dropzone/dropzone.css"
	rel="stylesheet">
<link href="resources/css/plugins/jasny/jasny-bootstrap.min.css"
	rel="stylesheet">
<link href="resources/css/plugins/codemirror/codemirror.css"
	rel="stylesheet">
<link href="resources/css/plugins/select2/select2.min.css" rel="stylesheet">

<link href="resources/css/animate.css" rel="stylesheet">	
<link href="resources/css/style.css" rel="stylesheet">



<style type="text/css">
	.dropzone .dz-preview .dz-image img{
    border-radius: 1px;
    width: 100%;
    height: 100%;
</style>
</head>

<body>


	<div id="wrapper">

		<%@include file="menu.jsp"%>
		<script type="text/javascript">


		function validarGPS(){	
		
			ajax=objetoAjax();
			var selectPer = $("[name='perifericos']").val();
			console.log(selectPer);
	        ajax.open("GET", 'otajax.html?anexo='+document.getElementById("txtAnexo").value+'&folio='+document.getElementById("txtFolio").value+'&ot=<%=request.getParameter("id")%>&accion=1&perifericos='+selectPer+'&id='+document.getElementById("textgps").value);
	       
	        ajax.onreadystatechange=function() {
	                if (ajax.readyState==4) {
						document.getElementById("validacion").innerHTML = ajax.responseText;
						document.getElementById("validacionoculta").value= ajax.responseText;
						 				
	                }//Fin Response
	        }
	        ajax.send(null)		
				
		}
		
		function completar(){	
			
			ajax=objetoAjax();
	        ajax.open("GET", 'otajax.html?accion=5&id=<%=request.getParameter("id")%>');
	        ajax.onreadystatechange=function() {
	                if (ajax.readyState==4) {
						document.getElementById("completada").innerHTML = ajax.responseText;
						 				
	                }//Fin Response
	        }
	        ajax.send(null)		
				
		}

		function validar(){
			error=0;
			if(document.getElementById("estado").selectedIndex == 3){
				
			ajax=objetoAjax();
	         ajax.open("GET", 'otajax.html?accion=10&id=<%=request.getParameter("id")%>');
	         ajax.onreadystatechange=function() {
	                 if (ajax.readyState==4) {
	                	 error=ajax.responseText;
	                	 if(error == 1){
	                			
	                			 document.getElementById("estado").selectedIndex == 0
	                	            	({
	                	                title: "Falta Informacion",
	                	                text: "Debe Agregar al menos Una Foto Final."
	                	            });
	                			               			
	                		}else{
	                			if(document.getElementById("estado").selectedIndex == 0){
	                				document.getElementById("estadot").className = "form-group has-error";
	                				error=1;				
	                			}else{
	                				document.getElementById("estadot").className = "form-group has-success";				
	                			}
	                			if(error==0){
	                				document.getElementById("crearTareaForm").submit();
	                			}
	                			
	                		}
	                	
	                 }
	         }
	         ajax.send(null)
			}else{
				if(document.getElementById("estado").selectedIndex == 0){
    				document.getElementById("estadot").className = "form-group has-error";
    				error=1;				
    			}else{
    				document.getElementById("estadot").className = "form-group has-success";				
    			}
    			if(error==0){
    				document.getElementById("crearTareaForm").submit();
    			}
				
			}
	     	
			if(document.getElementById("crearTareaForm").fechaInicio.value == ''){
				document.getElementById("fechainiciot").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("fechainiciot").className = "form-group has-success";				
			}
			
			if(document.getElementById("crearTareaForm").fechaTermino.value == ''){
				document.getElementById("fechaterminot").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("fechaterminot").className = "form-group has-success";				
			}
			
			if(document.getElementById("prioridad").selectedIndex == '0'){
				document.getElementById("prioridadt").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("prioridadt").className = "form-group has-success";				
			}
			if(error==0){
				document.getElementById("crearTareaForm").submit();
			}
				
		}
		function enviarfoto1(){
			document.getElementById("dropzoneForm").submit();
		}
		
	
	</script>
		<div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
						href="#"><i class="fa fa-bars"></i> 
					</a>
				</div>
				<ul class="nav navbar-top-links navbar-right">
					<li><span class="m-r-sm text-muted welcome-message">Bienvenido a Samtech Tareas.</span></li>
					<li><a href="logout.html"> <i class="fa fa-sign-out"></i>Salir</a></li>
				</ul>
				</nav>
			</div>

			<div class="row wrapper border-bottom white-bg page-heading">
				<div class="col-sm-4">
					<h2>Tareas</h2>
					<ol class="breadcrumb">
						<li>Principal</li>
						<li class="active"><strong>Editar Tarea</strong></li>
					</ol>
				</div>
			</div>

			<div class="wrapper wrapper-content animated fadeInRightBig">
				<%
					Agenda t = (Agenda) request.getAttribute("agenda");
					SamFicha sfa = (SamFicha) request.getAttribute("sf");
					String s = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(t.getFechaComienzo());
				%>

				<div class="row">
					<div class="col-lg-12">
						<div class="ibox">
							<div class="ibox-title">
								<h5>Modificar Tarea</h5>
							</div>
						
							<div class="ibox-content">
								<div class="row">
									<div class="col-lg-6 g">
										<div class="form-group" id="areat">
											<label>Actividad</label> <input type="text"
												class="form-control" id="area" tabindex="3" name="area"
												value="<%=t.getTitulo()%>" disabled>
										</div>
										<div class="form-group" id="disciplinat">
											<label>Empresa</label> <input type="text"
												class="form-control" id="rs" tabindex="3"
												name="rs" value="<%=sfa.getFichRazonSocial() %>" disabled>
										</div>
										<div class="form-group" id="comentariost">
											<label>Descripcion</label>
											<textarea rows="5" class="form-control" tabindex="15"
												id="descripcion" style="resize:none" name="descripcion" disabled><%=t.getDescripcion()%></textarea>
										</div>
									</div>
									<div class="col-lg-6">
	
										<div class="form-group" id="lugart">
											<label>Fecha Comienzo Planificada</label> <input
												name="fechacomienzo" type="text" class="form-control"
												value="<%=s%>" disabled />
										</div>
	
										<div class="form-group" id="fallat">
											<label>Patentes</label> <input name="" type="text"
												class="form-control" value="<%=t.getPatentes()%>" disabled />
										</div>
										<div class="form-group" id="">
											<label>Direccion</label> <input type="text"
												class="form-control" id="" tabindex="3" name="correo"
												value="<%=t.getDireccion()%>" disabled>
										</div>
									</div>
								</div>
							</div>
							<div class="ibox-content">
								<div class="row">
									<div class="col-lg-12">							
										<form action="upload.html" class="dropzone" id="dropzoneForm" name="crearTareaForm" enctype="multipart/form-data">
											<input type="hidden" class="form-control" name="idInstalacion" id="idInstalacion" value="<%=request.getParameter("id_insta")%>"> 
											<input type="hidden" class="form-control" id="tipoFoto" name="tipoFoto" value="Inicial"> 
											<div class="dz-default dz-message">
												<span><strong>Presionar aqui para subir fotos previa la instalacion</strong></span>
											</div>
											<div class="dropzone-previews"></div>
										</form>
										
									</div>
								</div>
							</div>
							<form:form action="completar.html" name="validarForm" id="form_edit_id" commandName="validarForm" method="post">
							<div class="ibox-content">
								<div class="row">
									<div class="col-lg-6 col-md-offset-3">
										<h4>Listado perifericos anexo a validar</h4>
										<br>
									<% 
									List<SamFichaHardware> lista = (List) request.getAttribute("listHardware");
									for(SamFichaHardware sf : lista){
										if	(sf.getFhHarCodigo() == 15){ %>
											<div class="col-md-6 col-xs-6">
												<div class="alert alert-success">CAN</div>	
											</div>	
													
										<% }else if(sf.getFhHarCodigo() == 14){ %>
											
											<div class="col-md-6 col-xs-6">											
					                          <div class="alert alert-success"> Ibutton</div>	
					                          				                         
											</div>
												
										<% }else if(sf.getFhHarCodigo() == 13){ %>
											
											<div class="col-md-6 col-xs-6">
												<div class="alert alert-success"> Boton de Panico</div>
											</div>
													
										<% }else if(sf.getFhHarCodigo() == 26){ %>
											<div class="col-md-6 col-xs-6">
												<div class="alert alert-success">Cam Somnolencia</div>	
											</div>		
										<% }else if(sf.getFhHarCodigo() == 12){ %>								
											<div class="col-md-6 col-xs-6">
												<div class="alert alert-success">Corte de Motor</div>
											</div>	
												
										<% }else if(sf.getFhHarCodigo() == 10){%>
											<div class="col-md-6 col-xs-6">
												<div class="alert alert-success">Sensor Temp</div>	
											</div>	
													
									<% }else if(sf.getFhHarCodigo() == 11){%>
										<div class="col-md-6 col-xs-6">
											 <div class="alert alert-success"> Lector Barra</div>								
										</div>	
									<% }else if(sf.getFhHarCodigo() == 17){%>
										<div class="col-md-6 col-xs-6">
											 <div class="alert alert-success"> Sensor Puerta</div>								
										</div>	
											
									<%}
										} %>
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-lg-6 col-md-offset-3">								
										<div class="form-group" id="">
											<label>ID GPS</label> <input type="text" class="form-control"
												 tabindex="3" name="gps" disabled
												value="<%=request.getAttribute("id_gps")%>"> 
											<input type="hidden" id="textgps" value="<%=request.getAttribute("id_gps")%>"> 
										</div>
										
										<input type="hidden" value="<%=t.getFolioAnexo()%>" id="txtAnexo" name="anexo">
										<input type="hidden" value="<%=t.getEmpresa()%>" id="txtFolio" name=folio>
										<div class="col-md-6 col-md-offset-3">
											<% 
											Integer op = (Integer) request.getAttribute("op");
											if( op != 2){ %>
											<button class="btn btn-primary btn-lg btn-block" type="button"
												onClick="validarGPS()"
												id="guardar_usu" tabindex="9">
												<strong> Validar Gps</strong>
											</button>
											<% }else{
													if(request.getAttribute("ListPerifericos") != null){
														List<Periferico> perifericos = (List) request.getAttribute("ListPerifericos");	
														
														for(Periferico p : perifericos){ %>
															<input type="hidden" name="NamesListPerifericos" value="<%=p.getIdSamFichaHardware()%>">
																
														<%
														}
													}										
											%>
									
											<button class='btn btn-lg btn-block btn-primary m-t-n-xs' type='button' onclick='btn_continuar()'>
												<strong> Continuar</strong>
											</button>	
											<% } %>
										</div>
										
									</div>
									<div class="col-lg-12 g">
										<br>
										<div class="form-group" id="validacion">
										</div>
										<input type="hidden" value="<%=request.getParameter("idGps")%>" name="idGps">
										<input type="hidden" value="<%=request.getParameter("id")%>" name="ot_id" name="ot_id">
										<input type="hidden" value="<%=request.getParameter("id_insta")%>" name="id_insta">
										<input type="hidden" value="<%=request.getParameter("lc")%>" name="lc">
										<input type="hidden" name="validacionoculta" id="validacionoculta">
									</div>
								</div>
							</div>
							</form:form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
	<%@include file="footerjs.jsp"%><%
		Instalacion instalacion = (Instalacion) request.getAttribute("instalacion");
		
	%>
	<script>
		function btn_continuar(){
			error=0;		
			ajax=objetoAjax();
	        ajax.open("GET", 'otajax.html?tipo=Inicial&accion=10&id_insta=<%=request.getParameter("id_insta")%>');
	        ajax.onreadystatechange=function() {
	        	if (ajax.readyState==4) {
	            	error=ajax.responseText;
	               		if(error == 1){           			
                	    	swal({
              	            	title: "Falta Informacion",
                	            text: "Debe Agregar al menos Una Foto Inicial."
                	        });		               			
	                	}else{
	                		document.getElementById("form_edit_id").submit();
	                	}		
	             }
	                	
	        }
	        ajax.send(null)
	    }
	         
		
		
	
	 	$(document).ready(function(){
	 		$('.perifericos-select2').select2();
	 		
			$("#perifericos-select2").change(function(){
				if($("#btnContinuar").length){
					$("#btnContinuar").remove();
				}
				
        	});
        	
	 	});
	 	
	 	
	 	var name;

	 	 Dropzone.options.dropzoneForm = {
			 		
		            paramName: "file", // The name that will be used to transfer the file
		            autoProcessQueue: true,
		            maxFilesize: 10, // MB            
		            uploadMultiple : false,  
		            addRemoveLinks : true,
		           
		            acceptedFiles : ".png,.jpg,.bmp,.jpeg",
		            
		            init: function() {
		            	var self = this;  
		            	self.options.dictRemoveFile = "Eliminar";
		            	this.on("success", function(file, responseText) {
			                 // or however you would point to your assigned file ID here;
				           		if(responseText != undefined){			           		
				           			file.previewElement.querySelector('[data-dz-name]').innerHTML = responseText;
				           		   	file.name = responseText;

				                    // Set the returned filename to the record if we are deleting it before postback
				                    file.previewElement.id = responseText;
					                //self.emit("thumbnail", exist, exist.fullPath);
				           			//$(file.previewTemplate).find('.dz-filename span ').attr('data-dz-name',responseText);
				           			//$(file.previewTemplate).find('.dz-filename span ').text(responseText);
				           			
				           		}
			            	});
		            	self.on("sending", function(file,xhr, formData) {
		            		formData.append("filesize", file.size);
		            		console.log(file);
	           			});
		            	
		            	
		            	this.on("removedfile", function(file) {
		            		  var name = file.name;  
			            	  $.ajax({
				 		           type: 'GET',
				 		           url: 'otajax.html',
				 		           data: {accion: 9,id_insta: <%=request.getParameter("id_insta")%>,tipo:'Inicial',file :  file.previewElement.querySelector('[data-dz-name]').innerHTML},
				 		           
				 		      });   	       	  
			            	  file.previewElement.remove(); 
			            }); 
		            	 
		           		
		           		
		            	
		            	<%
		            	 if (instalacion.getFotos() != null) {
		 					List<Foto> fotos = instalacion.getFotos();
		 					for (Foto f : fotos) {
		 						if (f.getTipo().equals("Inicial")) {%>
		 	           				var existingFile = {name: '<%=f.getUrl()%>',accepted: true,fullPath: '<%=f.getUrl()%>'};
		 	           				console.log(existingFile);
		 							self.files.push(existingFile);
		 							console.log(self.emit);
		 							self.emit("addedfile", existingFile);
		 							self.emit("thumbnail", existingFile, existingFile.fullPath);
		 							self.emit("success", existingFile);
		 							self.emit("complete", existingFile);
		 						<%}	
		 					}
		 				
		 					 } %>         
		            },
		            previewsContainer : ".dropzone-previews"
		            
	            	
		            
		            
		};
	 	
	 	
	 	
		function objetoAjax() {

			var xhttp;

			if (window.XMLHttpRequest) {
				//El explorador implementa la interfaz de forma nativa
				xhttp = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				//El explorador permite crear objetos ActiveX
				try {
					xhttp = new ActiveXObject("MSXML2.XMLHTTP");
				} catch (e) {
					try {
						xhttp = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {

					}
				}
			}

			return xhttp;

		}
	</script>
</body>

</html>
