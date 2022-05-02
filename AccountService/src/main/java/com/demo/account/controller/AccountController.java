package com.demo.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.account.bean.AccountBean;
import com.demo.account.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/signUp")
	public AccountBean signUp(@RequestBody AccountBean accountBean) {
	return accountService.signUp(accountBean);
	}
	
	
	
	
}
