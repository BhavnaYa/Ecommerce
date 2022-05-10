package com.demo.order.bean;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
	
	@NotNull
	private String firstLine;
    private String secondLine;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String pinCode;
    private String country;

}
