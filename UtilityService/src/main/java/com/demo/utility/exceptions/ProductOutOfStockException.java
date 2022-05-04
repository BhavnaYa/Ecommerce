package com.demo.utility.exceptions;

public class ProductOutOfStockException extends RuntimeException{
	
	public ProductOutOfStockException(String message) {
		super(message);
	}

}
