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

import com.H2DB.test4.entity.Ordenes;
import com.H2DB.test4.entity.OrdenesDto;
import com.H2DB.test4.entity.Sucursales;
import com.H2DB.test4.service.OrdenesServiceImpl;
import com.H2DB.test4.service.SucursalServiceImpl;

@RestController
@RequestMapping("/ordenes/*")
public class OrdenesController {
	
	@Autowired
	private OrdenesServiceImpl ordenesServiceImpl;
	
	@Autowired
	private SucursalServiceImpl sucursalesServiceImpl;

	
	@GetMapping("{id}")
	public ResponseEntity<Ordenes> getById(@PathVariable int id){		
		Optional<Ordenes> ordenesOptional = ordenesServiceImpl.findById(id);
		return ResponseEntity.ok(ordenesOptional.orElseThrow());
	}
	
	@PostMapping
	public ResponseEntity<Ordenes> save(@RequestBody Ordenes item){		
		return ResponseEntity.status(HttpStatus.CREATED).body(ordenesServiceImpl.save(item));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Ordenes> update(@RequestBody OrdenesDto item, @PathVariable int id){
		Optional<Ordenes> ordenesOptional = ordenesServiceImpl.findById(id);
		if(ordenesOptional.isPresent()) {
			Ordenes ordenesDb =  ordenesOptional.orElseThrow();
			ordenesDb.setOrdenId(item.getOrdenId());
			Optional<Sucursales> sucursalesOptional = sucursalesServiceImpl.findById(item.getSucursalId());
			ordenesDb.setSucursalId(sucursalesOptional.orElseThrow());
			ordenesDb.setFecha(item.getFecha());
			ordenesDb.setTotal(item.getTotal());
			return ResponseEntity.status(HttpStatus.CREATED).body(ordenesServiceImpl.save(ordenesDb));
		}
		return null;
	}
}
