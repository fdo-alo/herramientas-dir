package gob.imss.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import gob.imss.entity.Prodecon;
import gob.imss.service.NivelesService;
import gob.imss.service.ProdeconService;

@Controller
public class NivelesController {

	@Autowired
	ServletContext context;

	@Autowired
	NivelesService nivelesService;

	@Autowired
	ProdeconService prodeconService;

	@RequestMapping("/prodecon/{numero}/subir")
	public String startProdecon(Model model, @PathVariable String numero) {
		Prodecon prodecon = prodeconService.prodeconById(Integer.parseInt(numero));

		String catalinabase = System.getProperty("catalina.base");
		String catalinahome = System.getProperty("catalina.home");

		model.addAttribute("digital", prodecon.getDigital());
		model.addAttribute("catalinabase", catalinabase);
		model.addAttribute("catalinahome", catalinahome);
		model.addAttribute("numero", prodecon.getNumero());
		model.addAttribute("promovente", prodecon.getPromovente());
		model.addAttribute("queja", prodecon.getQueja());

		return "upload-file";
	}

	@RequestMapping(value = "/upload/{numero}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String returnJsonSubdelegaciones(Model model, HttpServletRequest request,
			@PathVariable("numero") String numero) {

		System.out.println("El numero es: " + numero);

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {

			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// Parse the request
				List<FileItem> multiparts = upload.parseRequest(request);

				Prodecon prodecon = prodeconService.prodeconById(Integer.parseInt(numero));

				for (FileItem fileItem : multiparts) {
					if (!fileItem.isFormField()) {
						String name = new File(fileItem.getName()).getName();
						fileItem.write(new File(prodecon.getDigital() + name));

					} // fin if(!fileItem.isFormField())
				} // fin for

			} catch (Exception e) {
				e.printStackTrace();
			} // fin catch

		} // fin if(ismultipart)

		String json = new Gson().toJson(null);
		return json;

	}// fin method returnJsonSubdelegaciones

}
