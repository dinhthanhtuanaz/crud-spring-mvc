package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.CategoryService;
import com.laptrinhjavaweb.utils.Constant;

@Service
public class CategoryServiceImpl extends MyBaseServiceImpl<Category, Long> implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void testFindAll() {
		List<Category> categories =  categoryRepository.findAll();
		System.out.println("Category size = " + categories.size());
	}

	@Override
	public Page<Category> findAllByNameContaining(String name, int page) {
		return categoryRepository.findAllByNameContaining(name, new PageRequest(page - 1, Constant.PER_PAGE, sortByIdDesc()));
		
	}
}
