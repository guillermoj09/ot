package cl.samtech.ot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.service.InstalacionService;
import model.Agenda;
import model.Instalacion;
import model.Ot;


@Controller
@RequestMapping("/fotofinal.html")
public class FotoFinalController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request,Map model) {
		
		if(request.getSession().getAttribute("usuario")==null)
		{
			return new ModelAndView("home");
		}
		
		CrearTareaForm crearTareaForm = new CrearTareaForm();
		String id=request.getParameter("id");
		String idInsta=request.getParameter("id_insta");
		
		Instalacion instalacion = InstalacionService.findInstalacion(Long.parseLong(idInsta));
		request.setAttribute("instalacion", instalacion);
		
		
		model.put("crearTareaForm", crearTareaForm);	
		
		return new ModelAndView("fotofinal");
		
	}
	
}