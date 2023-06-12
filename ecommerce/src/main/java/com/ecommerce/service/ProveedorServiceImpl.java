package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Proveedor;
import com.ecommerce.repository.IProveedorRepository;

@Service
public class ProveedorServiceImpl implements IProveedorService{
	
	@Autowired
	private IProveedorRepository proveedorRepository;
	
	@Override
	public Proveedor save(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public Optional<Proveedor> get(Integer id) {
		return proveedorRepository.findById(id);
	}

	@Override
	public void update(Proveedor proveedor) {
		proveedorRepository.save(proveedor);		
	}

	@Override
	public void delete(Integer id) {
		proveedorRepository.deleteById(id);
	}

	@Override
	public List<Proveedor> getAllProveedor() {
		return proveedorRepository.findAllByOrderByMarcaProveedorAsc();
	}

}
