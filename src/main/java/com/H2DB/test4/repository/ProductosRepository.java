package com.H2DB.test4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2DB.test4.entity.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Integer>{
	Optional<Productos> findByCodigo(String codigo);
}
