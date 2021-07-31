package com.laptrinhjavaweb.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.laptrinhjavaweb.repository.MyBaseRepository;
import com.laptrinhjavaweb.service.MyBaseService;

public class MyBaseServiceImpl<T, ID extends Serializable> implements MyBaseService<T, ID>{

	// Define BaseRepo
	@Autowired
	MyBaseRepository<T, ID> repository;
	
	@Override
	public List<T> getAll() {
		return repository.findAll();
	}

	@Override
	public T create(T entity) {
		return repository.save(entity);
	}

	@Override
	public T findById(ID id) {
		return repository.findOne(id);
	}

	@Override
	public T update(T entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteById(ID id) {
		repository.delete(id);
	}
}
