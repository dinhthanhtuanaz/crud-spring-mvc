package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.CategoryService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "admin/dashboard", method = RequestMethod.GET)
	public ModelAndView dashBoardPage() {
		System.out.println("dashBoardPage");
		categoryService.testFindAll();
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
}
