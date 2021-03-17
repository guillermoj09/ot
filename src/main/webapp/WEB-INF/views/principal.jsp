<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cl.samtech.ot.*"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SAMTECH | Tareas SAMTECH</title>
<link rel="shortcut icon" href="resources/img/favicon.ico" />
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">
    <link href="resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/plugins/dataTables/datatables.min.css"
	rel="stylesheet">
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
	                    <span class="m-r-sm text-muted welcome-message">Bienvenido a Samtech Tareas.</span>
	                </li>                          
	                <li><a href="logout.html"> <i class="fa fa-sign-out"></i>Salir
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
           
            
            <div class="wrapper wrapper-content animated fadeInRightBig">
					<div class="row">
						<div class="col-lg-12">
							<div class="ibox">
								<div class="ibox-title">
									<h5>Tareas</h5>
								</div>				
								<div class="ibox-content">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover dataTables-example">
											<thead>
												<tr>
													
													<th align="center">Actividad</th>	
													<th align="center">Estado</th>																										
													<th align="center">Fecha Comienzo</th>											
													<th align="center">Empresa</th>
													<th align="center">Contacto</th>													
													<th align="center">Tipo Asignacion</th>
													<th align="center">Patentes</th>
													<th align="center">Direccion</th>
													<th align="center">Descripcion</th>
													<th align="center">Finalizar Tarea</th>
	
												</tr>
											</thead>
											<tbody>
											<%
									if (request.getAttribute("tareasactuales") != null
											|| !(request.getAttribute("tareasactuales")).equals("")) {
										List<AgendaActiva> tareas = (List) request.getAttribute("tareasactuales");	
										for (AgendaActiva t : tareas) {	
											
											String fechaCreacion="";
											if(t.getFechaComienzo()==null){
												
												 fechaCreacion = "" ; 
											}else{
												 Calendar calendar = Calendar.getInstance();
											     calendar.setTimeInMillis(t.getFechaComienzo().getTime());
												
											     Date DD = new Date();
											     DD.setTime(t.getFechaComienzo().getTime());
											     
												 fechaCreacion = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(DD) ; 
											     //fechaCreacion=DD.toString();
											}
											
											String fechaInicio ="";
											String prioridad ="";
											%>
				
											<!--   <tr onClick="location.href='editartarea.html?id=&lc=">-->
											<tr id="rowrow"  <% if( t.getEstado() == 0 && t.getInstalaciones() == 0) { %> onclick="accion(<%=t.getId()%>,'<%=t.getLogin_cliente()%>','<%=t.getTitulo() %>')" <% } %> style="cursor: pointer;" data-target='#myModal'>
												<td align="center"><%=t.getTitulo() %></td>	
												<td align="center">
													 <% if( t.getEstado() == 0) { %>
														<span class="label label-primary">Pendiente</span>
													<%}else{ %>
														<span class="label label-danger">Terminada</span>
													<%}%>
												</td>																									
												<td align="center"><%=fechaCreacion%></td>	
												<td align="center"><%=t.getEmpresa()%></td>
												<td align="center"><%=t.getContacto() %></td>													
												<td align="center"><%=t.getResponsable() %></td>
												<td align="center"><%=t.getPatentes() %></td>
												<td align="center"><%=t.getDireccion() %></td>
												<td align="center"><%=t.getDescripcion() %></td>
											
												<% if(t.getCountInst() > 0 && t.getEstado() == 0){ %>
												<td align="center"><button id="btnbtnfin" class=" btn btn-primary" idot="<%=t.getId()%>" cliente="<%=t.getLogin_cliente()%>"  >Finalizar</button></td>		
												<!-- <a href="finalizartarea.html?id=<%//=t.getId()%>" >Finalizar</a> -->
												<% }else{ %>
												<td align="center"></td>
												<% }%>
											</tr>
											<%  } } %>
											</tbody>
										</table>
									</div>
								</div>
				

							</div>
						</div>
					</div>
				
				</div>
            <div class="footer">                
                <div>
                 <strong>Copyright</strong> SAMTECH &copy; 2019
                </div>
            </div>
            
            <div class="modal inmodal in" id="myModal" role="dialog" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content animated bounceInRight">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<i class="fa fa-list-alt modal-icon"></i>
							<h4 class="modal-title"> Ingrese ID GPS</h4>
						</div>
						<div class="modal-body">
							<form method="post" id="formulario">
								<div class="form-group" id="inputshidden">			
															
								</div>
								<div class="form-group" >			
									<input type="text"  class="form-control" name="id_gps" id="id_gps" >									
								</div>
								<div class="form-group">			
									<input  type="button" class="btn btn-primary btn-block m-t-n-xs"  accesskey="1" value="continuar"  id="botonenviar">
								</div>
							</form>
							<div id="respuesta">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-white" data-dismiss="modal">Cerrar</button>
						</div>
					</div>
				</div>
			</div>

        </div>
       	<script src="resources/js/jquery-3.1.1.min.js"></script>    
       
		 	 <core:if test="${mensaje!=null }">
     			<script>   
            	 $(document).ready(function(){
            		  swal({
                          title: "Buen Trabajo!",
                          text: "Equipo se ingresó correctamente!",
                          type: "success"
                      });
            	 });
            	</script>
   			</core:if>
   	 <core:if test="${msj!=null }">
     			<script>   
     			
            	 $(document).ready(function(){
            		  swal({
                          title: "Buen Trabajo!",
                          text: "Se genero reporte correctamente!",
                          type: "success"
                      });
            	 });
            	</script>
   	</core:if>
   	<core:if test="${error!=null }">
     			<script>   
     			
            	 $(document).ready(function(){
            		  swal({
                          title: "Se produjo un error!",
                          text: 	"Se produjo error, por favor contactar soporte!",
                          type: "error"
                      });
            	 });
            	</script>
   	</core:if>
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
    	

    <script>

        $(document).ready(function(){
        	
        
        	
        	$("#id_gps").attr('maxlength','6');
        	
	        $('#ibox1').children('.ibox-content').toggleClass('sk-loading');
	        $('#ibox2').children('.ibox-content').toggleClass('sk-loading');
        
	        
	        $("input").keypress(function(e){
	        	var m = String.fromCharCode(e.which);
	        	var expreg = new RegExp("^[a-zA-Z0-9_]*$");
		    	  
		    	if(!expreg.test(m)){
		    	    return false;
		    	}
	          });
	
        });
            
	    function accion(IdTarea, ClienteEmpresa,tipo){
	    	
	    	console.log(tipo);
	        var datosHidden = "";
	        console.log(IdTarea);
	        console.log(ClienteEmpresa);
	        
	        switch (tipo) {
		    	case 'INSTALACION':
		        	$("#id_gps").val("");
		            $("#respuesta").html("");        	   
		          	console.log('inst.');
			      	datosHidden = "<input type='hidden' value='"+IdTarea+"' id='id_tarea'> <input type='hidden' value='"+ClienteEmpresa+"' id='cliente'> ";
			      	console.log(datosHidden);
			      	$("#myModal .modal-body #formulario #inputshidden").html(datosHidden);	
			      	$("#myModal modal-body").html(datosHidden);	
			      	$("#myModal").modal("show");
			      //location.href = "prueba.html";
		          break;
		        case 'RETIRO':
		        	
		        	console.log('RETIRO');
		        	location.href = "retiro.html";
		        	break;
		        case 'UPGRADE':
		          console.log('upd');
		          break;
		        case 'REVISION':
		          console.log('Revision');
		          break;
		        default:
		          console.log('Lo lamentamos, por el momento no disponemos de ' + expr + '.');
	     	}
	    }
        
       $("#rowrow #btnbtnfin").click(function(e){
	   		//e.stopPropagation();
		   	var idot = "";
		   	var cliente = "";
		   	idot = $(this).attr("idot");
		   	cliente = $(this).attr("cliente");
		   	location.href = "finalizartarea.html?lc="+cliente+"&id="+idot;
		   	return false;
       });
       
       $("#botonenviar").click( function() {

       	var vcliente = document.getElementById("cliente").value;
       	var vidTarea = document.getElementById("id_tarea").value;
       	var vidGps = document.getElementById("id_gps").value;
       	
       	if(vidGps){
       		$.ajax({
       			type : 'POST',
       			url : 'ingresogps.html',
       			data : {
       				lc : vcliente,
       				idTarea : vidTarea,
       				id_gps : vidGps
       			},
       			success : function(respuesta) {
       				
       				
       				var division = respuesta.split(":");
       				if(division[0] == "1"){
       					var id_ins = division[1];
       					location.href ="editartarea.html?op=1&id="+vidTarea+"&lc="+vcliente+"&id_insta="+id_ins+"&idGps="+vidGps;
       				}else if(division[0] == "3"){
       					$("#respuesta").html("<label id='-error' class='error' for=''>ID GPS no disponible, asignada a cliente</label>");
       					
       				}else if(division[0] == "0"){
       					$("#respuesta").html("<label id='-error' class='error' for=''>GPS no existe</label>");
       				}else if(division[0] == "4"){
       					location.href ="editartarea.html?id="+vidTarea+"&lc="+vcliente;   				
       				}else{
       					//alert("ada");
       				}
       			}
       		})
       	}
      
       
      });
         
    $('#example').DataTable( {
        "order": [[ 1, "desc" ]]
    });
    
		$(document).ready(function(){
            $('.dataTables-example').DataTable({
                pageLength: 25,
                "order": [[ 1, "desc" ]],
                responsive: true,
                dom: '<"html5buttons"B>lTfgitp',
                buttons: [
                    {extend: 'copy'},
                    {extend: 'csv'},
                    {extend: 'excel', title: 'Tareas de tecnico <%=usuario.getUsername()%>'},
                    {extend: 'pdf', title: 'Tareas de tecnico <%=usuario.getUsername()%>'},

                    {extend: 'print',
                     customize: function (win){
                         $(win.document.body).addClass('white-bg');
                         $(win.document.body).css('font-size', '10px');
                         $(win.document.body).find('table').addClass('compact')
                         .css('font-size', 'inherit');
	                  }
                    }
                ]

            });

        });
		
		

    </script>


</body>

</html>
