package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "detalleOrden")
public class DetalleOrden {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idDetalleOrden;
	private String nombreDetalleOrden;
	private int cantidadDetalleOrden;
	private double precioDetalleOrden;
	private double totalDetalleOrden;
	
	@OneToOne
	private Orden orden;
	
	@OneToOne
	private Producto producto;
	
	public DetalleOrden() {
		
	}
	public DetalleOrden(Integer idDetalleOrden, String nombreDetalleOrden, int cantidadDetalleOrden,
			double precioDetalleOrden, double totalDetalleOrden) {
		super();
		this.idDetalleOrden = idDetalleOrden;
		this.nombreDetalleOrden = nombreDetalleOrden;
		this.cantidadDetalleOrden = cantidadDetalleOrden;
		this.precioDetalleOrden = precioDetalleOrden;
		this.totalDetalleOrden = totalDetalleOrden;
	}
	public Integer getIdDetalleOrden() {
		return idDetalleOrden;
	}
	public void setIdDetalleOrden(Integer idDetalleOrden) {
		this.idDetalleOrden = idDetalleOrden;
	}
	public String getNombreDetalleOrden() {
		return nombreDetalleOrden;
	}
	public void setNombreDetalleOrden(String nombreDetalleOrden) {
		this.nombreDetalleOrden = nombreDetalleOrden;
	}
	public int getCantidadDetalleOrden() {
		return cantidadDetalleOrden;
	}
	public void setCantidadDetalleOrden(int cantidadDetalleOrden) {
		this.cantidadDetalleOrden = cantidadDetalleOrden;
	}
	public double getPrecioDetalleOrden() {
		return precioDetalleOrden;
	}
	public void setPrecioDetalleOrden(double precioDetalleOrden) {
		this.precioDetalleOrden = precioDetalleOrden;
	}
	public double getTotalDetalleOrden() {
		return totalDetalleOrden;
	}
	public void setTotalDetalleOrden(double totalDetalleOrden) {
		this.totalDetalleOrden = totalDetalleOrden;
	}
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Override
	public String toString() {
		return "DetalleOrden [idDetalleOrden=" + idDetalleOrden + ", nombreDetalleOrden=" + nombreDetalleOrden
				+ ", cantidadDetalleOrden=" + cantidadDetalleOrden + ", precioDetalleOrden=" + precioDetalleOrden
				+ ", totalDetalleOrden=" + totalDetalleOrden + "]";
	}
}
