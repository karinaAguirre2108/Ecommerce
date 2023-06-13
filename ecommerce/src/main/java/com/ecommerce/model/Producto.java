package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String nombreProducto;
	private String descripcionProducto;
	private String imagenProducto;
	private double precioCostoProducto;
	private double precioVentaProducto;
	private int stockProducto;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Proveedor proveedor;
	 
	public Producto() {
		
	}

	public Producto(Integer idProducto, String nombreProducto, String descripcionProducto, String imagenProducto,
			double precioCostoProducto, double precioVentaProducto, int stockProducto, Usuario usuario,
			Categoria categoria, Proveedor proveedor) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.imagenProducto = imagenProducto;
		this.precioCostoProducto = precioCostoProducto;
		this.precioVentaProducto = precioVentaProducto;
		this.stockProducto = stockProducto;
		this.usuario = usuario;
		this.categoria = categoria;
		this.proveedor = proveedor;
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

	public String getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
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

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcionProducto="
				+ descripcionProducto + ", imagenProducto=" + imagenProducto + ", precioCostoProducto="
				+ precioCostoProducto + ", precioVentaProducto=" + precioVentaProducto + ", stockProducto="
				+ stockProducto + ", usuario=" + usuario + ", categoria=" + categoria + ", proveedor=" + proveedor
				+ "]";
	}
		
	
}
