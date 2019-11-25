package org.abhi.auth.beans;

import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {

	ADMIN("Admin");
	
	private String authorityName;
	
	private Authority(String name) {
		this.authorityName = name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return authorityName;
	}

	@Override
	public String toString() {
		return authorityName;
	}

	public static Authority fromString(String authorityName) {
		return Arrays.stream(Authority.values()).filter((authority) -> authority.authorityName.equals(authorityName)).findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid value : " + authorityName));
	}
	
	public static void main(String[] args) {
		System.out.println("->" + Authority.fromString("Admin"));
		System.out.println("-----------------");
		System.out.println("->" + Authority.fromString("ADMIN"));
	}
}
