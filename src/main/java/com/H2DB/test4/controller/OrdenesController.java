package com.H2DB.test4.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.H2DB.test4.dto.OrdenesDto;
import com.H2DB.test4.dto.ProductoDto;
import com.H2DB.test4.entity.Ordenes;
import com.H2DB.test4.service.OrdenesServiceImpl;

@RestController
@RequestMapping("/ordenes/*")
public class OrdenesController {
	
	@Autowired
	private OrdenesServiceImpl ordenesServiceImpl;
	
	@GetMapping("{id}")
	public ResponseEntity<Ordenes> getById(@PathVariable Integer id){		
		Optional<Ordenes> ordenesOptional = ordenesServiceImpl.getById(id);
		if(ordenesOptional.isPresent()) {
			return ResponseEntity.ok(ordenesOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody OrdenesDto item){		
		StringBuilder errorMessage = new StringBuilder();
		
		if(item.getSucursalId() == null) {
			errorMessage.append("La sucursal no puede ser nula");
		}
		if(item.getProductos().isEmpty()) {
			errorMessage.append("La lista de productos no puede ser nula");
		}
		
		if(errorMessage.length() > 0) {
			return ResponseEntity.badRequest().body(errorMessage.toString());
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(ordenesServiceImpl.save(item));	
		}
	}
	
	@PutMapping("/productos/{codigo}/precio/")
	public ResponseEntity<?> actualizarPrecio(@RequestBody ProductoDto item, @PathVariable String codigo){
		if(item.getPrecio() == null) {
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("El precio no puede ser nulo");
			return ResponseEntity.badRequest().body(errorMessage.toString());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(ordenesServiceImpl.actualizarPrecioProducto(codigo, item.getPrecio()));
	}
}
