package cl.samtech.ot.controller;


import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cl.samtech.ot.AreaActiva;
import cl.samtech.ot.DisciplinaActiva;
import cl.samtech.ot.EspecialidadActiva;
import cl.samtech.ot.MedioActivo;
import cl.samtech.ot.PrioridadActiva;
import cl.samtech.ot.TurnoActivo;
import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.service.TareasService;
import model.Agenda;

@Controller
@RequestMapping("vertarea.html")
public class VerTareaController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(Map model,HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario")==null)
		{
			return new ModelAndView("home");
		}
	
		CrearTareaForm crearTareaForm = new CrearTareaForm();		
	
		
		String id = (String)request.getParameter("id");
		
		
		Agenda tarea=TareasService.findTarea(Long.valueOf(id));
		
		
		
		request.setAttribute("tarea", tarea);			
		
		
		model.put("crearTareaForm", crearTareaForm);			
		
		return new ModelAndView("vertarea");
	}
	
	
	
}