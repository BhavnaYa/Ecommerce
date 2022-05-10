package com.demo.account.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "Account")
public class AccountBean {

	@Id
	private String emailId;
	@NotNull @Size(min = 5, max = 25, message = "Password must be between 5 and 25 characters")
	private String password;
	@NotNull
	private String name;
	private String phoneNo;
	private boolean loginStatus;
	
}
