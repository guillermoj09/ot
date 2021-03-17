package cl.samtech.ot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.datosgrafico;
import cl.samtech.ot.form.LoginForm;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.service.UsuarioService;

import org.springframework.validation.BindingResult;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;



@Controller
@RequestMapping("loginform.html")
public class LoginController {
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model,HttpServletRequest request,RedirectAttributes attributes) {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UsuarioLogin usuario=UsuarioService.findUsuarioLogin(username);

	
		loginForm = (LoginForm) model.get("loginForm");
		if(!username.equals(usuario.getUsername())){
			return "U0";
		}
		if(!password.equals(usuario.getPassword())){
			return "P0";
		}
		request.getSession().setAttribute("usuario", usuario);
		request.getSession().setAttribute("username", usuario);

	
		return "OK";
	

	}
	
}
