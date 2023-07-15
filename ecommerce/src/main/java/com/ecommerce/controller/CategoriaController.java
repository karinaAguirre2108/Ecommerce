package com.ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

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


import com.ecommerce.model.Categoria;
import com.ecommerce.model.Imagen;
import com.ecommerce.service.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping("")
	public String listar(Model model) {
		model.addAttribute("categoria", categoriaService.getAllCategoria());
		return "categoria/listar";
	}

	@GetMapping("/registrar")
	public String registrar() {
		return "categoria/registrar";
	}

	@PostMapping("/guardar")
	public String guardar(Categoria categoria,@RequestParam("imagenes") MultipartFile imagenes, RedirectAttributes attribute) {
		
		if (!imagenes.isEmpty()) {
			String rutaAbsoluta = "D://Ecommerce//imagenesCategoria";
			
				try {
					byte[] bytesImagen = imagenes.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagenes.getOriginalFilename());
					Files.write(rutaCompleta, bytesImagen);
					Imagen nuevaImagen = new Imagen();
					nuevaImagen.setArchivoImagen(imagenes.getOriginalFilename());
					nuevaImagen.setCategoria(categoria);
					categoria.setImagenCategoria(nuevaImagen);
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		
		categoriaService.save(categoria);
		attribute.addFlashAttribute("guardar", "Datos guardados con éxito!");
		return "redirect:/categoria";
	}

	@GetMapping("/editar/{idCategoria}")
	public String editar(@PathVariable Integer idCategoria, Model model) {	
		Optional<Categoria> optionalCategoria = categoriaService.get(idCategoria);
		if(optionalCategoria.isPresent()) {
			Categoria categoria = optionalCategoria.get();
			Imagen imagen = categoria.getImagenCategoria();
			model.addAttribute("categoria", categoria);
			model.addAttribute("imagenes", imagen);
			return "categoria/editar";
		}else {
			return "redirect:/categoria";
		}
		
		
	}

	@PostMapping("/actualizar")
	public String update(Categoria categoria, RedirectAttributes attribute) {
		categoriaService.update(categoria);
		attribute.addFlashAttribute("editar", "Datos actualizados con éxito!");
		return "redirect:/categoria";
	}

	@GetMapping("/eliminar/{idCategoria}")
	public String eliminar(@PathVariable Integer idCategoria, RedirectAttributes attribute) {
		Optional<Categoria> optionalCategoria =categoriaService.get(idCategoria);
		if(optionalCategoria.isPresent()) {
			Categoria categoria = optionalCategoria.get();
			Imagen imagen = categoria.getImagenCategoria();
			
			// Ruta absoluta donde se guardan las imágenes
			String rutaAbsoluta = "D://Ecommerce//imagenesCategoria";
			
			//Eliminar físicamente las imágenes
			
			try {
				Path rutaImagen = Paths.get(rutaAbsoluta+"//"+imagen.getArchivoImagen());
				Files.deleteIfExists(rutaImagen);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		categoriaService.delete(idCategoria);
		attribute.addFlashAttribute("eliminar", "Eliminado con éxito!");
		return "redirect:/categoria";
	}

}