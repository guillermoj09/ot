package cl.samtech.ot.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.json.JSONObject;

import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.form.FinalizarForm;
import cl.samtech.ot.service.ClienteService;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.service.TareasService;
import cl.samtech.ot.util.RandomStringUUID;
import model.Agenda;
import model.Ot;
import model.SamFichaHardware;
import model.SamHardware;

@Controller
@RequestMapping("finalizartarea.html")
public class FinalizarTareaController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView show(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("usuario")==null)
		{
			return new ModelAndView("home");
		}
		UsuarioLogin user = (UsuarioLogin)request.getSession().getAttribute("usuario");
		String id_ot = request.getParameter("id");
		Ot ot = TareasService.findOT(Long.parseLong(id_ot));

		Agenda tarea = TareasService.findAgenda(Long.parseLong(id_ot));
		String numPend = InstalacionService.NumSolicitadas(Long.parseLong(id_ot));
		Integer numInstaladas = InstalacionService.numInstaladas(tarea.getEmpresa(),tarea.getFolioAnexo());
		List<SamFichaHardware> listFichaHardw = ClienteService.findAcessorios(Integer.parseInt(tarea.getEmpresa()),Integer.parseInt(tarea.getFolioAnexo()));
		request.setAttribute("listFichaHardw", listFichaHardw);
		List<SamHardware> listHardware = ClienteService.findAllAccesorios();
		request.setAttribute("listHardware", listHardware);
		request.setAttribute("ot", ot);
		request.setAttribute("InstaPendiente", Integer.parseInt(numPend));
		request.setAttribute("InstaInstaladas", numInstaladas);
		request.setAttribute("tarea", tarea);

		return new ModelAndView("finalizartarea");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String Finish(@Valid FinalizarForm fForm,HttpServletRequest request,RedirectAttributes attributes) {
		
	
		UsuarioLogin user = (UsuarioLogin)request.getSession().getAttribute("usuario");
		
		try {
			String data = fForm.getImg_val();
			
			String base64Image = data.split(",")[1];
			
			byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
			
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
			
			String rootPath = "/opt/tomcat/apache-tomcat-9.0.2/webapps/web/imgotsamtech/";
			//String rootPath = "C:\\Users\\guill\\Documents\\workspace_trabajo_2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\otsamtech\\resources\\imagenes\\";
			String nombre = RandomStringUUID.obetenerUID()+".jpg";
			//String url = "http://localhost:8080/otsamtech/resources/imagenes/"+nombre;
			String url = "http://app.samtech.cl/web/imgotsamtech/"+nombre;
			//String url = "http://test1.samtech.cl/web/imgotsamtech/70bb618d-3920-4ec8-bcc9-22c6742292f6.jpg";
			Path path = Paths.get(rootPath + nombre);
			Files.write(path, imageBytes);
			String decodedToUTF8 = new String(fForm.getObservaciones().getBytes("ISO-8859-1"), "UTF-8");
			String nombreclienteToUTF8 = new String(fForm.getNombrecliente().getBytes("ISO-8859-1"), "UTF-8");
			boolean validacion = TareasService.FinalizarTarea(user,fForm.getFechaInicio(),fForm.getId_ot(),decodedToUTF8,url, nombre,"",Integer.parseInt(fForm.getFolio())
					,Integer.parseInt(fForm.getAnexo()),nombreclienteToUTF8,fForm.getRutcliente(),fForm.getCargo(),fForm.getEmail(),fForm.getHorainicio(),fForm.isValidaracc(),fForm.getPerifericos());
			if(validacion){
				attributes.addFlashAttribute("msj", "OK");
			}	
		} catch (Exception e) {
			return "redirect:principal.html";
		}
		return "redirect:principal.html";
	}
	
	private JSONObject getSuccessMessage() {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject("{\"success\":true}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	private JSONObject getErrorMessage() {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject("{\"success\":false}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}


}
