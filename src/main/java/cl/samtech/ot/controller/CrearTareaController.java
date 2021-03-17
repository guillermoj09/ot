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
import cl.samtech.ot.TurnoActivo;
import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.service.ClienteService;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.service.TareasService;

@Controller
@RequestMapping("creartarea.html")
public class CrearTareaController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(Map model,HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario")==null)
		{
			return new ModelAndView("home");
		}
		UsuarioLogin user=(UsuarioLogin)request.getSession().getAttribute("usuario");
	
		CrearTareaForm crearTareaForm = new CrearTareaForm();		
	
		/*ArrayList<AreaActiva> areas=TareasService.AreasUsuario(user);
		ArrayList<EspecialidadActiva> especialidades=TareasService.Especialidades();		
		ArrayList<MedioActivo> mediosactivos=TareasService.allMedios();
		ArrayList<TurnoActivo> turnosactivos=TareasService.allTurnos();
		
		
		request.setAttribute("especialidades", especialidades);			
		request.setAttribute("areas", areas);	
		request.setAttribute("mediosactivos", mediosactivos);	
		request.setAttribute("turnosactivos", turnosactivos);			
		*/
		
		model.put("crearTareaForm", crearTareaForm);			
		
		return new ModelAndView("creartarea");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(@Valid CrearTareaForm crearTareaForm, BindingResult result,
			Map model,HttpServletRequest request) {


		if (result.hasErrors()) {
			return new ModelAndView("home");
		}
		crearTareaForm = (CrearTareaForm) model.get("crearTareaForm");
		
		//ClienteService.asignar_faena_vehiculos(crearTareaForm.getIdGps(),crearTareaForm.getSolicitante());
		
		Integer idubicacion= Integer.valueOf(crearTareaForm.getUbicacion());
		Integer idfalla=Integer.valueOf(crearTareaForm.getFalla());
	
		
		if(TareasService.existeTarea(idfalla, idubicacion)){
			
			return new ModelAndView("tareaexiste");
		}else{
			
			UsuarioLogin user=(UsuarioLogin)request.getSession().getAttribute("usuario");
			crearTareaForm.setUsuario(user.getUsername());
			if(TareasService.guardarTarea( crearTareaForm )){
				return new ModelAndView("tareaguardada");
			}
	
		}
			
		
		
		return new ModelAndView("tareaexiste");
		
	}
	
}