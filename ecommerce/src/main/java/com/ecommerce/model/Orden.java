package com.ecommerce.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenes")
public class Orden {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idOrden;
	private Integer numeroOrden;
	private Date fechaCreacionOrden;
	private Date fechaRecibidaOrden;
	private double totalOrden;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToOne (mappedBy = "orden")
	private DetalleOrden detalle;
	
	public Orden() {
		
	}
	public Orden(Integer idOrden, Integer numeroOrden, Date fechaCreacionOrden, Date fechaRecibidaOrden,
			double totalOrden) {
		super();
		this.idOrden = idOrden;
		this.numeroOrden = numeroOrden;
		this.fechaCreacionOrden = fechaCreacionOrden;
		this.fechaRecibidaOrden = fechaRecibidaOrden;
		this.totalOrden = totalOrden;
	}
	public Integer getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}
	public Integer getNumeroOrden() {
		return numeroOrden;
	}
	public void setNumeroOrden(Integer numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public Date getFechaCreacionOrden() {
		return fechaCreacionOrden;
	}
	public void setFechaCreacionOrden(Date fechaCreacionOrden) {
		this.fechaCreacionOrden = fechaCreacionOrden;
	}
	public Date getFechaRecibidaOrden() {
		return fechaRecibidaOrden;
	}
	public void setFechaRecibidaOrden(Date fechaRecibidaOrden) {
		this.fechaRecibidaOrden = fechaRecibidaOrden;
	}
	public double getTotalOrden() {
		return totalOrden;
	}
	public void setTotalOrden(double totalOrden) {
		this.totalOrden = totalOrden;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public DetalleOrden getDetalle() {
		return detalle;
	}
	public void setDetalle(DetalleOrden detalle) {
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", numeroOrden=" + numeroOrden + ", fechaCreacionOrden="
				+ fechaCreacionOrden + ", fechaRecibidaOrden=" + fechaRecibidaOrden + ", totalOrden=" + totalOrden
				+ "]";
	}
	
}
