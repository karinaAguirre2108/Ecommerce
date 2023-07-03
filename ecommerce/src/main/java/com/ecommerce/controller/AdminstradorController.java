package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.model.Categoria;
import com.ecommerce.model.Imagen;
import com.ecommerce.model.Producto;
import com.ecommerce.service.ICategoriaService;
import com.ecommerce.service.IProductoService;

@Controller
@RequestMapping("/administrador")
public class AdminstradorController {
	
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("")
	public String home(Model model) {
		List<Producto> productos=productoService.getAllProducto();
		model.addAttribute("productos", productos);
		return "administrador/home";
	}

}
