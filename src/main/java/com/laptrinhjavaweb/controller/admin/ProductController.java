package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.entity.Product;

@Controller(value = "adminProduct")
@RequestMapping("/admin/products")
public class ProductController {
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
		ModelAndView mav = new ModelAndView("admin/products/create");
		return mav;
	}
	
//	@PostMapping("")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String store(HttpSession session,@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/products/create";
		}
		return "redirect:/admin/categories";
	}
}
