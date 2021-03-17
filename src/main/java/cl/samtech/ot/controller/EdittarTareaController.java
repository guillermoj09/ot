package cl.samtech.ot.controller;


import java.util.ArrayList;
import java.util.List;
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
import cl.samtech.ot.EstadoActivo;
import cl.samtech.ot.MedioActivo;
import cl.samtech.ot.PrioridadActiva;
import cl.samtech.ot.TurnoActivo;
import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.service.ClienteService;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.service.TareasService;
import cl.samtech.ot.service.ValidacionLogService;
import model.Agenda;
import model.Instalacion;
import model.Ot;
import model.Periferico;
import model.SamFicha;
import model.SamFichaHardware;
import model.SamHardware;

@Controller
@RequestMapping("editartarea.html")
public class EdittarTareaController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(Map model,HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario")==null)
		{
			return new ModelAndView("home");
		}
		UsuarioLogin user =(UsuarioLogin)request.getSession().getAttribute("usuario");
		CrearTareaForm crearTareaForm = new CrearTareaForm();		
		int op = Integer.parseInt(request.getParameter("op"));
		Agenda agenda = null;
		SamFicha sf = null;
		String id = (String) request.getParameter("id");
		String accion = (String) request.getParameter("accion");
		String id_instalacion = (String) request.getParameter("id_insta");
		String id_gps = (String) request.getParameter("idGps");
		
		if(op == 2) {
			request.setAttribute("op", op);
			List<Periferico> listadoFindPer = ValidacionLogService.findPerifericos(id_gps, Long.parseLong(id_instalacion));
			request.setAttribute("ListPerifericos", listadoFindPer);
		}else {
			request.setAttribute("op", op);
		}
			
		agenda =TareasService.findAgenda(Long.valueOf(id));
		sf = TareasService.findSamFicha(Integer.parseInt(agenda.getEmpresa()));
		
		Instalacion instalacion = InstalacionService.findInstalacion(Long.parseLong(id_instalacion));
		request.setAttribute("instalacion", instalacion);
	
		Ot ot=TareasService.findOT(Long.valueOf(id));
		
		request.setAttribute("id_gps", id_gps);
		request.setAttribute("agenda", agenda);
		request.setAttribute("sf", sf);
		request.setAttribute("ot", ot);
		List<SamFichaHardware> listFichaHardw = ClienteService.findAcessorios(Integer.parseInt(agenda.getEmpresa()),Integer.parseInt(agenda.getFolioAnexo()));
		request.setAttribute("listHardware", listFichaHardw);
		crearTareaForm.setIdGps(id_gps);
		crearTareaForm.setGps(id_gps);
		model.put("crearTareaForm", crearTareaForm);			
		
		return new ModelAndView("editartarea");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(@Valid CrearTareaForm crearTareaForm, BindingResult result,
			Map model,HttpServletRequest request) {

		if (result.hasErrors()) {
			return new ModelAndView("home");
		}
		crearTareaForm = (CrearTareaForm) model.get("crearTareaForm");

		UsuarioLogin user=(UsuarioLogin)request.getSession().getAttribute("usuario");
		crearTareaForm.setUsuario(user.getUsername());
		request.setAttribute("tarea", crearTareaForm.getIdTarea());
			if(TareasService.modificarTarea(crearTareaForm,user)){
				return new ModelAndView("tareaguardada");
			}	
		return new ModelAndView("tareaexiste");
		
	}
	
}