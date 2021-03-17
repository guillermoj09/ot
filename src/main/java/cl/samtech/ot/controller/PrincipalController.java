package cl.samtech.ot.controller;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.samtech.ot.AgendaActiva;
import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.datosgrafico;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.service.TareasService;




@Controller
public class PrincipalController {
	@RequestMapping("/principal")
	public ModelAndView monitoreo(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario")==null)
		{
			return new ModelAndView("home");
		}
		UsuarioLogin usuario= (UsuarioLogin)request.getSession().getAttribute("usuario"); 
		ArrayList<AgendaActiva> tareasactuales = new ArrayList<AgendaActiva>();		
		tareasactuales=TareasService.allTareas((UsuarioLogin)request.getSession().getAttribute("usuario"));		
		
		request.setAttribute("tareasactuales", tareasactuales);	
		
		
		return new ModelAndView("principal");
		
	
		
	}
}