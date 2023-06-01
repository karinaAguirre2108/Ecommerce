package com.ecommerce.service;

import java.util.Optional;

import com.ecommerce.model.Proveedor;

public interface IProveedorService {
	
	public Proveedor save(Proveedor proveedor);
	public Optional<Proveedor> get(Integer id);
	public void update(Proveedor proveedor);
	public void delete(Integer id);
}
