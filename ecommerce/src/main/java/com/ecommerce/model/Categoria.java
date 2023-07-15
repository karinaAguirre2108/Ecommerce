package com.ecommerce.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	private String nombreCategoria;
	
	@OneToMany(mappedBy = "categoria")
	private List<Producto> productosCategoria;

	@OneToOne (cascade = CascadeType.ALL ,mappedBy = "categoria", orphanRemoval = true)
	private Imagen imagenCategoria;
	
	public Categoria() {

	}

	public Categoria(Integer idCategoria, String nombreCategoria, List<Producto> productosCategoria,
			Imagen imagenCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.productosCategoria = productosCategoria;
		this.imagenCategoria = imagenCategoria;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<Producto> getProductosCategoria() {
		return productosCategoria;
	}

	public void setProductosCategoria(List<Producto> productosCategoria) {
		this.productosCategoria = productosCategoria;
	}

	public Imagen getImagenCategoria() {
		return imagenCategoria;
	}

	public void setImagenCategoria(Imagen imagenCategoria) {
		this.imagenCategoria = imagenCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria
				+ ", productosCategoria=" + productosCategoria + ", imagenCategoria=" + imagenCategoria + "]";
	}
	
	
}
