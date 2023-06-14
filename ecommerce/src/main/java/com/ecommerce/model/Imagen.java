package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "imagenes")
public class Imagen {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idImagen;
	private String archivoImagen;
	
	@ManyToOne
	private Producto producto;

	public Imagen() {
		
	}

	public Imagen(Integer idImagen, String archivoImagen, Producto producto) {
		super();
		this.idImagen = idImagen;
		this.archivoImagen = archivoImagen;
		this.producto = producto;
	}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}

	public String getArchivoImagen() {
		return archivoImagen;
	}

	public void setArchivoImagen(String archivoImagen) {
		this.archivoImagen = archivoImagen;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
