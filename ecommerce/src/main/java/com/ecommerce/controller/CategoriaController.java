package com.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ecommerce.model.Categoria;
import com.ecommerce.service.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
		
	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("")
	public String listar(Model model){
		model.addAttribute("categoria", categoriaService.getAllCategoria());
		return "categoria/listar";
	}
	
	@GetMapping("/registrar")
	public String registrar() {
		return "categoria/registrar";
	}
	
	@PostMapping("/guardar")
	public String guardar(Categoria categoria){
		categoriaService.save(categoria);
		return "redirect:/categoria";
	}
	
	@GetMapping("/editar/{idCategoria}")
	public String editar(@PathVariable Integer idCategoria, Model model) {
		Categoria categoria= new Categoria();
		Optional<Categoria> optionalCategoria= categoriaService.get(idCategoria);
		categoria = optionalCategoria.get();	
		model.addAttribute("categoria", categoria);		
		return "categoria/editar";
	}
	
	@PostMapping("/actualizar")
	public String update(Categoria categoria){
		categoriaService.update(categoria);
		return "redirect:/categoria";
	}
	
	@GetMapping("/eliminar/{idCategoria}")
	public String eliminar(@PathVariable Integer idCategoria) {
		categoriaService.delete(idCategoria);
		return "redirect:/categoria";
	}
	
}
