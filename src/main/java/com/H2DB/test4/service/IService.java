package com.H2DB.test4.service;

import java.util.List;
import java.util.Optional;

public interface IService <T>{
	List<T> getAll();
	Optional<T> getById(int id);
	T save(T item);
}
