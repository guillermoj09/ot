package cl.samtech.ot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/finalizado.html")
public class FinalizadoController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView show(Model model,HttpServletRequest request, @ModelAttribute("ot") String ot,@ModelAttribute("url") String url) {
		
		request.setAttribute("url", url);
		request.setAttribute("ot", ot);
		return new ModelAndView("finalizado");
	}
		

}
