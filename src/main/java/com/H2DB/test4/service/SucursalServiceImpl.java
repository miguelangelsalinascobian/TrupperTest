package com.H2DB.test4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.H2DB.test4.entity.Ordenes;
import com.H2DB.test4.entity.Sucursales;
import com.H2DB.test4.repository.SucursalesRepository;

@Service
public class SucursalServiceImpl implements IService <Sucursales>{

	@Autowired
	private SucursalesRepository sucursalesRepository;
	
	@Override
	public Optional<Sucursales> findById(int id) {
		return sucursalesRepository.findById(id);
	}

	@Override
	public Sucursales save(Sucursales item) {
		return sucursalesRepository.save(item);
	}
}
