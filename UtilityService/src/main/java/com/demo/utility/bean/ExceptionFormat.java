package com.demo.utility.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionFormat {
	
	private String message;
	private Date timestamp;
	private String error;
	//private String path;

}
