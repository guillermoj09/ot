package cl.samtech.ot.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.util.FileCopyUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import cl.samtech.ot.EstadoActivo;
import cl.samtech.ot.PrioridadActiva;
import cl.samtech.ot.UploadedFile;
import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.form.LoginForm;
import cl.samtech.ot.form.UploadForm;
import cl.samtech.ot.service.InstalacionService;
import cl.samtech.ot.util.Imagen;
import cl.samtech.ot.util.RandomStringUUID;

@Controller
public class UploadController {
	final static Logger logger = Logger.getLogger(UploadController.class);
	
	@ResponseBody()
	@RequestMapping(value = "/upload.html", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			@Valid CrearTareaForm crearTareaForm, Map model) {

		crearTareaForm = (CrearTareaForm) model.get("crearTareaForm");
	
		
		if (!file.isEmpty()) {
			try {
				byte[] bytefoto = file.getBytes();	
				ObjectMapper mapper = new ObjectMapper();

				String rootPath ="/opt/tomcat/apache-tomcat-9.0.2/webapps/web/imgotsamtech/";
				String nombre = RandomStringUUID.obetenerUID() + ".jpg";
				String url = "http://app.samtech.cl/web/imgotsamtech/"+nombre;
				String archivo = rootPath + nombre;
				Path path = Paths.get(rootPath + nombre);
				InputStream in = new ByteArrayInputStream(bytefoto);
				Imagen.copyImage(in, archivo);
				//metodo agregar Foto instalacion
				InstalacionService.agregarFoto(crearTareaForm, url);
				return mapper.writeValueAsString(url);	
			} catch (Exception e) {
				return "error";
			}
		} else {
			return "error";
		}
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