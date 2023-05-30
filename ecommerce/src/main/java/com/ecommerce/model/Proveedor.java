package com.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "proveedores")
public class Proveedor {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idProveedor;
	private String razonSocialProveedor;
	private String rucProveedor;
	private String marcaProveedor;	
	private String telefonoProveedor;
	private String direccionProveedor;
	private String correoProveedor;
	
	@OneToMany (mappedBy = "proveedor")
	private List<Producto> productosProveedor;
	
	public Proveedor() {
		
	}
	public Proveedor(Integer idProveedor, String razonSocialProveedor, String rucProveedor, String marcaProveedor,
			String telefonoProveedor, String direccionProveedor, String correoProveedor) {
		super();
		this.idProveedor = idProveedor;
		this.razonSocialProveedor = razonSocialProveedor;
		this.rucProveedor = rucProveedor;
		this.marcaProveedor = marcaProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.direccionProveedor = direccionProveedor;
		this.correoProveedor = correoProveedor;
	}
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}
	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}
	public String getRucProveedor() {
		return rucProveedor;
	}
	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}
	public String getMarcaProveedor() {
		return marcaProveedor;
	}
	public void setMarcaProveedor(String marcaProveedor) {
		this.marcaProveedor = marcaProveedor;
	}
	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}
	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}
	public String getDireccionProveedor() {
		return direccionProveedor;
	}
	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}
	public String getCorreoProveedor() {
		return correoProveedor;
	}
	public void setCorreoProveedor(String correoProveedor) {
		this.correoProveedor = correoProveedor;
	}
	public List<Producto> getProductosProveedor() {
		return productosProveedor;
	}
	public void setProductosProveedor(List<Producto> productosProveedor) {
		this.productosProveedor = productosProveedor;
	}
	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", razonSocialProveedor=" + razonSocialProveedor
				+ ", rucProveedor=" + rucProveedor + ", marcaProveedor=" + marcaProveedor + ", telefonoProveedor="
				+ telefonoProveedor + ", direccionProveedor=" + direccionProveedor + ", correoProveedor="
				+ correoProveedor + "]";
	}
	
}
