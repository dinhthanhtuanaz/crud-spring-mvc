package com.laptrinhjavaweb.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public interface MyBaseService<T, ID extends Serializable> {
	List<T> getAll();
	T create(T entity);
	T findById(ID id);
	T update(T entity);
	void deleteById(ID id);
	Page<T> paginate(int page);
	String buildPaginationTag(int page, int totalPages, String url);
}
