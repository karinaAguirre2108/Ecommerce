package com.ecommerce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.model.Imagen;
import com.ecommerce.model.Producto;
import com.ecommerce.model.Proveedor;
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
		model.addAttribute("producto", productoService.getAllProducto());
		return "producto/listar";
	}

	@GetMapping("/registrar")
	public String registrar(Model model) {
		model.addAttribute("categoria", categoriaService.getAllCategoria());
		model.addAttribute("proveedor", proveedorService.getAllProveedor());
		return "producto/registrar";
	}

	@PostMapping("/guardar")
	public String guardar(Producto producto, @RequestParam("imagenes") List<MultipartFile> imagenes,
			RedirectAttributes attribute) {

		if (!imagenes.isEmpty()) {
			String rutaAbsoluta = "D://Ecommerce//imagenesProducto";

			for (MultipartFile imagen : imagenes) {
				try {
					byte[] bytesImagen = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImagen);
					Imagen nuevaImagen = new Imagen();
					nuevaImagen.setArchivoImagen(imagen.getOriginalFilename());
					nuevaImagen.setProducto(producto);
					producto.getImagenesProducto().add(nuevaImagen);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		productoService.save(producto);
		attribute.addFlashAttribute("guardar", "Datos guardados con éxito!");
		return "redirect:/producto";
	}

	@GetMapping("/editar/{idProducto}")
	public String editar(@PathVariable Integer idProducto, Model model) {
		Optional<Producto> optionalProducto = productoService.get(idProducto);
		if (optionalProducto.isPresent()) {
			Producto producto = optionalProducto.get();
			List<Imagen> imagenes = producto.getImagenesProducto();
			model.addAttribute("producto", producto);
			model.addAttribute("imagenes", imagenes);
			model.addAttribute("categoria", categoriaService.getAllCategoria());
			model.addAttribute("proveedor", proveedorService.getAllProveedor());
			return "producto/editar";
		} else {
			// Manejar el caso en el que el producto no existe
			return "redirect:/producto";
		}
	}

	@PostMapping("/actualizar")
	public String update(Producto producto,
			@RequestParam(value = "nuevasImagenes", required = false) List<MultipartFile> nuevasImagenes,
			RedirectAttributes attribute) {

		// Comprobando tamaño y contenido de la lista multipartfile
		if (nuevasImagenes.size() == 1 && (nuevasImagenes.get(0).isEmpty() || nuevasImagenes.get(0) == null)) {
			nuevasImagenes.removeAll(nuevasImagenes);
		}

		// Obtener el producto existente desde la base de datos
		Producto productoExistente = productoService.get(producto.getIdProducto()).orElse(null);

		if (productoExistente != null) {
			// Manejar el caso en el que el producto existe

			// Ruta absoluta donde se guardarán las imágenes
			String rutaAbsoluta = "D://Ecommerce//imagenesProducto";

			List<Imagen> imagenesExistentes = productoExistente.getImagenesProducto();
			producto.getImagenesProducto().addAll(imagenesExistentes);

			// Verificar si se seleccionaron nuevas imágenes
			if (!nuevasImagenes.isEmpty()) {
				for (Imagen imagen : imagenesExistentes) {
					try {
						Path rutaImagen = Paths.get(rutaAbsoluta + "//" + imagen.getArchivoImagen());
						Files.deleteIfExists(rutaImagen);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} // Eliminar las imágenes existentes asociadas al producto
				producto.getImagenesProducto().clear();

				// Procesar y guardar las nuevas imágenes
				for (MultipartFile nuevaImagen : nuevasImagenes) {
					try {
						byte[] bytesImagen = nuevaImagen.getBytes();
						Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nuevaImagen.getOriginalFilename());
						Files.write(rutaCompleta, bytesImagen);
						Imagen nuevaImagenProducto = new Imagen();
						nuevaImagenProducto.setArchivoImagen(nuevaImagen.getOriginalFilename());
						nuevaImagenProducto.setProducto(producto);
						producto.getImagenesProducto().add(nuevaImagenProducto);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			// Guardar el producto actualizado en la base de datos
			productoService.update(producto);
			attribute.addFlashAttribute("editar", "Datos actualizados con éxito!");
		}

		return "redirect:/producto";
	}

	@GetMapping("/eliminar/{idProducto}")
	public String eliminar(@PathVariable Integer idProducto, RedirectAttributes attribute) {
		Optional<Producto> optionalProducto = productoService.get(idProducto);
		if (optionalProducto.isPresent()) {
			Producto producto = optionalProducto.get();
			List<Imagen> imagenes = producto.getImagenesProducto();

			// Ruta absoluta donde se guardan las imágenes
			String rutaAbsoluta = "D://Ecommerce//imagenesProducto";

			// Eliminar físicamente las imágenes
			for (Imagen imagen : imagenes) {
				try {
					Path rutaImagen = Paths.get(rutaAbsoluta + "//" + imagen.getArchivoImagen());
					Files.deleteIfExists(rutaImagen);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			productoService.delete(idProducto);
			attribute.addFlashAttribute("eliminar", "Eliminado con éxito!");
		}

		return "redirect:/producto";
	}

}
