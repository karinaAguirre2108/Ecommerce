package com.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.model.Categoria;
import com.ecommerce.model.Proveedor;
import com.ecommerce.service.IProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("")
	public String listar(Model model){
		model.addAttribute("proveedor", proveedorService.getAllProveedor());
		return "proveedor/listar";
	}
	
	@GetMapping("/registrar")
	public String registrar() {
		return "proveedor/registrar";
	}
	
	@PostMapping("/guardar")
	public String guardar(Proveedor proveedor, RedirectAttributes attribute){
		proveedorService.save(proveedor);
		attribute.addFlashAttribute("success", "Datos guardados con éxito!");
		return "redirect:/proveedor";
	}
	
	@GetMapping("/editar/{idProveedor}")
	public String editar(@PathVariable Integer idProveedor, Model model) {
		Proveedor proveedor= new Proveedor();
		Optional<Proveedor> optionalProveedor= proveedorService.get(idProveedor);
		proveedor = optionalProveedor.get();	
		model.addAttribute("proveedor", proveedor);		
		return "proveedor/editar";
	}
	
	@PostMapping("/actualizar")
	public String update(Proveedor proveedor, RedirectAttributes attribute){
		proveedorService.update(proveedor);
		attribute.addFlashAttribute("editar", "Datos actualizados con éxito!");
		return "redirect:/proveedor";
	}
	
	@GetMapping("/eliminar/{idProveedor}")
	public String eliminar(@PathVariable Integer idProveedor, RedirectAttributes attribute) {
		proveedorService.delete(idProveedor);
		attribute.addFlashAttribute("eliminar", "Eliminado con éxito!");
		return "redirect:/proveedor";
	}
	
	
}
