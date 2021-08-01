package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.entity.Category;

public interface CategoryRepository extends MyBaseRepository<Category, Long>{
	List<Category> findAllByNameContaining(String name);
	Page<Category> findAllByNameContaining(String name, Pageable pageable);
}