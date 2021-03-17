package cl.samtech.ot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PruebaController {
	
	@RequestMapping(value="prueba.html",method= RequestMethod.GET)
	public String show(){
		return "prueba";
	}
}
