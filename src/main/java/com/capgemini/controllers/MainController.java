package com.capgemini.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capgemini.entities.Empleado;
import com.capgemini.service.IEmpleadoService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	
	@GetMapping("/formulario")
	public String fileUploadForm(Model model) {
		
		model.addAttribute("empleado", new Empleado());
		
		return "fileUploadForm";
	}
	
	@PostMapping("/formhandler")
	public String fileUploadFormHandler(@RequestParam(name = "file", required = false) MultipartFile foto, 
										Empleado empleado, RedirectAttributes mensajeFlash) {
		
		if (!foto.isEmpty()) {
			// Ruta donde se va a almacenar el archivo subido
			String ruta = "/home/curso/temp/uploads";
			
			try {
				byte[] bytes = foto.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "/" + foto.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				empleado.setFoto(foto.getOriginalFilename());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			empleadoService.save(empleado);
			mensajeFlash.addFlashAttribute("success");
		}
		
		return "redirect:/formulario";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("empleados", empleadoService.getEmpleados());
		
		return "listar";
	}
	

}
