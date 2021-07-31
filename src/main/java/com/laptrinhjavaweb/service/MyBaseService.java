package com.laptrinhjavaweb.service;

import java.io.Serializable;
import java.util.List;

public interface MyBaseService<T, ID extends Serializable> {
	List<T> getAll();
	T create(T entity);
	T findById(ID id);
	T update(T entity);
	void deleteById(ID id);
}
