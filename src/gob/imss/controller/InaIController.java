package gob.imss.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import gob.imss.config.FTPUpload;
import gob.imss.config.SpringConfig;
import gob.imss.entity.Inai;
import gob.imss.service.InaiService;


@Controller
public class InaIController {
	
	@Autowired
	InaiService inaiService;
	
	
	@RequestMapping("/inai")
	public String startProdecon(Model model, @ModelAttribute("resultado") String resultado, @ModelAttribute("alert") String alerta) {
		
		model.addAttribute("inai", inaiService.getInai());
		model.addAttribute(resultado);
		model.addAttribute("alert", alerta);

		return "inicio-inai";
	}
	
	
	@GetMapping("/inai/agregar")
	public String saveInai(Model model) {

		Inai inai = new Inai();


		model.addAttribute("boton", "Agregar");
		model.addAttribute("titulo", "Agregar inai");

		
		model.addAttribute("consecutivo", inaiService.inaiLastRegisterDesc());
		model.addAttribute("inai", inai);

		return "agregar-inai";
	}
	
	
	
	@PostMapping("/inai/agregar")
	public String saveInaiPost(Model model, @ModelAttribute("inai") @Valid Inai inai, BindingResult result,
			RedirectAttributes ra) {

		if (result.hasErrors()) {
			
			
			model.addAttribute("boton", "Agregar");
			model.addAttribute("titulo", "Agregar inai");

			
			model.addAttribute("consecutivo", inaiService.inaiLastRegisterDesc());
			model.addAttribute("inai", inai);
			
			return "agregar-inai";
		}

		try {

			System.out.println("número: " + inai.getId());
			
			 String nombreCarpeta =
			 "inai" + "/"			 
			 + inai.getId() + "/";
			
			 

//			String nombreCarpeta = System.getProperty("catalina.base") + File.separator + "webapps" + File.separator
//					+ "quejas" + File.separator + String.valueOf(cal.get(Calendar.YEAR)) + " - " + promoventeDir + " - "
//					+ quejaDir + File.separator;
			
			new FTPUpload(nombreCarpeta);
			
			//inai.setDigital("ftp://172.24.29.176/"+nombreCarpeta.replace("%2F", "/").replace("+", "%20").replace("%C3%B1", "ñ"));
			inai.setDigital("ftp://"+SpringConfig.direccionIP+"/" + nombreCarpeta);
			

			inaiService.saveInai(inai);
			
			ra.addFlashAttribute("resultado", "Registro agregado con exito");
			ra.addFlashAttribute("alert", "alert-success");

			return "redirect:/inai";

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ra.addFlashAttribute("resultado", "Error al agregar el registro");
			ra.addFlashAttribute("alert", "alert-danger");
			return "redirect:/inai";
		}
		

	}
	
	
	@RequestMapping("/inai/{numero}/modificar")
	public String modifyInai(Model model, @PathVariable int numero) {

		Inai inai = inaiService.getInaibyId(numero);
		
		model.addAttribute("boton", "Actualizar");
		model.addAttribute("titulo", "Modificar inai");		
		model.addAttribute("inai", inai);

		return "agregar-inai";

	}
	
	
	@RequestMapping("/inai/{numero}/archivos")
	public String filesInai(Model model, @PathVariable int numero) {
		Inai inai = inaiService.getInaibyId(numero);		
		model.addAttribute("inai", inai);
		return "file-show-inai";
	}
	
	
	@PostMapping("/inai/{numero}/upload")
	@ResponseBody
	public String uploadFiles(HttpServletRequest request, HttpServletResponse response, @PathVariable int numero) throws IllegalStateException, IOException
	{
		
		if (!ServletFileUpload.isMultipartContent(request)) {
            throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
        }
		
		Inai inai = inaiService.getInaibyId(numero);
		String json;
		
		FTPUpload ftpUpload = new FTPUpload();		
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        
        try{
        	List<FileItem> list = upload.parseRequest(request);
        	
        	for(FileItem item : list)
        	{
        		if (!item.isFormField())
        		{
        			ftpUpload.uploadFiles(inai.getDigital(), item.getName() , item.getInputStream() );
        		}
        	}
        	
        	        	
        }catch (FileUploadException e) {
			System.out.println("Error al grabar es: " + e.getMessage());
			json = new Gson().toJson("Error al grabar es: " + e.getMessage());
		}
		
		json = new Gson().toJson("Procesado correctamente");

		System.out.println(json);
		return json;
		
	}
	
	@GetMapping("/inai/{numero}/subir")
	public String showUploadFiles(Model model, @PathVariable int numero)
	{
		Inai inai = inaiService.getInaibyId(numero);
		
		model.addAttribute("id", inai.getId());
		model.addAttribute("folio", inai.getFolio());
		model.addAttribute("digital", inai.getDigital());
		
		return "upload-file-inai";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
