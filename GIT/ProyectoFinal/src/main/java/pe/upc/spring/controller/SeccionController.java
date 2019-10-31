package pe.upc.spring.controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.upc.spring.model.Seccion;
import pe.upc.spring.service.ISeccionService;

@Controller
@RequestMapping("/seccion")
public class SeccionController {
	
	@Autowired
	private ISeccionService sService;
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaSeccion", sService.listar());
		return "listSeccion";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("seccion", new Seccion());
		return "seccion";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Seccion seccion, BindingResult binRes, Model model) 
	throws ParseException{
		if(binRes.hasErrors())
			return "seccion";
		else {
			boolean flag=sService.insertar(seccion);
			if(flag)
				return "redirect:/seccion/listar";
			else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/seccion/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Seccion seccion, BindingResult binRes, Model model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors())
			return "redirect://seccion/listar";
		else {
			boolean flag=sService.modificar(seccion);
			if(flag) {
				objRedir.addFlashAttribute("mensaje", "Se modificó correctamente");
				return "redirect:/seccion/listar";
				
			}
			else {
				objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
				return "redirect:/seccion/irRegistrar";
			}
		}
	}
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable Long id,Model model, RedirectAttributes objRedir) 
	throws ParseException{
		Optional<Seccion>objSeccion=sService.buscarId(id);
		if(objSeccion==null)
			{
			objRedir.addFlashAttribute("mensaje","Ocurrió un error");
			return "redirect://seccion/listar";
			}
		else {
			model.addAttribute("seccion", objSeccion);
			return "listSeccion";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id")Long id) {
		try {
			if(id!=null&&id>0)
			{
				sService.eliminar(id);
				model.put("listaSeccion", sService.listar());
			}
		}catch(Exception e) {
			model.put("mensaje", "Ocurrió un error");
			System.out.println(e.getMessage());
			model.put("listaSeccion", sService.listar());
		}
		
		return "listSeccion";
	}
}
