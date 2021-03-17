<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cl.samtech.ot.*"%>
<%@ page import="model.TipoVehiculo"%>
<%@ page import="model.Device"%>
<%@ page import="model.Cliente"%>
<%@ page import="model.Device_Tipogp"%>
<%@ page import="model.Ot"%>
<%@ page import="model.Foto"%>
<%@ page import="model.Instalacion"%>
<%@ page import="model.Faenas"%>
<%@ page import="model.Compania"%>
<%@ page import="model.SamFichaHardware"%>
<%@ page import="model.Region"%>

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
<link href="resources/css/plugins/dropzone/basic.css" rel="stylesheet">
<link href="resources/css/plugins/dropzone/dropzone.css"
	rel="stylesheet">
<link href="resources/css/plugins/codemirror/codemirror.css"
	rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<link href="resources/css/plugins/blueimp/css/blueimp-gallery.min.css"
	rel="stylesheet">
<link href="resources/css/plugins/sweetalert/sweetalert.css"
	rel="stylesheet">



</head>
<!-- Custom Css -->

<style>
#btnSaveSign {
	color: #fff;
	background: #f99a0b;
	padding: 5px;
	border: none;
	border-radius: 5px;
	font-size: 20px;
	margin-top: 10px;
}

#signArea {
	width: 450px;
	margin: 0px auto;
}

.sign-container {
	width: 100%;
	margin: auto;
}

.sign-preview {
	width: 150px;
	height: 50px;
	border: solid 1px #CFCFCF;
	margin: 10px 5px;
}

.tag-ingo {
	font-family: cursive;
	font-size: 12px;
	text-align: left;
	font-style: oblique;
}

.center-text {
	text-align: center;
}
</style>



