package gob.imss.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import gob.imss.config.FTPUpload;
import gob.imss.config.FileMeta;
import gob.imss.entity.Prodecon;
import gob.imss.service.DelegacionesService;
import gob.imss.service.NivelesService;
import gob.imss.service.ProdeconService;
import gob.imss.service.TipoDeAcuerdoDefinitivoService;

@Controller
public class ProdeconController {

	@Autowired
	ServletContext context;

	@Autowired
	private ProdeconService prodeconService;

	@Autowired
	private NivelesService nivelesService;

	@Autowired
	private DelegacionesService delegacionesService;

	@Autowired
	private TipoDeAcuerdoDefinitivoService tipoDeAcuerdoDefinitivoService;

	@RequestMapping("/")
	public String home(Model model) {

		return "index";
	}

	@RequestMapping("/prodecon")
	public String startProdecon(Model model, @ModelAttribute("resultado") String resultado) {

		List<Prodecon> prodecon = prodeconService.getProdecon();
		model.addAttribute("prodecon", prodecon);
		model.addAttribute(resultado);

		return "inicio-prodecon";
	}

	@RequestMapping("/prodecon/{numero}/modificar")
	public String modifyProdecon(Model model, @PathVariable int numero) {

		Prodecon prodecon = prodeconService.prodeconById(numero);
		LinkedHashMap<String, String> first = nivelesService.firstNivelesToHashMap();
		LinkedHashMap<String, String> delegaciones = delegacionesService.delegacionesToHashMap();
		LinkedHashMap<String, String> tdad = tipoDeAcuerdoDefinitivoService.tipoDeAcuerdoDefinitivoToHashMap();

		LinkedHashMap<String, String> segundoNivel = new LinkedHashMap<>();
		LinkedHashMap<String, String> tercerNivel = new LinkedHashMap<>();
		LinkedHashMap<String, String> subdelegaciones = new LinkedHashMap<>();

		List<String> segundo = nivelesService.secondNivelesToList(prodecon.getPrimerNivel());
		for (String string : segundo) {
			segundoNivel.put(string, string);
		}
		List<String> tercero = nivelesService.thirdNivelesToList(prodecon.getSegundoNivel());
		for (String string : tercero) {
			tercerNivel.put(string, string);
		}
		List<String> subdelegacion = delegacionesService.subdelegacionesToList(prodecon.getDelegacion());
		for (String string : subdelegacion) {
			subdelegaciones.put(string, string);
		}

		model.addAttribute("boton", "Actualizar");
		model.addAttribute("titulo", "Modificar prodecon");

		model.addAttribute("segundoNivel", segundoNivel);
		model.addAttribute("tercerNivel", tercerNivel);
		model.addAttribute("subdelegaciones", subdelegaciones);
		model.addAttribute("tdad", tdad);
		model.addAttribute("delegaciones", delegaciones);
		model.addAttribute("first", first);
		model.addAttribute("prodecon", prodecon);

		return "agregar-prodecon";

	}

	@GetMapping("/prodecon/agregar")
	public String saveProdecon(Model model) {

		Prodecon prodecon = new Prodecon();

		LinkedHashMap<String, String> first = nivelesService.firstNivelesToHashMap();
		List<String> second = nivelesService.secondNivelesToList("PAE");
		List<String> third = nivelesService.thirdNivelesToList("PRESCRIPCION");
		List<String> subdel = delegacionesService.subdelegacionesToList("ESTATAL AGUASCALIENTES");
		LinkedHashMap<String, String> secondhm = new LinkedHashMap<>();
		LinkedHashMap<String, String> thirdhm = new LinkedHashMap<>();
		LinkedHashMap<String, String> subdelhm = new LinkedHashMap<>();
		for(String a : second){
			secondhm.put(a, a);
		}
		for(String a : third)
		{
			thirdhm.put(a, a);
		}
		for(String a : subdel)
		{
			subdelhm.put(a, a);
		}
		LinkedHashMap<String, String> delegaciones = delegacionesService.delegacionesToHashMap();
		LinkedHashMap<String, String> tdad = tipoDeAcuerdoDefinitivoService.tipoDeAcuerdoDefinitivoToHashMap();

		model.addAttribute("boton", "Agregar");
		model.addAttribute("titulo", "Agregar prodecon");

		model.addAttribute("tdad", tdad);
		model.addAttribute("delegaciones", delegaciones);
		model.addAttribute("subdelegaciones", subdelhm);
		model.addAttribute("first", first);
		model.addAttribute("segundoNivel", secondhm);
		model.addAttribute("tercerNivel", thirdhm);
		model.addAttribute("consecutivo", prodeconService.prodeconLastRegister());
		model.addAttribute("prodecon", prodecon);

		return "agregar-prodecon";
	}
	
