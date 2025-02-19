package com.H2DB.test4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.H2DB.test4.dto.OrdenesDto;
import com.H2DB.test4.entity.Ordenes;
import com.H2DB.test4.entity.Productos;
import com.H2DB.test4.entity.Sucursales;
import com.H2DB.test4.exception.ResourceNotFoundException;
import com.H2DB.test4.repository.OrdenesRepository;
import com.H2DB.test4.repository.ProductosRepository;
import com.H2DB.test4.repository.SucursalesRepository;

@Service
public class OrdenesServiceImpl implements IService <Ordenes>{

	@Autowired
	private OrdenesRepository ordenesRepository;
	
	@Autowired
	private ProductosRepository productosRepository;
	
	@Autowired
	private SucursalesRepository sucursalesRepository;
	
	@Override
	public List<Ordenes> getAll() {
		return ordenesRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Ordenes> getById(int id) {
		return ordenesRepository.findById(id);
	}

	@Transactional
	@Override
	public Ordenes save(Ordenes item) {
		return ordenesRepository.save(item);
	}
	
	@Transactional
	public Ordenes save(OrdenesDto item) {
		Sucursales sucursales = sucursalesRepository.findById(item.getSucursalId()).orElseThrow(() -> new ResourceNotFoundException("Sucursal"));
		Ordenes ordenesDb =  new Ordenes();
		ordenesDb.setSucursalId(sucursales);
		ordenesDb.setFecha(item.getFecha());
		ordenesDb.setTotal(item.getTotal());
		ordenesDb.setProductos(new ArrayList<>());
		ordenesDb = ordenesRepository.save(ordenesDb);
		
		for(Productos producto : item.getProductos()) {
			producto.setOrdenId(ordenesDb);
			productosRepository.save(producto);
			ordenesDb.getProductos().add(producto);
		}
		return ordenesRepository.save(ordenesDb);
	}
	
	@Transactional
	public Productos actualizarPrecioProducto(String codigo, Double precio) {
		Optional<Productos> productosOptional = productosRepository.findByCodigo(codigo);
		if(productosOptional.isPresent()) {
			Productos productosDb = productosOptional.orElseThrow();
			productosDb.setPrecio(precio);
			return productosRepository.save(productosDb);
		}
		return null;
	}
}
