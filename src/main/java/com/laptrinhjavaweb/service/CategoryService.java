package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.Category;

public interface CategoryService {
	void testFindAll();
	Category create(Category category);
	List<Category> getAll();
}
