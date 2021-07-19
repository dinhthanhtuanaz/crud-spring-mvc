package com.laptrinhjavaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@RequestMapping(value = "admin/dashboard", method = RequestMethod.GET)
	public ModelAndView dashBoardPage() {
		System.out.println("dashBoardPage");
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
}
