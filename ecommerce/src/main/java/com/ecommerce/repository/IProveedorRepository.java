package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {

	public List<Proveedor>findAllByOrderByMarcaProveedorAsc();
}
