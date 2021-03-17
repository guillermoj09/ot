<%@ page import="cl.samtech.ot.UsuarioLogin"%>
<%UsuarioLogin usuario= (UsuarioLogin)request.getSession().getAttribute("usuario"); %>
<li class="nav-header">
	<div class="dropdown profile-element">
		<span><img src="resources/img/logologin.png"> </span> <a
			data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
			class="clear"> <span class="block m-t-xs"> <strong
					class="font-bold"><%=usuario.getNombre()+" "+usuario.getApellidos() %></strong>
			</span> <span class="text-muted text-xs block"><%=usuario.getRolDescripcion() %> </span>
		</span>
		</a>

	</div>
	<div class="logo-element">
		<img src="resources/img/icon.png">
	</div>
</li>