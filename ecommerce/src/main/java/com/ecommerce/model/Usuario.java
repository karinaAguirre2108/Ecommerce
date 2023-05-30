package com.ecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nombresUsuario;
	private String apellidosUsuario;
	private String direccionUsuario;
	private String telefonoUsuario;
	private String tipoUsuario;
	private String correoUsuario;
	private String contrasenaUsuario;
	
	@OneToMany (mappedBy = "usuario")
	private List<Producto> productosUsuario;
	
	@OneToMany (mappedBy = "usuario")
	private List<Orden> ordenes;
	
	public Usuario() {
		
	}
	public Usuario(Integer idUsuario, String nombresUsuario, String apellidosUsuario, String direccionUsuario,
			String telefonoUsuario, String tipoUsuario, String correoUsuario, String contrasenaUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombresUsuario = nombresUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.direccionUsuario = direccionUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoUsuario = tipoUsuario;
		this.correoUsuario = correoUsuario;
		this.contrasenaUsuario = contrasenaUsuario;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombresUsuario() {
		return nombresUsuario;
	}
	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}
	public String getApellidosUsuario() {
		return apellidosUsuario;
	}
	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}
	public String getDireccionUsuario() {
		return direccionUsuario;
	}
	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}
	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}
	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}	
	public List<Producto> getProductosUsuario() {
		return productosUsuario;
	}
	public void setProductosUsuario(List<Producto> productosUsuario) {
		this.productosUsuario = productosUsuario;
	}
	public List<Orden> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombresUsuario=" + nombresUsuario + ", apellidosUsuario="
				+ apellidosUsuario + ", direccionUsuario=" + direccionUsuario + ", telefonoUsuario=" + telefonoUsuario
				+ ", tipoUsuario=" + tipoUsuario + ", correoUsuario=" + correoUsuario + ", contrasenaUsuario="
				+ contrasenaUsuario + "]";
	}
	
}
