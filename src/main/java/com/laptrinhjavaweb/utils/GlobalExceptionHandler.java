package com.laptrinhjavaweb.utils;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBindException(BindException e) {
	    // Trả về message của lỗi đầu tiên
	    String errorMessage = "Request không hợp lệ";
	    if (e.getBindingResult().hasErrors())
	        e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
	    return errorMessage;
	}
}
