package com.demo.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.account.bean.AccountBean;
import com.demo.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public AccountBean signUp(AccountBean accountBean) {
		
		return accountRepository.save(accountBean);
	}

	
}
