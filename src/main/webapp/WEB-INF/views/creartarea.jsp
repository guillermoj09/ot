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

    <link href="resources/css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="resources/css/plugins/dropzone/dropzone.css" rel="stylesheet">
    

    <link href="resources/css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/plugins/codemirror/codemirror.css" rel="stylesheet">

<link
	href="resources/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css"
	rel="stylesheet">
<link href="resources/css/plugins/select2/select2.min.css" rel="stylesheet">


 	<link href="resources/css/plugins/blueimp/css/blueimp-gallery.min.css" rel="stylesheet">

    <link href="resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">


</head>

<body>
<script src="resources/js/plugins/sweetalert/sweetalert.min.js"></script>
	<script type="text/javascript">
		  	
		
		function validar(){
	
						
			error=0;
			
			
			
			if(document.getElementById("crearTareaForm").area.selectedIndex == 0){
				document.getElementById("areat").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("areat").className = "form-group has-success";				
			}
			
			if(document.getElementById("crearTareaForm").lugar.selectedIndex == 0 || document.getElementById("crearTareaForm").lugar.value==""){
				document.getElementById("lugart").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("lugart").className = "form-group has-success";				
			}
			if(document.getElementById("crearTareaForm").ubicacion.selectedIndex == 0 || document.getElementById("crearTareaForm").ubicacion.value==""){
				document.getElementById("ubicaciont").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("ubicaciont").className = "form-group has-success";				
			}	
			
			if(document.getElementById("crearTareaForm").especialidad.selectedIndex == 0){
				document.getElementById("especialidadt").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("especialidadt").className = "form-group has-success";				
			}
			if(document.getElementById("crearTareaForm").disciplina.selectedIndex == 0 || document.getElementById("crearTareaForm").disciplina.value==""){
				document.getElementById("disciplinat").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("disciplinat").className = "form-group has-success";				
			}	
			if(document.getElementById("crearTareaForm").falla.selectedIndex == 0 || document.getElementById("crearTareaForm").falla.value==""){
				document.getElementById("fallat").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("fallat").className = "form-group has-success";				
			}
			if(document.getElementById("crearTareaForm").solicitante.value == ""){
				document.getElementById("solicitantet").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("solicitantet").className = "form-group has-success";				
			}
			if(document.getElementById("crearTareaForm").medio.selectedIndex == 0){
				document.getElementById("mediot").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("mediot").className = "form-group has-success";				
			}	
			if(document.getElementById("crearTareaForm").turno.selectedIndex == 0){
				document.getElementById("turnot").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("turnot").className = "form-group has-success";				
			}	
			
			if(error==0){
				document.getElementById("crearTareaForm").submit();
			}
			
			
		}

		 function objetoAjax(){
		 		
		 	var xhttp;
		 	
		 	if (window.XMLHttpRequest)
		 	{
		 		//El explorador implementa la interfaz de forma nativa
		 		xhttp = new XMLHttpRequest();
		 	} 
		 	else if (window.ActiveXObject)
		 	{
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

		 function callselect2(){	
			 

					
				 	document.getElementById("crearTareaForm").lugar.innerHTML = '';
				 	document.getElementById("crearTareaForm").ubicacion.innerHTML = '';
				 	document.getElementById("especialidad").selectedIndex= 0;
				 	document.getElementById("crearTareaForm").disciplina.innerHTML = '';
				 	document.getElementById("crearTareaForm").falla.innerHTML = '';
				 	
		
					
		 		 ajax=objetoAjax();
		         ajax.open("GET", 'otajax.html?accion=2&id='+document.getElementById("crearTareaForm").area.value);
		         ajax.onreadystatechange=function() {
		                 if (ajax.readyState==4) {
		 					document.getElementById("lugar").innerHTML = ajax.responseText;
		                 }//Fin Response
		         }
		         ajax.send(null)
			
		 		
		 }

		 function callselect3(){
		
			 document.getElementById("crearTareaForm").ubicacion.innerHTML = '';
			 	document.getElementById("especialidad").selectedIndex= 0;
			 	document.getElementById("crearTareaForm").disciplina.innerHTML = '';
			 	document.getElementById("crearTareaForm").falla.innerHTML = '';
		 		
		 		 ajax=objetoAjax();
		         ajax.open("GET", 'otajax.html?accion=3&id='+document.getElementById("crearTareaForm").lugar.value);
		         ajax.onreadystatechange=function() {
		                 if (ajax.readyState==4) {
		 					document.getElementById("ubicacion").innerHTML = ajax.responseText;
		                 }//Fin Response
		         }
		         ajax.send(null)
			
		 		
		 }

		 function callselect4(){
		 		 		
		 		
		
				 	document.getElementById("especialidad").selectedIndex= 0;
				 	document.getElementById("crearTareaForm").disciplina.innerHTML = '';
				 	document.getElementById("crearTareaForm").falla.innerHTML = '';
				 	
				
		 		
		 		
		 }
		 function callselect5(){
			 	
				 	
				 	document.getElementById("crearTareaForm").disciplina.innerHTML = '';
				 	document.getElementById("crearTareaForm").falla.innerHTML = '';
				 	
				 	
				 	if(document.getElementById("crearTareaForm").ubicacion.selectedIndex == 0 || document.getElementById("crearTareaForm").ubicacion.value==""){
				 		document.getElementById("especialidad").selectedIndex= 0;
				 		swal({
         	                title: "Falta Informacion",
         	                text: "Debe Seleccionar Area/Lugar/Ubicacion antes de seleccionar especialidad."
         	            });			
					}else{
						var selector = document.getElementById('ubicacion');
					     var valueSel = selector[selector.selectedIndex].value;		
		  		 		 ajax=objetoAjax();  		 		 
				         ajax.open("GET", 'otajax.html?accion=5&idu='+valueSel+'&id='+document.getElementById("crearTareaForm").especialidad.value);
				         ajax.onreadystatechange=function() {
				                 if (ajax.readyState==4) {
				 					document.getElementById("disciplina").innerHTML = ajax.responseText;
				                 }//Fin Response
				         }
				         ajax.send(null)
						
					}	
				 	
				
		 		
			 	 
		 		
			
		 }

		 function callselect6(){
							 	
				 	
				 	document.getElementById("crearTareaForm").falla.innerHTML = '';
				 	
			
		 		
		 		ajax=objetoAjax();
		         ajax.open("GET", 'otajax.html?accion=6&id='+document.getElementById("crearTareaForm").disciplina.value);
		         ajax.onreadystatechange=function() {
		                 if (ajax.readyState==4) {
		 					document.getElementById("falla").innerHTML = ajax.responseText;
		                 }//Fin Response
		         }
		         ajax.send(null)
				
		 		
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
			
			
			
			
            	<form:form action="creartarea.html" commandName="crearTareaForm" >
				<div class="row">
				
				<div class="col-lg-6">
				<div class="ibox-content">
				<div class="form-group" id="areat">
												<label>Area</label> 												
												<select class="select2_fallat form-control" id="area" tabindex="6" name="area" onchange="callselect2();">
												<option value='0'>Seleccione</option>	
												<%
														if (request.getAttribute("areas") != null
																&& !(request.getAttribute("areas")).equals("")) {
															List<AreaActiva> areas = (List) request.getAttribute("areas");
															for (AreaActiva a : areas) {			
													%>										
														<option value="<%=a.getIdArea() %>"><%=a.getDescripcion() %></option>
													<%}} %>												
																																					
												</select>												
											</div>
											<div class="form-group" id="lugart">
												<label>Lugar</label> 
												<select class="select2_fallat form-control" id="lugar" tabindex="6" name="lugar" onchange="callselect3();">
												</select>
											</div>
											<div class="form-group" id="ubicaciont">
												<label>Ubicacion</label> 
												<select class="select2_fallat form-control" id="ubicacion" tabindex="6" name="ubicacion" onchange="callselect4();">													
																																				
												</select>	
											</div>
											
											
				
				
				
				</div>
				
				</div>
				
				
				<div class="col-lg-6">
				<div class="ibox-content">
				
											<div class="form-group" id="especialidadt">
												<label>Especialidad (Debe Seleccionar Area-Lugar-Ubicacion antes de continuar)</label>
												<select class="select2_fallat form-control" id="especialidad" tabindex="6" name="especialidad" onchange="callselect5();">		
												<option value='0'>Seleccione </option>												
														<%
													if (request.getAttribute("especialidades") != null
															&& !(request.getAttribute("especialidades")).equals("")) {
														List<EspecialidadActiva> especialidades = (List) request.getAttribute("especialidades");
														for (EspecialidadActiva e : especialidades) {		
												%>
												<option value="<%=e.getIdEspecialidad() %>"><%=e.getDescripcion() %></option>
												<%}} %>																		
												</select>
											</div>
											<div class="form-group" id="disciplinat">
												<label>Disciplina</label> 
												<select class="select2_fallat  form-control" id="disciplina" tabindex="6" name="disciplina" onchange="callselect6();">																																		
												</select>	
											</div>
											<div class="form-group" id="fallat">
												<label>Falla</label> 
												<select class="select2_fallat form-control" id="falla" tabindex="6" name="falla">													
																																					
												</select>
											</div>	
				
				
				
				</div>
				
				</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox">
							                     	
                        	
                        	
                        	<div class="ibox-content">
                        	
                                   <div class="row">
									   <div class="col-lg-6 g">
											
											
											
											<div class="form-group" id="solicitantet">
											<label>Solicitante</label>												
											<input type="text"  class="form-control" id="solicitante" onKeyPress="" tabindex="3" name="solicitante">
											</div>
											<div class="form-group" id="turnot">
											<label>Turno</label>												
											<select class="select2_turno form-control" id="turno" tabindex="6" name="turno" >		
												<option value='0'>Seleccione</option>												
														<%
													if (request.getAttribute("turnosactivos") != null
															&& !(request.getAttribute("turnosactivos")).equals("")) {
														List<TurnoActivo> especialidades = (List) request.getAttribute("turnosactivos");
														for (TurnoActivo e : especialidades) {		
												%>
												<option value="<%=e.getIdTurno() %>"><%=e.getDescripcion() %></option>
												<%}} %>																		
												</select>
											</div>
											<div class="form-group" id="correot">
											<label>Correo</label>												
											<input type="text"  class="form-control" id="correo" onKeyPress="" tabindex="3" name="correo">
											</div>
											<div class="form-group" id="comentariost">
											<label>Comentarios</label>												
											<textarea rows="5" placeholder="Ingrese aqui comentarios" class="form-control" tabindex="15" id="descripcion" name="descripcion"></textarea>
										</div>
										<div>
													<button class="btn btn-sm btn-default m-t-n-xs" type="button" onClick="window.history.go(-1)" tabindex="7"><strong><span class="fa fa-caret-left"></span> Volver</strong></button>
													<button class="btn btn-sm btn-default m-t-n-xs" type="button" onClick="limpiar()" tabindex="8"><strong><span class="fa fa-eraser"></span> Limpiar Campos</strong></button>
													<button class="btn btn-sm btn-primary m-t-n-xs" type="button" onClick="validar()" id="guardar_usu" tabindex="9"><strong><span class="fa fa-check"></span> Guardar</strong></button>
												</div>
										</div>
										<div class="col-lg-6">
																					
																					
                                  		  <div class="form-group" id="mediot">
											<label>Medio</label>												
											<select class="form-control" id="medio" tabindex="6" name="medio" >		
												<option value='0'>Seleccione</option>												
														<%
													if (request.getAttribute("mediosactivos") != null
															&& !(request.getAttribute("mediosactivos")).equals("")) {
														List<MedioActivo> mediosactivos = (List) request.getAttribute("mediosactivos");
														for (MedioActivo ma : mediosactivos) {		
												%>
												<option value="<%=ma.getIdMedio() %>"><%=ma.getDescripcion() %></option>
												<%}} %>																		
												</select>
											</div>
											<div class="form-group" id="telefonot">
											<label>Telefono</label>												
											<input type="text"  class="form-control" id="telefono" onKeyPress="" tabindex="3" name="telefono">
											</div>
											<div class="form-group">
											<label>Fecha</label>	
											<%String fechahoy = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()); %>											
											<input type="text"  class="form-control" id="fechaCreacion" value="<%=fechahoy %>"  name="fechaCreacion" disabled>
											</div>
                                   			<div class="form-group" >
												<label>Estado</label> 
												<input name="estado" type="text" class="form-control" value="No Iniciada" disabled/>
											</div>	
                                    </div>                                    
                                
                        	</div>
						</div>
					</div>
				</div>
           
                  
                  
                  
                      </form:form>       
          
                          
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

	
	<!-- Custom and plugin javascript -->
	<script src="resources/js/inspinia.js"></script>
	<script src="resources/js/plugins/pace/pace.min.js"></script>

    <!-- Jasny -->
    <script src="resources/js/plugins/jasny/jasny-bootstrap.min.js"></script>

    <!-- DROPZONE -->
    <script src="resources/js/plugins/dropzone/dropzone.js"></script>

    <!-- CodeMirror -->
    <script src="resources/js/plugins/codemirror/codemirror.js"></script>
    <script src="resources/js/plugins/codemirror/mode/xml/xml.js"></script>
<!-- Select2 -->
    <script src="resources/js/plugins/select2/select2.full.min.js"></script>



 <script src="resources/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>


    <script>
       
		function fotoInicial(){
			
			window.location.href = "fotoinicial.html?id=";
		}
		

	
	 
	 function objetoAjax(){
	 		
		 	var xhttp;
		 	
		 	if (window.XMLHttpRequest)
		 	{
		 		xhttp = new XMLHttpRequest();
		 	} 
		 	else if (window.ActiveXObject)
		 	{
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
		


        Dropzone.options.dropzoneForm = {
            paramName: "file", // The name that will be used to transfer the file
            maxFilesize: 2, // MB
            dictDefaultMessage: "<strong>Drop files here or click to upload. </strong></br> (This is just a demo dropzone. Selected files are not actually uploaded.)"
        };

        $(document).ready(function(){

            var editor_one = CodeMirror.fromTextArea(document.getElementById("code1"), {
                lineNumbers: true,
                matchBrackets: true
            });

            var editor_two = CodeMirror.fromTextArea(document.getElementById("code2"), {
                lineNumbers: true,
                matchBrackets: true
            });

            var editor_two = CodeMirror.fromTextArea(document.getElementById("code3"), {
                lineNumbers: true,
                matchBrackets: true
            });

       });
        
        
        $(".select2_fallat").select2();
        $(".select2_turno").select2();
        
        
        
        
    </script>

   
</body>

</html>