<body>
	<script src="resources/js/plugins/sweetalert/sweetalert.min.js"></script>

	<div id="wrapper">

		<%@include file="menu.jsp"%>
		<script type="text/javascript">
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

		function validarGPS(){	
		
			ajax=objetoAjax();
	        ajax.open("GET", 'otajax.html?accion=1&id='+document.getElementById("crearTareaForm").gps.value);
	        ajax.onreadystatechange=function() {
	                if (ajax.readyState==4) {
						document.getElementById("validacion").innerHTML = ajax.responseText;
						 				
	                }//Fin Response
	        }
	        ajax.send(null)		
				
		}
		
	
		
		function enviarfoto1() {

			document.getElementById("dropzoneForm").submit();
		}
		</script>
		<%
			Device d = (Device) request.getAttribute("d");
		%>

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
						<li class="active"><strong>Completar Instalacion GPS</strong></li>
					</ol>
				</div>
			</div>

			<div class="wrapper wrapper-content animated fadeInRightBig">
				<c:if test="${not empty mensaje}">
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<div class="alert alert-danger">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<a href="#" class="alert-link">${mensaje}</a>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<%
					String login_cliente = request.getParameter("lc");
					String id = (String) request.getAttribute("id");
					String ot_id = (String) request.getAttribute("ot_id");
					long id_instalacion = (Long) request.getAttribute("id_insta");
				%>
				<div class="ibox-title">
					<h5>Modificar Tarea</h5>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox">
							<form action="upload.html" class="dropzone" id="dropzoneForm"
								name="crearTareaForm" enctype="multipart/form-data">
								<input type="hidden" class="form-control" name="idInstalacion"
									id="idInstalacion" value="<%=id_instalacion%>"> <input
									type="hidden" class="form-control" name="tipoFoto"
									value="Final">
								<div class="dz-default dz-message">
									<span><strong>Presionar aqui para subir fotos posterior a instalacion</strong></span>
								</div>
								<div class="dropzone-previews"></div>
							</form>
						</div>
					</div>
				</div>

				<form:form action="save.html" method="post" commandName="deviceForm" id="form_id">
					<div class="row">
						<div class="col-lg-12">
							<div class="ibox">

								<div class="ibox-content">
									<div class="row">
										<div class="col-lg-6 g">
											<div class="form-group">
												<label>GPS</label> <input type="text" class="form-control"
													name="id_device" value="<%=id%>" disabled> <input
													type="hidden" class="form-control" name="id_device"
													value="<%=id.toUpperCase()%>"> <input type="hidden"
													class="form-control" name="ot_id" value="<%=ot_id%>">
												<input type="hidden" class="form-control"
													name="id_instalacion" value="<%=id_instalacion%>">
												<input type="hidden" class="form-control"
													name="cliente_login" value="<%=login_cliente%>">


											</div>
											<div class="form-group">

												<label>Tipo de Vehiculo</label>
												 <select tabindex="0" class="form-control" name="idTipoVehiculo">

													<%
														if (request.getAttribute("ltv") != null && !(request.getAttribute("ltv")).equals("")) {
																List<TipoVehiculo> especialidades = (List) request.getAttribute("ltv");
																for (TipoVehiculo e : especialidades) {

																	if (d.getIdTipoVehiculo() == e.getId()) {
													%>
													<option value="<%=e.getId()%>" selected><%=e.getDescripcion()%></option>
													<%
														} else {
													%>
													<option value="<%=e.getId()%>"><%=e.getDescripcion()%></option>
													<%
														}
																}
															}
													%>

												</select>
											</div>
											<div class="form-group" id="patenter">
												<label>Patente</label> <input type="text"
													class="form-control" id="patente" name="patente" tabindex="1"
													value="<%=d.getPatente()%>">
													<div id="msjpatente"></div>
											</div>
											<div class="form-group">
												<label>VIN Vehiculo</label>
												 <input type="text" tabindex="2"
													class="form-control" name="vin"
														value="<%if (d.getVin() == null) {
														out.println("");
													} else {
														out.print(d.getVin());
													}%>">
											</div>
											<div class="form-group">
												<label>Año Vehiculo</label> <input type="text" tabindex="3"
													class="form-control" id="anio_vehiculo" name="anio_vehiculo"
													value="<%=d.getAnio_vehiculo()%>">
											</div>
											<div class="form-group">
												<label>Voltaje Vehiculo</label> <input type="text" tabindex="4"
													class="form-control" id="voltaje" name="volTolva"
													value="<%=d.getVolTolva()%>">
											</div>
											<div class="form-group">
												<label>Compania SIM</label> <select class="form-control"
													id=compania_sim name="compania_sim" tabindex="5">

													<%
															if (request.getAttribute("companias") != null && !(request.getAttribute("companias")).equals("")) {
																List<Compania> companias = (List) request.getAttribute("companias");
																for (Compania c : companias) {
																	if (c.getCodigo().equals(d.getBrand())) {
																	%>
																		<option value="<%=c.getCodigo()%>" selected><%=c.getDescripcion()%></option>
																	<%
																	} else {
																	%>
																	<option value="<%=c.getCodigo()%>"><%=c.getDescripcion()%></option>
																	<%
																	}
																}
															}
													%>
												</select>
											</div>
											<div class="form-group">
												<label>Estado GPS</label> <select
													class="select2_fallat form-control" id="protocolo"
													tabindex="6" name="estado_gps">
													<option value="GPS en Pruebas">GPS en Pruebas</option>
													<option value="Operativo por Asignar">Operativo
														por Asignar</option>
													<option value="Operativo en Cliente">Operativo en
														Cliente</option>

												</select>
											</div>
											<div class="form-group">
												<label>Odometro</label> <input type="text"
													class="form-control" tabindex="7" id="odo" name="kilometraje"
													value="<%=d.getKilometraje()%>">
											</div>
											<div class="form-group">
												<label>Tipo de GPS</label> <select class=" form-control"
													id="tipo_gps" tabindex="8" name="tipo_gps">
													<%
														if (request.getAttribute("ltg") != null && !(request.getAttribute("ltg")).equals("")) {
																List<Device_Tipogp> especialidades = (List) request.getAttribute("ltg");
																for (Device_Tipogp e : especialidades) {
													%>
													<%
														if (e.getTipoGps().equals(d.getTipoGps())) {
													%>
													<option value="<%=e.getTipoGps()%>" selected>
														<%=e.getMarca()%>
														<%=e.getModelo()%></option>
													<%
														} else {
													%>

													<option value="<%=e.getTipoGps()%>">
														<%=e.getTipoGps()%>
														<%=e.getModelo()%></option>
													<%
														}
																}
															}
													%>
												</select>
											</div>

										</div>
										<div class="col-lg-6">
											<div class="form-group" id="marcar">
												<label>Marca Vehiculo</label> <input id="marcaCamion" name="marcaCamion"
													required type="text" tabindex="9" class="form-control"
													value="<%if (d.getMarcaCamion() == null) {
														out.println("");
													} else {
														out.print(d.getMarcaCamion());
													}%>" />
													<div id="msjmarca"></div>
											</div>
											<%
												if (request.getAttribute("insta") != null || !(request.getAttribute("insta")).equals("")) {
														Instalacion instalacion = (Instalacion) request.getAttribute("insta");
											%>
											<div class="form-group" id="modelor">
												<label>Modelo Vehiculo</label> <input type="text" tabindex="10" required class="form-control"
													value="<%if (d.getModelo() == null) {
															out.println("");
														} else {
															out.print(d.getModelo());
														}%>"
													name="modelo" id="modelo">
													<div id="msjmodelo"></div>
											</div>
											<div class="form-group">
												<label>Color Vehiculo</label>
												 <select tabindex="11" class="form-control"
													name="color_vehiculo">
													<%
														if (request.getAttribute("colores") != null && !(request.getAttribute("colores")).equals("")) {
															List<String> colores = (List) request.getAttribute("colores");
															for (String c : colores) {
													%>
													<option value="<%=c%>"><%=c%></option>
													<%
														}
																}
													%>

												</select>
											</div>
											<div class="form-group">
												<label>Numero Interno Vehiculo</label> <input type="text"
													class="form-control" name="numero_interno" tabindex="12"
													value="<%if (d.getNum_interno() == null) {
														out.println("");
													} else {
														out.println(d.getNum_interno());
													}%>">
											</div>
											<div class="form-group">
												<label>Tipo de Conexion VPN</label> <select
													class="select2_fallat form-control" id="con_VPN"
													tabindex="13" name="con_VPN">
													<option value="">Seleccione Tipo</option>
													<%
														if (d.getCon_VPN().equals("1")) {
													%>
													<option value="1" selected>VPN</option>
													<option value="0">Sin VPN</option>

													<%
														} else {
													%>
													<option value="0" selected>Sin VPN</option>
													<option value="1">VPN</option>
													<%
														}
													%>

												</select>

											</div>
											<div class="form-group" id="tipo_conx_protocolot">
												<label>Tipo de Conexion PROTOCOLO</label> <select
													class="select2_fallat form-control"
													id="tipo_conx_protocolo" tabindex="14"
													name="tipo_conx_protocolo">

													<option value="">Seleccione Tipo</option>
													<%
														if (instalacion.getTipoConexProt() != null) {
																	if (instalacion.getTipoConexProt().equals("tcp")) {
													%>
													<option value="tcp" selected>TCP</option>
													<option value="udp">UDP</option>

													<%
														} else {
													%>
													<option value="tcp">TCP</option>
													<option value="udp" selected>UDP</option>
													<%
														}
																} else {
													%>
													<option value="tcp">TCP</option>
													<option value="udp" selected>UDP</option>
													<%
														}
													%>

												</select>
											</div>
											<div class="form-group">
												<label>Numero CHIP (IMEI) 1/2</label> <input type="text"
													class="form-control" id="imei" tabindex="15" name="imei"
													value="<%=d.getImei()%>">

											</div>
											<div class="form-group">
												<label>Numero Abonado</label> <input type="text"
													class="form-control" id="num_abonado" tabindex="16"
													name="num_abonado" value="<%=d.getPhone()%>">

											</div>
											<div class="form-group">
												<label>Region</label>
												 <select
													class="form-control" tabindex="17" id="region" name="region" required>
													<option value="No Asignado">-- Seleccione region</option>
													<%
													if (request.getAttribute("regiones") != null && !(request.getAttribute("regiones")).equals("")) {
																List<Region> regiones = (List) request.getAttribute("regiones");
																
																for (Region r : regiones) {
																	if(instalacion.getRegion() != null){	
																		if(r.getDescripcion().equals(instalacion.getRegion())){
																			%>
																			<option id_region="<%=r.getId()%>" value="<%=r.getDescripcion()%>" selected><%=r.getDescripcion()%></option>
																			<%
																		}else{
																	%>
																	<option id_region="<%=r.getId()%>" value="<%=r.getDescripcion()%>"><%=r.getDescripcion()%></option>
																	<% }
																	}else{
																		%>
																		<option id_region="<%=r.getId()%>" value="<%=r.getDescripcion()%>"><%=r.getDescripcion()%></option>
																		<%
																	}
																	
														}
																}
															
													%>
												</select>
											</div>
											<div class="form-group">
												<label>Comuna</label>
												 <select class="form-control" tabindex="18" id="comuna" name="comuna" required>
													<% if(instalacion.getCiudad() != null && !instalacion.equals("")){%>
														<option value="<%=instalacion.getCiudad()%>"><%=instalacion.getCiudad()%></option>
													<% }else{ %>
													<option value="No Asignado">-- Seleccione ciudad</option>
													<% } %>
												</select>
											</div>
											
										</div>
										</div>
										<hr>
										<div class="row">
										
											
											<%
											if (request.getAttribute("ListPerifericos") != null
														&& !(request.getAttribute("ListPerifericos")).equals("")) {
													String[] lista =  (String[]) request.getAttribute("ListPerifericos");
													%>
													<div class="col-lg-12">
														<div class="form-group">
															<label> Accesorios</label>
														</div>
													</div> <% 
													for (int i =0 ; i < lista.length; i++) {
														if (Integer.parseInt(lista[i]) == 15) {
															%>
														<div class="row">
															<div class="col-lg-6">
																<div class="form-group">
																	<label>CAN</label>
																	<input type="hidden" name="NamesListPerifericos" value="15">  
																	<select class="form-control" name="tipocan">
																		<option value="0" <% if(d.getTipocan().equals("0")){ out.println("selected"); } %>>No</option>
																		<option value="1" <% if(d.getTipocan().equals("1")){ out.println("selected"); } %>>SmartBox</option>
																		<option value="2" <% if(d.getTipocan().equals("2")){ out.println("selected"); } %>>SmartCan</option>
																		<option value="3" <% if(d.getTipocan().equals("3")){ out.println("selected"); } %>>OBD2</option>
																		<option value="4" <% if(d.getTipocan().equals("4")){ out.println("selected"); } %>>SmartCan2</option>
																		<option value="5" <% if(d.getTipocan().equals("5")){ out.println("selected"); } %>>SmartBox2</option>
																		<option value="6" <% if(d.getTipocan().equals("6")){ out.println("selected"); } %>>SmartCan3</option>
																		<option value="7" <% if(d.getTipocan().equals("7")){ out.println("selected"); } %>>BEL-Caiquen</option>
																		<option value="8" <% if(d.getTipocan().equals("8")){ out.println("selected"); } %>>BEL-Clock</option>
																		<option value="9" <% if(d.getTipocan().equals("9")){ out.println("selected"); } %>>BEL-Maquinas</option>
																	</select>
																</div>
															</div>
															
															<div class="col-lg-6">
																<div class="form-group">
																	<label>ID</label>
																	 <input name="tipocan" placeholder="ID" type="text" value="<%=d.getTipocan()%>" id="txtcan" class="form-control" size="8" maxlength="12" style="margin-top:2px">
																</div>	
															</div>	
															<div class="col-lg-6">
																<div class="form-group">
																	<label>FW</label>
																	<input name="fwcan"  placeholder="FW" type="text" value="<%=d.getFwcan()%>" id="fwcan" class="form-control" size="5" maxlength="12"   style="margin-top:2px" >																			
																</div>
															</div>
														</div>
														<%
														}if (Integer.parseInt(lista[i]) == 13) {%>
															<div class="col-lg-6">
																<div class="form-group">
																<label>Boton de panico</label> 
																<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">							
																<select name="bpanico" id="bpanico" class="form-control">
																	<% if(d.getBpanico() ==  null){ %>
																		<option value="0" selected>No</option>
																		<option value="1">Si</option>
																		
																	<% }else{ %>
																	<option value="1" <% if(d.getBpanico().equals("1")){ out.println("selected"); } %>>Si</option>
																	<option value="0" <% if(d.getBpanico().equals("0") || d.getBpanico().equals("")){ out.println("selected"); } %>>No</option>
																		<% } %>
																</select>
																</div>
															</div>
														<%}if (Integer.parseInt(lista[i]) == 16) {
														%>
														<div class="row">
															<div class="col-lg-6">
																<div class="form-group">
																	<label>Modulo voz</label> 
																	<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">									
																	<select name="modulovoz" id="modulovoz" class="form-control">	
																		<% if(String.valueOf(d.getMvoz()) == null ){ %>
																		<option value="0" <% if(d.getMvoz() == 0){ out.println("selected"); } %>>--Seleccionar Modelo--</option>
																		<option value="1" <% if(d.getMvoz() == 1){ out.println("selected"); } %>>SamBox</option>
																		<option value="2" <% if(d.getMvoz() == 2){ out.println("selected"); } %>>MV4</option>
																		<option value="3" <% if(d.getMvoz() == 3){ out.println("selected"); } %>>MV5(Voz Mujer)</option>
																			
																		<%}else{ %>
																			<option value="0" selected>--Seleccionar Modelo--</option>
																			<option value="1" >SamBox</option>
																			<option value="2" >MV4</option>
																			<option value="3">MV5(Voz Mujer)</option>
																		
																		<% } %>
																	</select>
																	
																</div>
															</div>
															<div class="col-lg-6">
																<div class="form-group">
																<input name="txtModulo" type="text" class="form-control" id="txtModulo" size="8"
																		maxlength="12" style="margin-top: 2px">
																</div>
															</div>
														</div>
														<%	
															}if (Integer.parseInt(lista[i]) == 14) {
																%>
																<div class="row">
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label>Ibutton ID:</label> 
																			<input type="hidden" name="txtibutton" value="1">
																			<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">												
																			<input name="id_ibutton" type="text"
																				id="id_ibutton" value="<%=d.getIdIbutto()%>" size="6" maxlength="8" class="form-control" 
																				style="margin-top: 2px">
																		</div>
																	</div>	
																	<div class="col-lg-6">
																		<div class="form-group">
																		</div>	
																	</div>	
																</div>
																<%
																}if(Integer.parseInt(lista[i]) == 23){
																	%>
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label>Easycan</label> 
																			<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">							
																			<select name="txtEasycan" id="txtEasycan" class="form-control">
																				<% if(d.getEasycan() == null) { %>
																					<option value="1" >SI</option>
																	        		<option value="0" >No</option>
																				<% }else{ %>
																	        	<option value="1" <% if(d.getEasycan().equals("1")){ out.println("selected"); } %> >SI</option>
																	        	<option value="0" <% if(d.getEasycan().equals("0")){ out.println("selected"); } %> >No</option>
																	        	<% } %>
																	        </select>
																	    </div>
																	</div>    
																<%
																}if(Integer.parseInt(lista[i]) == 11){ %>
																<div class="row">
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label>Lector Barra</label>
																			<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">	
																			<select name="txtlbarra" id="txtlbarra" class="form-control">
																				<% if(d.getLbarra() == null) { %>		
																					<option value="0" selected >-- Seleccionar Modelo  --</option>	
																		        	<option value="1">GRYPHON GFS4400</option>
																		        	<option value="2">Bcode-RT230H</option>							
																				<% }else{ %>
																		    	<option value="0" <% if(d.getLbarra().equals("0") || d.getLbarra().equals("")){ out.println("selected"); } %>>-- Seleccionar Modelo  --</option>
																		        <option value="1" <% if(d.getLbarra().equals("1")){ out.println("selected"); } %>>GRYPHON GFS4400</option>
																		        <option value="2" <% if(d.getLbarra().equals("2")){ out.println("selected"); } %>>Bcode-RT230H</option>
																		        <% } %>
																			</select>
																		</div>
																	</div>
																	<div class="col-lg-6">
																		<div class="form-group">
																		<label>ID Lector barra:</label>
																		<input name="idLbarra" type="text" id="idLbarra" value="<%=d.getIdLbarra() %>" class="form-control" size="6" maxlength="15" />
																		</div>
																	</div>
																</div>	
																<%
																}
																if(Integer.parseInt(lista[i]) == 38){%>

																	<div class="col-lg-6">
																		<div class="form-group">
																			<input type="hidden" name="cjornada" value="1">
																			<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">																	
																	    </div>
																	</div>    
																<%
																}if(Integer.parseInt(lista[i]) == 17){%>

																<div class="col-lg-6">
																	<div class="form-group">
																		<input type="hidden" name="puertas" value="1">
																		<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">																	
																    </div>
																</div>    
															<%}
																if(Integer.parseInt(lista[i]) == 10){ %>
																<div class="col-lg-6">
																	<div class="form-group">
																		<label>Sensor Temperatura</label> 
																		<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">	
																	<select name="stemp" id="stemp" class="form-control" >		
																		<% if(d.getStemp() == null){ %>		
																			<option value="0" selected>	</option>
																       	 	<option value="1" >1S TK</option>
																        	<option value="2" >2S TK</option>
																        	<option value="3" >3S TK</option>
																        	<option value="4" >1Sy2S Vehiculo</option>
																        	<option value="5" >1S + Humedad</option>
																        	<option value="6" >2S + Humedad</option>
																		<% }else{ %>						
																    	<option value="0" <% if(d.getStemp().equals("0") || d.getStemp().equals("")){ out.println("selected"); } 	%> >-- Seleccionar Modelo  --</option>
																        <option value="1" <% if(d.getStemp().equals("1")) {out.println("selected");} %> >1S TK</option>
																        <option value="2" <% if(d.getStemp().equals("2")) {out.println("selected");} %> >2S TK</option>
																        <option value="3" <% if(d.getStemp().equals("3")) {out.println("selected");} %> >3S TK</option>
																        <option value="4" <% if(d.getStemp().equals("4")) {out.println("selected");} %> >1Sy2S Vehiculo</option>
																        <option value="5" <% if(d.getStemp().equals("5")) {out.println("selected");} %> >1S + Humedad</option>
																        <option value="6" <% if(d.getStemp().equals("6")) {out.println("selected");} %> >2S + Humedad</option>
																       <% } %>
																    </select>
																	</div>
																</div>
																<div class="col-lg-6">
																	<div class="form-group">
																		
																	</div>
																</div>
																<%
																}
							
																if(Integer.parseInt(lista[i]) == 9){  %>
																<div class="row">
																	<div class="col-lg-6">
																		<div class="form-group">
																		<label>Tercer Ojo</label> 
																		<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">
																			<select name="txtmeye" id="txtmeye" class="form-control">
																				<% if(d.getMobileye() == null){  %>
																					<option value="0" selected >-- Seleccionar Modelo  --</option>
																         			<option value="1" >Mobileye</option>
																         			<option value="2" >Blackay MDAS-20</option>
																         			<option value="3">Blackay MDAS-9</option>
																				<% }else{ %>
																        		<option value="0" <% if(d.getMobileye().equals("0")){ out.println("selected"); } %> >-- Seleccionar Modelo  --</option>
																         		<option value="1" <% if(d.getMobileye().equals("1")){ out.println("selected"); } %> >Mobileye</option>
																         		<option value="2" <% if(d.getMobileye().equals("2")){ out.println("selected"); } %>>Blackay MDAS-20</option>
																         		<option value="3" <% if(d.getMobileye().equals("3")){ out.println("selected"); } %>>Blackay MDAS-9</option>
																     			<% } %>
																     		</select>
																		</div>
																	</div>
																	<div class="col-lg-6">
																		<div class="form-group">
																			<% if(request.getAttribute("listIdCamSom") !=null){
																				List<String> listadocds = (List) request.getAttribute("listIdCamSom");
																				
																				%>
																				
																				<label>Tercer Ojo</label> 
																				<select name="id_cds" id="id_cds" class="form-control">
																					<% for(String c : listadocds){ %>
																						<option value="<%=c %>" ><%=c %></option>
																					<% } %>
																	     		</select>
																	     	<% } %>
																		</div>
																	</div>
																</div>
																<% }
																if(Integer.parseInt(lista[i]) == 37){ %>
																<div class="col-lg-6">
																	<div class="form-group">
																		<input type="hidden" name="txtcandadoelect" id="txtcandadoelect">
																      	<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">
																        
																	</div>												
																</div>
																<%
																}
																if(Integer.parseInt(lista[i]) == 39){ %>
																<div class="col-lg-6">
																	<div class="form-group">
				
																      	<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">
																        <select name="horometro">
																        	<option value="0">-- Seleccionar Modelo --</option>
																        	<option value="1">GPS Trax</option>
																        	<option value="2">Be-Clock 1Horo </option>
																        	<option value="3">Be-Clock 2Horo </option>
																        	<option value="4">CAN-Beclock </option>
																        </select>
																	</div>												
																</div>
																<%
																}
																if(Integer.parseInt(lista[i]) == 12){ %>
																<div class="row">
																	<div class="col-lg-6">
																		<div class="form-group">
																			<input type="hidden" name="NamesListPerifericos" value="<%=lista[i]%>">
																			<label>Corte Corriente</label> 
																			<select name="txtccto" id="txtccto" class="form-control" >
																			<%  if(d.getCorteComb() == null ){ %>
																				<option value="0" selected>-- Seleccionar Modelo  --</option>
																	         	<option value="1" >Contacto</option>
																	        	<option value="2" >Inyeccion</option>
																	         	<option value="3" >B.Combustible</option>
																	         	<option value="4" >Arranque</option>
																	         	<option value="5" >Acelerador</option>
																			<% }else{ %>
																	         <option value="0" <% if(d.getCorteComb().equals("0") || d.getCorteComb().equals("")){ out.println("selected"); } %>  >-- Seleccionar Modelo  --</option>
																	         <option value="1" <% if(d.getCorteComb().equals("1")){ out.println("selected"); } %>>Contacto</option>
																	         <option value="2" <% if(d.getCorteComb().equals("2")){ out.println("selected"); } %>>Inyeccion</option>
																	         <option value="3" <% if(d.getCorteComb().equals("3")){ out.println("selected"); } %>>B.Combustible</option>
																	         <option value="4" <% if(d.getCorteComb().equals("4")){ out.println("selected"); } %>>Arranque</option>
																	         <option value="5" <% if(d.getCorteComb().equals("5")){ out.println("selected"); } %>>Acelerador</option>
																         	<% } %>
																         	</select>
															       		</div>
															        </div>
															        <div class="col-lg-6">
																		
																	</div>
														        </div>
																<% }
																
																
														}
													}
											%>
										</div>
										<div class="row">
											<div class="col-lg-12">
												<div class="form-group" id="observacionr">
													<label>Observacion:</label>
													<textarea class="form-control" rows="5" id="observacion" 
													name="observacion" placeholder="Por favor, ingrese comentario"><%if(instalacion.getObservacion()!=null){out.print(instalacion.getObservacion());}else{out.print("");} %></textarea>
													
												</div>
												<div id="msjobservacion"></div>
											</div>
										</div>
										<% } %>	
										<input type="hidden" class="form-control" id="opcion"
												tabindex="3" name="opcion">
										<hr>
										<br>
										
										<div class="row">											
											<div class="col-md-2 col-md-offset-2">
												<div class="form-group">
												<!--  <button class="btn btn-primary m-t-n-xs" type="button" onClick="validarGPS()" id="guardar_usu" tabindex="9">-->
													<button class="btn btn-primary btn-block m-t-n-xs" type="button" onclick="btn_guardar()" id="guardar_usu" tabindex="10">
														<strong> Guardar</strong>
													</button>
												</div>
											</div>
											<div class="col-md-3 col-md-offset-2">
												<div class="form-group">
													<button class="btn btn-warning btn-block m-t-n-xs"  type="button" onclick="btn_finalizar()"
														id="finalizar_gua" value="a" tabindex="19">
														<strong>Guardar e ir a finalizar</strong>
													</button>
												</div>
											</div>
										</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<%@include file="footerjs.jsp"%>

	<%
		Instalacion instalacion = (Instalacion) request.getAttribute("insta");
	%>
	<script>
		
		function validar2(){
			var error =  0;
			if($("#patente").val() != ''){
				if($("#patente").val() == 'SP0000'){	
					$("#patente").focus();
					document.getElementById("patenter")	.className = "form-group has-error";
					$("#msjpatente").html("<label id='-error' class='error' for=''>Por favor, No se puede ingresar patente SP0000.</label>");
					return error = 1;															
				}else{
					$("#msjpatente").html("");
					if($("#patente").val().length > 1 && $("#patente").val().length < 7){
						document.getElementById("patenter").className = "form-group has-success";
					}else{
						$("#patente").focus();
						document.getElementById("patenter")	.className = "form-group has-error";
						$("#msjpatente").html("<label id='-error' class='error' for=''>Por favor, Valor ingresado esta fuera del rango de caracteres.</label>");	
						return error = 1;	
					}
				}	
			}
			if($("#observacion").val() == '' ){
				$("#observacion").focus();
				document.getElementById("observacionr").className = "form-group has-error";
				$("#msjobservacion").html("<label id='-error' class='error' for=''>Por favor, ingrese una observacion.</label>");	
				return error = 1;
			}else{
				$("#msjobservacion").html("");
			}
			if($("#modelo").val() == '' || $("#modelo").val().length > 49 ){
				$("#modelo").focus();
				document.getElementById("modelor").className = "form-group has-error";
				$("#msjmodelo").html("<label id='-error' class='error' for=''>Por favor, ingrese un Modelo de vehiculo.</label>");	
				return error = 1;	
			}else if($("#modelo").val().length > 40){
				$("#modelo").focus();
				document.getElementById("modelor").className = "form-group has-error";
				$("#msjmodelo").html("<label id='-error' class='error' for=''>Por favor, Valor ingresado esta fuera del rango de caracteres.</label>");	
				return error = 1;	
				
			}else {
				$("#msjmodelo").html("");
				document.getElementById("modelor").className = "form-group has-success";
			}	
			
			if ($("#marcaCamion").val() == '') {
				$("#marcaCamion").focus();
				document.getElementById("marcar").className = "form-group has-error";
				$("#msjmarca").html("<label id='-error' class='error' for=''>Por favor, ingrese un marca de vehiculo.</label>");	
				return error = 1;	
			}else if($("#marcaCamion").val().length > 40){
				$("#marcaCamion").focus();
				document.getElementById("marcar").className = "form-group has-error";
				$("#msjmarca").html("<label id='-error' class='error' for=''>Por favor, Valor ingresado esta fuera del rango de caracteres.</label>");	
				return error = 1;	
			}else {
				$("#msjmarca").html("");
				document.getElementById("marcar").className = "form-group has-success";
			}	
			
			return error;
		}
	
		
		$(document).ready(function(){
        	$("#patente").attr('maxlength','9');
        	$("#imei").attr('maxlength','30');
        	$('#anio_vehiculo').numeric();    // números	
			$("#voltaje").numeric();
			$("#odo").numeric();
			
			$("#region").change(function(){
				//var idRegion = $(this).find(":checked").val();
				var idRegion = $(this).find(":checked").attr("id_region");
				console.log(idRegion);
				$.ajax({
					type : 'GET',
		   			url : 'ubicacionajax.html',
		   			data : {
		   				region : idRegion
		   				
		   			},
		   			success : function(respuesta) {	
		   				$("#comuna").html(respuesta);
		   			}
	   			});
				
			});
		});
		
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
			 		           data: {accion: 9,id_insta: <%=request.getParameter("id_insta")%>,tipo:'Final',file :  file.previewElement.querySelector('[data-dz-name]').innerHTML},
			 		           
			 		      });   	       	  
		            	  file.previewElement.remove(); 
		            }); 

	            	<%
	            	 if (instalacion.getFotos() != null) {
	 					List<Foto> fotos = instalacion.getFotos();
	 					for (Foto f : fotos) {
	 						if (f.getTipo().equals("Final")) {%>
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
		</script>

	<script>
			function btn_finalizar(){
				error = 0;
				ajax=objetoAjax();
		        ajax.open("GET", 'otajax.html?tipo=Final&accion=10&id_insta=<%=request.getAttribute("id_insta")%>');
		        ajax.onreadystatechange=function() {
		        	if (ajax.readyState==4) {
		            	respuesta = ajax.responseText;
		            	if(respuesta == 1){
		            		swal({
              	            	title: "Falta Informacion",
                	            text: "Debe Agregar al menos Una Foto Final."
                	        });
		            		

		            	}else{
		            		error = validar2();
	         				console.log(error);	
	         				if(error == 0){
	         					document.getElementById("opcion").value = "op1";					
	         					document.getElementById("form_id").submit();
	         				}
		            	}
		        	}
		        }
		        ajax.send(null)  
			}	
			
			function btn_guardar(){
				error = 0;
				ajax=objetoAjax();
		        ajax.open("GET", 'otajax.html?tipo=Final&accion=10&id_insta=<%=request.getAttribute("id_insta")%>');
		        ajax.onreadystatechange=function() {
		        	if (ajax.readyState==4) {
		            	respuesta = ajax.responseText;
		            	if(respuesta == 1){
		            		swal({
              	            	title: "Falta Informacion",
                	            text: "Debe Agregar al menos Una Foto Final."
                	        });	            		
		            		
		            	}else{
		            		error = validar2();
	         				
	         				if(error == 0){
	         					document.getElementById("opcion").value = "op2";					
	         					document.getElementById("form_id").submit();
	         				}
		            	}
		        	}
		        }
		        ajax.send(null)  
			}	
		
			function objetoAjax() {

				var xhttp;

				if (window.XMLHttpRequest) {
					xhttp = new XMLHttpRequest();
				} else if (window.ActiveXObject) {
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