	@GetMapping("/prodecon/{numero}/subir")
	public String showUploadFiles(Model model, @PathVariable int numero)
	{
		Prodecon prodecon = prodeconService.prodeconById(numero);
		
		return "upload-file";
	}
	
	
	LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;
    
	@PostMapping("/prodecon/{numero}/upload")
	@ResponseBody
	public LinkedList<FileMeta> uploadFiles(MultipartHttpServletRequest request, HttpServletResponse response, @PathVariable int numero) throws IllegalStateException, IOException
	{
		Prodecon prodecon = prodeconService.prodeconById(numero);
		
		//1. build an iterator
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
		
      //2. get each file
        while(itr.hasNext()){

            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next()); 
            System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());

            //2.2 if files > 10 remove the first from the list
            if(files.size() >= 10)
                files.pop();

            //2.3 create new fileMeta
            fileMeta = new FileMeta();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());

            try {
               fileMeta.setBytes(mpf.getBytes());

                // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)            
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream("c:/test/"+mpf.getOriginalFilename()));

           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
            //2.4 add to files
            files.add(fileMeta);
        }
       // result will be like this
       // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
       return files;
	}
	
	@GetMapping("/get/{value}")
	public void get(HttpServletResponse response,@PathVariable String value){
        FileMeta getFile = files.get(Integer.parseInt(value));
        try {      
               response.setContentType(getFile.getFileType());
               response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
               FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
        }catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
    }

	@PostMapping("/prodecon/agregar")
	public String saveProdeconPost(Model model, @ModelAttribute("prodecon") @Valid Prodecon prodecon, BindingResult result,
			RedirectAttributes ra) {

		if (result.hasErrors()) {
			
			LinkedHashMap<String, String> first = nivelesService.firstNivelesToHashMap();
			List<String> second = nivelesService.secondNivelesToList(prodecon.getPrimerNivel());
			List<String> third = nivelesService.thirdNivelesToList(prodecon.getSegundoNivel());			
			LinkedHashMap<String, String> secondhm = new LinkedHashMap<>();
			LinkedHashMap<String, String> thirdhm = new LinkedHashMap<>();
			for(String a : second){
				secondhm.put(a, a);
			}
			for(String a : third)
			{
				thirdhm.put(a, a);
			}
			LinkedHashMap<String, String> delegaciones = delegacionesService.delegacionesToHashMap();
			List<String> subdel = delegacionesService.subdelegacionesToList(prodecon.getDelegacion());
			LinkedHashMap<String, String> subdelhm = new LinkedHashMap<>();
			for(String a : subdel)
			{
				subdelhm.put(a, a);
			}
			LinkedHashMap<String, String> tdad = tipoDeAcuerdoDefinitivoService.tipoDeAcuerdoDefinitivoToHashMap();

			model.addAttribute("boton", "Agregar");
			model.addAttribute("titulo", "Agregar prodecon");

			model.addAttribute("tdad", tdad);
			model.addAttribute("delegaciones", delegaciones);
			model.addAttribute("subdelegaciones", subdelhm);
			model.addAttribute("first", first);
			model.addAttribute("segundoNivel", secondhm);
			model.addAttribute("tercerNivel", thirdhm);
			model.addAttribute("consecutivo", prodeconService.prodeconLastRegister());
			model.addAttribute("prodecon", prodecon);
			
			return "agregar-prodecon";
		}

		try {

			System.out.println("número: " + prodecon.getNumero());
			String quejaDir = prodecon.getQueja();
			quejaDir = quejaDir.replace("\\", "-");
			quejaDir = quejaDir.replace("/", "-");
			quejaDir = quejaDir.replace(":", ".");
			quejaDir = quejaDir.replace(";", ",");
			String promoventeDir = prodecon.getPromovente();
			promoventeDir = promoventeDir.replace("\\", "-");
			promoventeDir = promoventeDir.replace("/", "-");
			promoventeDir = promoventeDir.replace(":", ".");
			promoventeDir = promoventeDir.replace(";", ",");

			Calendar cal = Calendar.getInstance();

			 String nombreCarpeta =
			 "quejas" + "/"
			 + String.valueOf(cal.get(Calendar.YEAR)) + "-"
			 + promoventeDir + "-" + quejaDir + "/";
			
			 

//			String nombreCarpeta = System.getProperty("catalina.base") + File.separator + "webapps" + File.separator
//					+ "quejas" + File.separator + String.valueOf(cal.get(Calendar.YEAR)) + " - " + promoventeDir + " - "
//					+ quejaDir + File.separator;
			
			new FTPUpload(nombreCarpeta);

			nombreCarpeta = URLEncoder.encode(nombreCarpeta, "UTF-8");
			
			prodecon.setDigital("ftp://localhost/"+nombreCarpeta.replace("%2F", "/").replace("+", "%20"));
			

			prodeconService.saveProdecon(prodecon);

			return "redirect:/prodecon";

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ra.addFlashAttribute("resultado", "Error");
			return "redirect:/prodecon";
		}
		

	}


	@RequestMapping(value = "/prodecon/second", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String returnJsonSegundoNivel(Model model, @RequestParam("primero") String primero) {
		System.out.println("primero: " + primero);

		List<String> solicitudes = nivelesService.secondNivelesToList(primero);
		Set<String> uniqueSolicitudes = new HashSet<String>(solicitudes);
		String json = new Gson().toJson(uniqueSolicitudes);

		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "/prodecon/third", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String returnJsonTercerNivel(Model model, @RequestParam("segundo") String segundo) {
		System.out.println("segundo: " + segundo);

		List<String> solicitudes = nivelesService.thirdNivelesToList(segundo);
		Set<String> uniqueSolicitudes = new HashSet<String>(solicitudes);
		String json = new Gson().toJson(uniqueSolicitudes);

		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "/prodecon/delegaciones", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String returnJsonSubdelegaciones(Model model, @RequestParam("delegaciones") String delegaciones) {
		System.out.println("delegaciones: " + delegaciones);

		List<String> solicitudes = delegacionesService.subdelegacionesToList(delegaciones);
		Set<String> uniqueSolicitudes = new HashSet<String>(solicitudes);
		String json = new Gson().toJson(uniqueSolicitudes);

		System.out.println(json);
		return json;
	}

	@RequestMapping("/prodecon/{numero}/archivos")
	public String filesProdecon(Model model, @PathVariable int numero) {

		Prodecon prodecon = prodeconService.prodeconById(numero);		
		model.addAttribute("prodecon", prodecon);
		return "file-show";
	}

	@RequestMapping("/prodecon/reportes")
	public String showReportesProdecon(Model model) {

		return "pendientes-prodecon";
	}

	@RequestMapping(value = "/prodecon/reporte", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String reporteProdecon(Model model, @RequestParam("inicial") String inicial, @RequestParam("fin") String fin,
			@RequestParam("pendiente") String pendiente) {

		List<Prodecon> prodecon;
		if (pendiente.equals("")) {
			prodecon = prodeconService.prodeconBetweenDates(inicial, fin);
		} else {
			prodecon = prodeconService.prodeconBetweenDatesPendientes(inicial, fin);
		}

		String json = new Gson().toJson(prodecon);
		System.out.println(json);

		return json;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	
	
}
