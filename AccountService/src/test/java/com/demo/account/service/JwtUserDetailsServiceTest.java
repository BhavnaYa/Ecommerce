package com.demo.account.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.account.bean.AccountBean;
import com.demo.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class JwtUserDetailsServiceTest {
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");
        when(this.accountRepository.findByEmailId((String) any())).thenReturn(accountBean);
        UserDetails actualLoadUserByUsernameResult = this.jwtUserDetailsService.loadUserByUsername("jane.doe@example.org");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("42", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.accountRepository).findByEmailId((String) any());
    }
}

