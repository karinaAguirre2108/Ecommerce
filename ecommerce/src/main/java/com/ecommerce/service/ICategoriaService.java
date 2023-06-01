package com.ecommerce.service;

import java.util.Optional;

import com.ecommerce.model.Categoria;

public interface ICategoriaService {
	
	public Categoria save(Categoria categoria);
	public Optional<Categoria> get (Integer id);
	public void update(Categoria categoria);
	public void delete (Integer id);

}
