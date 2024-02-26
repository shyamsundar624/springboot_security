package com.library.shyam.jwt;

import lombok.Data;
/*
 * @author Shyam Sundar
 */
@Data
public class JWTAuthenticationRequest {

	private String username;
	private String password;
	
}
