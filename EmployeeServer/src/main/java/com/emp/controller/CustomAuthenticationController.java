package com.emp.controller;

import javax.ws.rs.core.MediaType;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.data.AuthenticationRequest;
import com.emp.data.AuthenticationResponse;
import com.emp.service.CustomUserDetailService;
import com.util.JwtTokenUtil;

@RestController
public class CustomAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService userDetailService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON }, consumes = { MediaType.APPLICATION_JSON })
	public @ResponseBody AuthenticationResponse authenticate(
			@RequestBody AuthenticationRequest request) {

		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							request.getUserName(), request.getPassword()));

		} catch (Exception exe) {

		}

		AuthenticationResponse response = new AuthenticationResponse();
		String jwtToken = jwtTokenUtil.generateToken(userDetailService
				.loadUserByUsername(request.getUserName()));
		response.setJwtToken(jwtToken);
		return response;
	}

}
