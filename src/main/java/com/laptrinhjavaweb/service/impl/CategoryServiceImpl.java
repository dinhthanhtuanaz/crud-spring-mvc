package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void testFindAll() {
		List<Category> categories =  categoryRepository.findAll();
		System.out.println("Category size = " + categories.size());
	}

	@Override
	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}
}
