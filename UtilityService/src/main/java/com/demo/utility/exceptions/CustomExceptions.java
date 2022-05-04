package com.demo.utility.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.utility.bean.ExceptionFormat;

@ControllerAdvice
@RestController
public class CustomExceptions extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ProductOutOfStockException.class)
	public final ResponseEntity<Object> handleProductOutOfStockException(Exception ex, WebRequest request) {
		ExceptionFormat format = new ExceptionFormat(ex.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity<>(format, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {
		ExceptionFormat format = new ExceptionFormat(ex.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity<>(format, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
		ExceptionFormat format = new ExceptionFormat(ex.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity<>(format, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
