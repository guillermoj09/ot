package cl.samtech.ot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cl.samtech.ot.form.LoginForm;
import org.springframework.validation.BindingResult;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;



@Controller
@RequestMapping("logout.html")
public class logoutController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model,HttpServletRequest request) {
		
		
		
		       request.getSession().invalidate();
		
	
		
		return "redirect:/";
	}

}
