package com.H2DB.test4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.H2DB.test4.entity.Ordenes;
import com.H2DB.test4.repository.OrdenesRepository;

@Service
public class OrdenesServiceImpl implements IService <Ordenes>{

	@Autowired
	private OrdenesRepository ordenesRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Ordenes> findById(int id) {
		return ordenesRepository.findById(id);
	}

	@Transactional
	@Override
	public Ordenes save(Ordenes item) {
		return ordenesRepository.save(item);
	}
}
