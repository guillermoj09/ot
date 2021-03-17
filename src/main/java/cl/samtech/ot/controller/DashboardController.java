package cl.samtech.ot.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.datosgrafico;
import cl.samtech.ot.service.InstalacionService;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard")
	public ModelAndView monitoreo(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario")==null)
		{
			return new ModelAndView("home");
		}
		
		
	
				
		/*String tareasactuales=TareasService.tareas7();
		
		datosgrafico tareasgrafico = TareasService.TareasGrafico();
		
		
		request.setAttribute("tareasactuales", tareasactuales);
		
		request.setAttribute("tareasgrafico", tareasgrafico);*/
		
		return new ModelAndView("dashboard");
	}

}
