package com.demo.account.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.account.bean.AccountBean;
import com.demo.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AccountServiceImplTest {
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @Test
    void testSignUp() {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");
        when(this.accountRepository.save((AccountBean) any())).thenReturn(accountBean);

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        assertSame(accountBean, this.accountServiceImpl.signUp(accountBean1));
        verify(this.accountRepository).save((AccountBean) any());
    }
}

