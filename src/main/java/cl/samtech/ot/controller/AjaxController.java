package cl.samtech.ot.controller;

import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.samtech.ot.DisciplinaActiva;
import cl.samtech.ot.FallaActiva;
import cl.samtech.ot.LugarActivo;
import cl.samtech.ot.UbicacionActiva;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.service.TareasService;
import cl.samtech.ot.service.ValidacionLogService;


@Controller
@RequestMapping("/otajax")
public class AjaxController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request,Map model) {
		
		String texto="<option value='0'>Seleccione</option>";
		if(request.getSession().getAttribute("usuario")==null)
		{
			texto= "Sesion expirada! Vuelva a Ingresar.";
	        request.setAttribute("texto", texto);				
			return new ModelAndView("otajax");
		}
		try {
		String accion=request.getParameter("accion");
		String id=request.getParameter("id");
		String id_insta = request.getParameter("id_insta");
		String ot = request.getParameter("ot");
		String folio = request.getParameter("folio");
		String anexo =request.getParameter("anexo");
		String perifericosAdd = request.getParameter("perifericos");
		
        switch (Integer.parseInt(accion)) {
        	case 1:         	
        		
        		texto = ValidacionLogService.validarGPS(id,Long.parseLong(ot),Integer.parseInt(folio),Integer.parseInt(anexo),perifericosAdd);
        		break;
            case 9:  
            	String nombre=request.getParameter("file");
            	String tipo=request.getParameter("tipo");  
            	InstalacionService.eliminarFoto(id_insta,tipo,nombre);            	
                break;
            case 5:  
            	 	
            	if(TareasService.completarTarea(Long.parseLong(id))) {
            		texto="Tarea Completada Exitosamente";
            	}else{
            		texto="Hubo un Error al intentar Completar la Tarea";
            	}
                break;
                    
            case 10:   
            	String tipo2=request.getParameter("tipo"); 
            	if(InstalacionService.existeFoto(Long.parseLong(id_insta),tipo2)){
            		
            		texto="0";
            	}else{
            		
            		texto="1";
            	}
            	      	
                break;                 
        }
        request.setAttribute("texto", texto);
		}catch(Exception e) {
			 request.setAttribute("texto", "Error");
		}
       
			
		return new ModelAndView("otajax");
	}
}
