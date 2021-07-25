package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.service.CategoryService;

@Controller(value = "adminCategory")
@RequestMapping("/admin/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(Map<String, Object> model) {
		Category category = new Category();
	    model.put("category", category);
		ModelAndView mav = new ModelAndView("admin/categories/create");
		return mav;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String store(@ModelAttribute("category") Category category) {
		categoryService.create(category);
		return "redirect:/admin/categories";
	}
}
