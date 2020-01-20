package org.abhi.auth.api;

import java.util.HashMap;
import java.util.Map;

import org.abhi.auth.beans.AuthRequest;
import org.abhi.auth.beans.AuthResponse;
import org.abhi.auth.beans.UserInfo;
import org.abhi.auth.util.AuthoritiesBuilder;
import org.abhi.auth.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private static Map<String, UserDetails> map = new HashMap<>();
	
	static {
		UserInfo abhijeetDetails = new UserInfo();
		abhijeetDetails.setUsername("abhijeet");
		abhijeetDetails.setPassword("$2a$10$L5etz.hZIzk5xS9FAHRHuuTa4QYJ3tt1LZ..Tnl1HxvYMrO.35/.O");
		abhijeetDetails.setAuthorities(AuthoritiesBuilder.getAdminAuthorities());
		map.put("abhijeet", abhijeetDetails);
		
		
		UserInfo panditDetails = new UserInfo();
		panditDetails.setUsername("pandit");
		panditDetails.setPassword("abc");
		panditDetails.setAuthorities(AuthoritiesBuilder.getAdminAuthorities());
		map.put("pandit", panditDetails);
	}
	
	@RequestMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
		authenticate(authRequest.getUserName(), authRequest.getPassword());
		UserDetails userDetails = getUserDetails(authRequest.getUserName());
		String token = tokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(token));
	}

	public static UserDetails getUserDetails(String userName) {
		return map.get(userName);
	}

	private void authenticate(String userName, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		} catch (AuthenticationException e) {
			throw new Exception(e);
		}
	}
}
