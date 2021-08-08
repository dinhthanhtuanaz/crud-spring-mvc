package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "adminProduct")
@RequestMapping("/admin/products")
public class ProductController {
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("admin/products/create");
		return mav;
	}
}
