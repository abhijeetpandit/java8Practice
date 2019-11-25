package org.abhi.auth.components;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.abhi.auth.beans.UserInfo;
import org.abhi.auth.util.AuthoritiesBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class JWTUserDetailsService implements UserDetailsService {

private static Map<String, UserDetails> map = new HashMap<>();
	
	static {
		UserInfo abhijeetDetails = new UserInfo();
		abhijeetDetails.setUsername("abhijeet");
		abhijeetDetails.setPassword("$2a$10$eiXPVzxo4sEi3sDxu1fJ7edpd2eESqotp1kohPEfIED.ZGNVK.erG");
		abhijeetDetails.setAuthorities(AuthoritiesBuilder.getAdminAuthorities());
		map.put("abhijeet", abhijeetDetails);
		
		
		UserInfo panditDetails = new UserInfo();
		panditDetails.setUsername("pandit");
		panditDetails.setPassword("abc");
		panditDetails.setAuthorities(AuthoritiesBuilder.getAdminAuthorities());
		map.put("pandit", panditDetails);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return Optional.ofNullable(map.get(username)).orElseThrow(() -> new UsernameNotFoundException("User not found : " + username));
	}

}
