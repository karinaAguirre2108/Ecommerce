package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@PostMapping("/guardar")
	public String guardar(Categoria categoria){
		categoriaService.save(categoria);
		return "redirect:/categoria";
	}
}
