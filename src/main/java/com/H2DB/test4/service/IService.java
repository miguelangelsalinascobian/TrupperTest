package com.H2DB.test4.service;

import java.util.Optional;

public interface IService <T>{
	Optional<T> findById(int id);
	T save(T item);
}
