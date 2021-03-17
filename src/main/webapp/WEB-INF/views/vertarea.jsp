<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cl.samtech.ot.*"%>
<%@ page import="model.Agenda"%>

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

</head>

<body>
	<script type="text/javascript">
		  	
		
		function validar(){
	
						
			error=0;
			
		
			if(document.getElementById("crearTareaForm").prioridad.selectedIndex == 0){
				document.getElementById("prioridadt").className = "form-group has-error";
				error=1;				
			}else{
				document.getElementById("prioridadt").className = "form-group has-success";				
			}
			
			
			
			
			if(error==0){
				document.getElementById("crearTareaForm").submit();
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
						<li class="active"><strong>Ver Tarea</strong></li>
					</ol>
				</div>
			</div>

			<div class="wrapper wrapper-content animated fadeInRightBig">
			
			
			
			
            	<form:form action="editartarea.html" commandName="crearTareaForm" >            	
            	<%//Agenda t = (Agenda)request.getAttribute("tarea"); %>
            	<input type="hidden"  class="form-control" name="idTarea" value="<%//=t.getIdTarea() %>">
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox">
							<div class="ibox-title">
                            	<h5>Ver Tarea</h5>
                        	</div>                       	
                        	
                        	
                        	<div class="ibox-content">
                        	
                                   <div class="row">
									   <div class="col-lg-6 g">
											
											
											<div class="form-group" id="areat">
												<label>Area</label> 												
												<input type="text"  class="form-control" id="area"  tabindex="3" name="area" value="<%//=t.getUbicacion().getLugar().getArea().getDescripcion() %>" disabled>										
											</div>
											<div class="form-group" id="ubicaciont">
												<label>Ubicacion</label> 
												<input type="text"  class="form-control" id="ubicacion"  tabindex="3" name="ubicacion" value="<%//=t.getUbicacion().getDescripcion() %>" disabled>	
											</div>
											<div class="form-group" id="disciplinat">
												<label>Disciplina</label> 
												<input type="text"  class="form-control" id="disciplina"  tabindex="3" name="disciplina" value="<%//=t.getFalla().getDisciplina().getDescripcion()%>" disabled>
											</div>
											<div class="form-group" id="solicitantet">
											<label>Solicitante</label>												
											<input type="text"  class="form-control" id="solicitante"  tabindex="3" name="solicitante" value="<%//=t.getSolicitante() %>" disabled>
											</div>
											<div class="form-group" id="turnot">
											<label>Turno</label>												
											<input type="text"  class="form-control" id="turno"  tabindex="3" name="turno" value="<%//=t.getTurno().getDescripcion() %>" disabled>
											</div>
											<div class="form-group" id="correot">
											<label>Correo</label>												
											<input type="text"  class="form-control" id="correo" tabindex="3" name="correo"  value="<%//=t.getCorreo() %>" disabled>
											</div>
											<div class="form-group" id="comentariost">
											<label>Comentarios</label>												
											<textarea rows="5"  class="form-control" tabindex="15" id="descripcion" name="descripcion"  disabled><%//=t.getDescripcion() %></textarea>
										</div>
										
										</div>
										<div class="col-lg-6">
																					
											<div class="form-group" id="lugart">
												<label>Lugar</label> 
												<input name="lugar" type="text" class="form-control"  value="<%//=t.getUbicacion().getLugar().getDescripcion() %>" disabled/>
											</div>
											<div class="form-group" id="especialidadt">
												<label>Especialidad</label> 
												<input name="especialidad" type="text" class="form-control"  value="<%//=t.getFalla().getDisciplina().getEspecialidad().getDescripcion() %>" disabled/>
											</div>
											<div class="form-group" id="fallat">
												<label>Falla</label> 
												<input name="falla" type="text" class="form-control"  value="<%//=t.getFalla().getDescripcion() %>" disabled/>
											</div>											
                                  		  <div class="form-group" id="mediot">
											<label>Medio</label>												
												<input name="medio" type="text" class="form-control"  value="<%//=t.getMedio().getDescripcion() %>" disabled/>
											</div>
											<div class="form-group" id="telefonot">
											<label>Telefono</label>												
											<input type="text"  class="form-control" id="telefono"  tabindex="3" name="telefono" value="<%//=t.getTelefono() %>" disabled>
											</div>
											<div class="form-group">
											<label>Fecha Creacion</label>	
											<%//String fechahoy = new SimpleDateFormat("dd-MM-yyyy").format(t.getFechaCreacion()); %>											
											<input type="text"  class="form-control" id="fechaCreacion" value="<%//=fechahoy %>"  name="fechaCreacion" disabled>
											</div>
                                   			<div class="form-group" id="prioridadt">
											<label>Prioridad</label>	
											
											<input type="text"  class="form-control" id="prioridad" value="No Asignada"  name="prioridad" disabled>											
											
																													
											</div>
											<div class="form-group" >
												<label>Estado</label> 
												<input name="estado" type="text" class="form-control"  value="<%//=t.getEstado().getDescripcion() %>" disabled/>
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


    <script>
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
    </script>

   
</body>

</html>
