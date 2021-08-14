package com.laptrinhjavaweb.controller.admin;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.entity.Product;
import com.laptrinhjavaweb.entity.ProductClass;
import com.laptrinhjavaweb.response.ProductJsonResponse;
import com.laptrinhjavaweb.utils.ErrorHandler;
import com.laptrinhjavaweb.utils.JsonResponse;

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
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String store(HttpSession session,@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			String errors = result.getAllErrors().toString();
			System.out.println("Error: " + errors);
			return "admin/products/create";
		}
		return "redirect:/admin/categories";
	}
	
//	@RequestMapping(value = "create2", method = RequestMethod.POST)
//	public ResponseEntity<Product> store2(@Valid @RequestBody Product product) {
//		return null;
//	}
	@RequestMapping(value = "create2", method = RequestMethod.POST)
	@ResponseBody
	public String store2(@Valid @RequestBody Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("tuandt_error: " + bindingResult.getFieldErrors().toString());
		}
		return "{\"status\":true,\"msg\":\"Delete successssssss\"}";
	}
	
	@RequestMapping(value = "/submituser",method=RequestMethod.POST )
	@ResponseBody
    public ResponseEntity<?> submitUser(@Valid Product product, BindingResult bindingResult){
        System.out.println("Submited User Data : \n"+product);
        if(!bindingResult.hasErrors()){
            return new ResponseEntity<>(ErrorHandler.responJsonError(bindingResult.getFieldErrors()), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>("{\"status\":true,\"msg\":\"Delete successssssss\"}", HttpStatus.OK);
    }
}
