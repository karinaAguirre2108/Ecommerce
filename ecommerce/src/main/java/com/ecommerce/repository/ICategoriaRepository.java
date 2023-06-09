package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

	public List<Categoria>findAllByOrderByNombreCategoriaAsc();
}
