package cl.samtech.ot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/retiro.html")
public class RetiroController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView show(){
		
		return new ModelAndView("retiro");
	}

}
