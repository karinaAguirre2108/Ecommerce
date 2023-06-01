package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
