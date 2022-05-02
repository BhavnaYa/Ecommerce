package com.demo.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.demo.account.bean.AccountBean;

public interface AccountRepository extends MongoRepository<AccountBean, String>{
	
	
}
