<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cl.samtech.ot.*"%>
<%@ page import="model.Foto"%>
<%@ page import="model.Ot"%>
<%@ page import="model.Instalacion"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>SAMTECH | Tareas</title>
<link rel="shortcut icon" href="resources/img/favicon.ico" />


    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="resources/css/plugins/dropzone/dropzone.css" rel="stylesheet">
    <link href="resources/css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/plugins/codemirror/codemirror.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">



</head>

<body>
	
	<div id="wrapper">

		<%@include file="menu.jsp"%>
<script type="text/javascript">
		  	
		
		function fotoInicial(){
			
			window.location.href = "fotoinicial.html?id=6";
		}
		
		function validar(){
	
						
			error=0;
			
			
			
			if(document.getElementById("estado").selectedIndex == 0){
				document.getElementById("estadot").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("estadot").className = "form-group has-success";				
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
						<li class="active"><strong>Editar Tarea</strong></li>
					</ol>
				</div>
			</div>

			<div class="wrapper wrapper-content animated fadeInRightBig">
            	
            	
				<div class="row">  	
					<div class="col-lg-12">
						<div class="ibox">
							<div class="ibox-title">
                            	<h5>Fotos Finales</h5>
                        	</div>         
                        	
                        
		                        	<div class="ibox-content">
			                                <div class="row">
		                        			<div class="col-lg-12">
						                    <div class="ibox">
						                        <div class="ibox-content">
						                            <form action="upload.html" class="dropzone" id="dropzoneForm" name="CrearTareaForm" enctype="multipart/form-data" >
						                               <input type="hidden"  class="form-control" name="idInstalacion" value="<%=request.getParameter("id_insta") %>">
						                               <input type="hidden"  class="form-control" name="tipoFoto" value="Final">	
						                                <div class="dz-default dz-message file-dropzone text-center well col-sm-12">
                                                 <span class="glyphicon glyphicon-paperclip"></span>
                                                  <span><strong>Arrastre Archivo o haga click para Subir Archivo. </strong></span>
                                               
                                         </div>
						                                <div class="dropzone-previews" ></div>
						                            </form>
									                        <br>    
			                                          
			                                  <button class="btn btn-sm btn-default m-t-n-xs" type="button" onClick="volveret()" tabindex="7"><strong><span class="fa fa-caret-left"></span> Volver</strong></button>
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
<%Instalacion instalacion = (Instalacion)request.getAttribute("instalacion"); %>

    <script>
        Dropzone.options.dropzoneForm = {
            paramName: "file", // The name that will be used to transfer the file
            autoProcessQueue: true,
            maxFilesize: 10, // MB            
            uploadMultiple : false,  
            addRemoveLinks : true,
            removedfile: function(file) {
            	  var name = file.name;  
            	 ajax=objetoAjax();
 		         ajax.open("GET", 'otajax.html?accion=9&id_insta=<%=request.getParameter("id_insta")%>&tipo=Final&file='+name);
 		         ajax.send(null);            	  
            	  file.previewElement.remove(); 
            	  exit;},
            init: function() {
            	
            	var self = this;  
           	 <%  if(instalacion.getFotos()!=null){
           		 List<Foto> fotos= instalacion.getFotos();
           			for (Foto f : fotos) {
           				if(f.getTipo().equals("Final") ){
           	 %>
           	var existingFile = {name: '<%=f.getUrl() %>',accepted: true,fullPath: '<%=f.getUrl() %>'};   
           	
       	    self.files.push(existingFile);
               self.emit("addedfile",existingFile);
               self.emit("thumbnail", existingFile, existingFile.fullPath);
               self.emit("success",existingFile);    
               self.emit("complete",existingFile);
               <%} }%>fileInfo.remove(); <%}%>              
            },
            previewsContainer : ".dropzone-previews"
            
        };

        
   
   
        
        
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
		
	
	function volveret(){
			
		window.location.href = "completar.html?ot_id=<%=request.getParameter("id_ot") %>&id=<%=request.getParameter("id") %>&lc=<%=request.getParameter("lc")%>";
		}
		 
    </script>

   
</body>

</html>
