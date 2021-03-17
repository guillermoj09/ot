package cl.samtech.ot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.samtech.ot.service.ClienteService;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.service.TareasService;
import model.Agenda;
import model.Device;
import model.Instalacion;
import model.Ot;

@Controller
public class AjaxGPSController {

	@RequestMapping(value = "/ingresogps.html", method = RequestMethod.POST)
	@ResponseBody()
	public String Validador(HttpServletRequest request) {

		String cliente = request.getParameter("cliente");
		String idTarea = request.getParameter("idTarea");
		String idGps = request.getParameter("id_gps");

		// validar si el gps esta ingresado en un cliente
		boolean verificarClienteStock = ClienteService.verificarClienteAsignado("stock", idGps.toUpperCase());
		Device device = InstalacionService.findGPS(idGps.toUpperCase());
		boolean clienteExiste = ClienteService.verificarGPSCliente(idGps.toUpperCase());
		

		if (device != null) {
			Long exInst = InstalacionService.existeInstalacion(idGps.toUpperCase(),Long.parseLong(idTarea));
			if (verificarClienteStock == true) {	
				TareasService.findTarea(Long.valueOf(idTarea));
				if(exInst == 0) {
					Long id_insta = InstalacionService.crearInstalacion(idGps.toUpperCase(),idTarea);
					request.setAttribute("id_insta", id_insta);	
					Instalacion insta = InstalacionService.findInstalacion(id_insta);
					request.setAttribute("insta", insta);
					return "1:"+id_insta;
				}else {
					request.setAttribute("id_insta", exInst);	
					//Instalacion insta = TareasService.findInstalacion(exInst);
					//request.setAttribute("insta", insta);
					return "1:"+exInst;
				}						
			}else if(clienteExiste == true){
				//GPS en cliente
				return "3:";
			}else{
				//gps nuevo
				TareasService.findTarea(Long.valueOf(idTarea));
				if(exInst == 0) {
					Long id_insta = InstalacionService.crearInstalacion(idGps,idTarea);
					request.setAttribute("id_insta", id_insta);	
					Instalacion insta = InstalacionService.findInstalacion(id_insta);
					request.setAttribute("insta", insta);
					return "1:"+id_insta;
				}else {
					request.setAttribute("id_insta", exInst);	
					//Instalacion insta = TareasService.findInstalacion(exInst);
					//request.setAttribute("insta", insta);
					return "1:"+exInst;
				}				
			}
		}else{
			return "0:";
		}
	}

}
