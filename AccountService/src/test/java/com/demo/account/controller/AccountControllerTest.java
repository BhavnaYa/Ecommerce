package com.demo.account.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.demo.account.bean.AccountBean;
import com.demo.account.model.JwtRequest;
import com.demo.account.service.AccountService;
import com.demo.account.service.JwtUserDetailsService;
import com.demo.account.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AccountController.class})
@ExtendWith(SpringExtension.class)
class AccountControllerTest {
    @Autowired
    private AccountController accountController;

    @MockBean
    private AccountService accountService;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    @Test
    void testCreateAuthenticationToken() throws Exception {
        when(this.jwtUserDetailsService.loadUserByUsername((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        when(this.jwtTokenUtil.generateToken((org.springframework.security.core.userdetails.UserDetails) any()))
                .thenReturn("ABC123");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("jane.doe@example.org");
        jwtRequest.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(jwtRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/account/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"jwttoken\":\"ABC123\"}"));
    }

    @Test
    void testSignUp() throws Exception {
        AccountBean accountBean = new AccountBean();
        accountBean.setEmailId("42");
        accountBean.setLoginStatus(true);
        accountBean.setName("Name");
        accountBean.setPassword("iloveyou");
        accountBean.setPhoneNo("4105551212");
        when(this.accountService.signUp((AccountBean) any())).thenReturn(accountBean);

        AccountBean accountBean1 = new AccountBean();
        accountBean1.setEmailId("42");
        accountBean1.setLoginStatus(true);
        accountBean1.setName("Name");
        accountBean1.setPassword("iloveyou");
        accountBean1.setPhoneNo("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(accountBean1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/account/signUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Success"));
    }

    @Test
    void testIsValidToken() throws Exception {
        when(this.jwtUserDetailsService.loadUserByUsername((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        when(this.jwtTokenUtil.validateToken((String) any(),
                (org.springframework.security.core.userdetails.UserDetails) any())).thenReturn(true);
        when(this.jwtTokenUtil.getUsernameFromToken((String) any())).thenReturn("janedoe");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account/validity")
                .param("token", "foo");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    @Test
    void testIsValidToken2() throws Exception {
        when(this.jwtUserDetailsService.loadUserByUsername((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", new ArrayList<>()));
        when(this.jwtTokenUtil.validateToken((String) any(),
                (org.springframework.security.core.userdetails.UserDetails) any())).thenThrow(new BadCredentialsException("?"));
        when(this.jwtTokenUtil.getUsernameFromToken((String) any())).thenThrow(new BadCredentialsException("?"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account/validity")
                .param("token", "foo");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }
}

