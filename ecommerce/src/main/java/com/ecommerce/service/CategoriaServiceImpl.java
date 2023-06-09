package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Categoria;
import com.ecommerce.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
	
	@Autowired
	private ICategoriaRepository categoriaRepository;

	@Override
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Optional<Categoria> get(Integer id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public void update(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public void delete(Integer id) {
		categoriaRepository.deleteById(id);
	}

	@Override
	public List<Categoria> getAllCategoria() {
		return categoriaRepository.findAllByOrderByNombreCategoriaAsc();
	}
	
}
