package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.model.Imagen;
import com.ecommerce.model.Producto;
import com.ecommerce.service.ICategoriaService;
import com.ecommerce.service.IProductoService;
import com.ecommerce.service.IProveedorService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private IProveedorService proveedorService;
	
	@Autowired
	private IProductoService productoService;
		
	@GetMapping("")
	public String listar(Model model) {
		model.addAttribute("producto",productoService.getAllProducto());
	//	model.addAttribute("categoria",categoriaService.getAllCategoria());
	//	model.addAttribute("proveedor", proveedorService.getAllProveedor());
		return "producto/listar";
	}
	
	@GetMapping("/registrar")
	public String registrar( Model model) {
		model.addAttribute("categoria",categoriaService.getAllCategoria());
		model.addAttribute("proveedor", proveedorService.getAllProveedor());
		return "producto/registrar";
	}
	
	@PostMapping("/guardar")
	public String guardar(Producto producto,@RequestParam("imagenes")List<MultipartFile>imagenes,RedirectAttributes attribute) throws IOException{
		
		for (MultipartFile imagenMultipartFile : imagenes) {
			Imagen newImagen = new Imagen();
			newImagen.setArchivoImagen(imagenMultipartFile.getOriginalFilename());
			newImagen.setProducto(producto);
			producto.getImagenesProducto().add(newImagen);
		}		
		productoService.save(producto);
		attribute.addFlashAttribute("guardar", "Datos guardados con éxito!");
		return "redirect:/producto";
	}
	
	@GetMapping("/eliminar/{idProducto}")
	public String eliminar(@PathVariable Integer idProducto, RedirectAttributes attribute) {
		productoService.delete(idProducto);
		attribute.addFlashAttribute("eliminar", "Eliminado con éxito!");
		return "redirect:/producto";
	}
	
}
