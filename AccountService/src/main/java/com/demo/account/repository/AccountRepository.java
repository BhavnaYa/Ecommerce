package com.demo.account.repository;

import com.demo.account.bean.AccountBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<AccountBean, String>{

    AccountBean findByEmailId(String emailId);

}
