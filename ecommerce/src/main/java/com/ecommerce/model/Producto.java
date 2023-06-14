package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String nombreProducto;
	private String descripcionProducto;
	private double precioCostoProducto;
	private double precioVentaProducto;
	private int stockProducto;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Proveedor proveedor;
	
	@OneToMany (cascade = CascadeType.ALL ,mappedBy = "producto", orphanRemoval = true)
	private List<Imagen> imagenesProducto;
	
	public Producto() {
        this.imagenesProducto = new ArrayList<>();
    }
	

	public Producto(Integer idProducto, String nombreProducto, String descripcionProducto, double precioCostoProducto,
			double precioVentaProducto, int stockProducto, Usuario usuario, Categoria categoria, Proveedor proveedor,
			List<Imagen> imagenesProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioCostoProducto = precioCostoProducto;
		this.precioVentaProducto = precioVentaProducto;
		this.stockProducto = stockProducto;
		this.usuario = usuario;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.imagenesProducto = imagenesProducto;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public double getPrecioCostoProducto() {
		return precioCostoProducto;
	}

	public void setPrecioCostoProducto(double precioCostoProducto) {
		this.precioCostoProducto = precioCostoProducto;
	}

	public double getPrecioVentaProducto() {
		return precioVentaProducto;
	}

	public void setPrecioVentaProducto(double precioVentaProducto) {
		this.precioVentaProducto = precioVentaProducto;
	}

	public int getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Imagen> getImagenesProducto() {
		return imagenesProducto;
	}

	public void setImagenesProducto(List<Imagen> imagenesProducto) {
		this.imagenesProducto = imagenesProducto;
	}

	
		
	
}
