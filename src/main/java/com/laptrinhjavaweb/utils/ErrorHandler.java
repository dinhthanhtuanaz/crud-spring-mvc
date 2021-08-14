package com.laptrinhjavaweb.utils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ErrorHandler {
	public static String responJsonError(List<FieldError> fieldErrors) {
		Map<String, String> errors = new HashMap<String, String>();
		for (FieldError fieldError : fieldErrors) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        Gson gson = new Gson();
        Type gsonType = new TypeToken<HashMap>(){}.getType();
        return gson.toJson(errors, gsonType);
	}
}
