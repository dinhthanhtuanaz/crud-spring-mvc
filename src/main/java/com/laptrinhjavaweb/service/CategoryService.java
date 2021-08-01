package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.laptrinhjavaweb.entity.Category;

public interface CategoryService extends MyBaseService<Category, Long>{
	void testFindAll();
	Page<Category> findAllByNameContaining(String name, int page);
}
