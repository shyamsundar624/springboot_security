package com.library.shyam.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/*
 * @author shyam sundar
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/authenticate")
public class JWTController {

	private final JWTService jwtService;

	private final AuthenticationManager authenticationManager;

	@PostMapping
	public String getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
		return jwtService.getGeneratedToken(authRequest.getUsername());
		}else {
			throw new UsernameNotFoundException("Invalid User Credential");
		}
	}
}
