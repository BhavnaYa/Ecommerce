package com.demo.account.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "userInfo")
public class AccountBean {

	@Id
	private String emailId;
	private String password;
	private String name;
	private String phoneNo;
	private boolean loginStatus;
	
}
