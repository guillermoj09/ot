package cl.samtech.ot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cl.samtech.ot.service.InstalacionService;
import model.Comuna;

@Controller
@RequestMapping("/ubicacionajax")
public class AjaxUbicacionController {
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String showComunas(HttpServletRequest request,Map model) {
		
		List<Comuna> listComunas = InstalacionService.findComunas(Integer.parseInt(request.getParameter("region")));
		StringBuilder sb = new StringBuilder();
		for(Comuna c : listComunas){
			sb.append("<option value='").append(c.getNombre()).append("'>").append(c.getNombre()).append("</option>");
		}
		String resultado = sb.toString();
		return resultado;
	}

}
