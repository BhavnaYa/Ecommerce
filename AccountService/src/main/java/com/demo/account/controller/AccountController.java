package com.demo.account.controller;

import com.demo.account.model.JwtRequest;
import com.demo.account.model.JwtResponse;
import com.demo.account.service.JwtUserDetailsService;
import com.demo.account.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import com.demo.account.bean.AccountBean;
import com.demo.account.service.AccountService;

@RequestMapping("account")
@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping("/signUp")
	public ResponseEntity<Object> signUp(@RequestBody AccountBean accountBean) {
		accountService.signUp(accountBean);
		//return new ResponseEntity<T>("SignedUp Successfully!!", HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@GetMapping("/validity")
	public ResponseEntity<Boolean> isValidToken(@RequestParam(name = "token") String token) {
		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername(jwtTokenUtil.getUsernameFromToken(token));
			jwtTokenUtil.validateToken(token, userDetails);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.ok(false);
		}
	}

}
