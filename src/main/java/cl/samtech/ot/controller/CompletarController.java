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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.samtech.ot.AgendaActiva;
import cl.samtech.ot.AreaActiva;
import cl.samtech.ot.DisciplinaActiva;
import cl.samtech.ot.EspecialidadActiva;
import cl.samtech.ot.EstadoActivo;
import cl.samtech.ot.MedioActivo;
import cl.samtech.ot.PrioridadActiva;
import cl.samtech.ot.TurnoActivo;
import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.form.DeviceForm;
import cl.samtech.ot.form.ValidarForm;
import cl.samtech.ot.service.ClienteService;
import cl.samtech.ot.service.InstalacionService;
import model.Agenda;
import model.Cliente;
import model.Compania;
import model.Device;
import model.Device_Tipogp;
import model.Faenas;
import model.Instalacion;
import model.Ot;
import model.Region;
import model.SamFichaHardware;
import model.TipoVehiculo;

@Controller
public class CompletarController {
	
	@RequestMapping(value="completar.html" , method = RequestMethod.POST)
	public String showForm(@Valid ValidarForm validarForm,Map model,HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario")==null)
		{
			return "home";
		}
		
		try {
			validarForm = (ValidarForm) model.get("validarForm");
			String[] ListPerifericos = request.getParameterValues("NamesListPerifericos");
			String id = validarForm.getIdGps();
			String id_insta = validarForm.getId_insta();
			String ot_id = validarForm.getOt_id();
			String perifericos = validarForm.getPerifericos();
			
			request.setAttribute("ListPerifericos", ListPerifericos);
			request.setAttribute("ot_id",ot_id);
			request.setAttribute("id", id);
			
			List<Device_Tipogp> ltg=InstalacionService.allTipogps();
			request.setAttribute("ltg", ltg);	
			List<TipoVehiculo> ltv=InstalacionService.allTipovehiculo();
			request.setAttribute("ltv", ltv);
			
			List<Region> regiones = InstalacionService.findAllRegiones();
			request.setAttribute("regiones", regiones);	
			List<String> colores = listaColores();
			request.setAttribute("colores", colores);
			List<Compania> companias = InstalacionService.allCompania();
			request.setAttribute("companias", companias);
	        List<String> listIdCamSom = InstalacionService.listadoIdCamSom();
	        request.setAttribute("listIdCamSom", listIdCamSom);
			List<SamFichaHardware> listFichaHardw = ClienteService.findAcessorios(Integer.parseInt(validarForm.getFolio()), Integer.parseInt(validarForm.getAnexo()));
	
			request.setAttribute("listFichaHardw", listFichaHardw);
			
			Device d= InstalacionService.findGPS(id);
			request.setAttribute("d", d);	
			
			InstalacionService.saveTablaValidaciones(validarForm);
			
			Instalacion insta = InstalacionService.findInstalacion(Long.parseLong(id_insta));
			request.setAttribute("id_insta",Long.parseLong(id_insta));	
			request.setAttribute("insta", insta);
			
			return "completar";
			
		}catch(Exception e){
			return "principal";
		}
		
	}
	
	@RequestMapping(value="save.html", method = RequestMethod.POST)
	public String processForm(@Valid DeviceForm deviceForm, BindingResult result,
			Map model,HttpServletRequest request,RedirectAttributes attributes) {
		
		if(request.getSession().getAttribute("usuario")==null)
		{
			return "home";
		}	
		try {
			
		
		String opcion = deviceForm.getOpcion();
		
		String[] ListPerifericos = request.getParameterValues("NamesListPerifericos");

		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute("usuario");
		
		boolean respuesta = InstalacionService.saveInstalacion(deviceForm,user,ListPerifericos);
		if(respuesta) {
			if(opcion.equals("op1")){
				return "redirect:finalizartarea.html?lc="+deviceForm.getCliente_login()+"&id="+deviceForm.getOt_id();
			}else {
				attributes.addFlashAttribute("mensaje", "OK");
			}
		}
		return "redirect:principal.html";
		
		}catch(Exception e){
			attributes.addFlashAttribute("error", "OK");
			return "redirect:principal.html";		
		}
		
	}
	
	public List<String> listaColores() {
		List<String> listaColores = new ArrayList<String>();
		listaColores.add("Blanco");
		listaColores.add("Rojo");
		listaColores.add("Azul");
		listaColores.add("Plata");
		listaColores.add("Verde");
		listaColores.add("Amarillo");
		listaColores.add("Beige");
		listaColores.add("Gris");
		listaColores.add("Negro");
		listaColores.add("Rosado");
		listaColores.add("Naranjo");
		listaColores.add("Grafito");
		listaColores.add("Morado");
		listaColores.add("Marron");
		
		return listaColores;
		
	}
	
	
	
}