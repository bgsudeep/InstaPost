package com.instapost.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Either activate @ResponseStatus OR "activate method in @ControllerAdvice
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No Categories are added yet")
 public class CategoryNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3935230281455340039L;
}
