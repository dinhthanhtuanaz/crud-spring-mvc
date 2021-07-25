package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
