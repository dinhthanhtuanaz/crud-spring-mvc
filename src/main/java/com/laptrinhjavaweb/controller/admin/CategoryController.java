package com.laptrinhjavaweb.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.service.CategoryService;

@Controller(value = "adminCategory")
@RequestMapping("/admin/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping(value = "")
	public ModelAndView index(HttpSession session, Model model, @RequestParam(name = "page", defaultValue = "1") String page,
				@RequestParam(name = "name", defaultValue = "") String name
			)
	{
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Page<Category> pagination = categoryService.findAllByNameContaining(name, currentPage);
		List<Category> categories = pagination.getContent();
		String paginationTag = categoryService.buildPaginationTag(
				currentPage,
				pagination.getTotalPages(),
				context.getContextPath() +"/admin/categories?name=" + name
			);
		
		model.addAttribute("categories", categories);
		model.addAttribute("paginationTag", paginationTag);
		ModelAndView mav = new ModelAndView("admin/categories/list");
		model.addAttribute("alertSession", session.getAttribute("alertSession"));
		session.removeAttribute("alertSession");
		return mav;
	}
	
	@RequestMapping(value = "create")
	public ModelAndView create(Map<String, Object> model) {
		Category category = new Category();
	    model.put("category", category);
		ModelAndView mav = new ModelAndView("admin/categories/create");
		return mav;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String store(HttpSession session,@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/categories/create";
		}
		categoryService.create(category);
		session.setAttribute("alertSession", "Tạo danh mục thành công");
		session.setMaxInactiveInterval(10);
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value = "{id}/edit")
	public ModelAndView edit(@PathVariable Long id, Model model)
	{
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		ModelAndView mav = new ModelAndView("admin/categories/edit");
		return mav;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpSession session,@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/categories/edit";
		}
		categoryService.update(category);
		session.setAttribute("alertSession", "Cập nhật danh mục thành công");
		session.setMaxInactiveInterval(10);
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(HttpSession session, @PathVariable Long id)
	{
		categoryService.deleteById(id);
		session.setAttribute("alertSession", "Xóa danh mục thành công");
		session.setMaxInactiveInterval(10);
		return "{\"status\":true,\"msg\":\"Delete success\"}";
	}
}
