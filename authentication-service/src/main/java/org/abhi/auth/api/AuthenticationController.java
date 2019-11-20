package org.abhi.auth.api;

import org.abhi.auth.beans.AuthResponse;
import org.abhi.auth.beans.UserInfo;
import org.abhi.auth.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserInfo userDetails) throws Exception {
		authenticate(userDetails);
		String token = tokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(token));
	}

	private void authenticate(UserInfo userDetails) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword()));
		} catch (AuthenticationException e) {
			throw new Exception(e);
		}
	}
}
