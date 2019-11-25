package org.abhi.auth.util;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.abhi.auth.beans.Authority;

public class AuthoritiesBuilder {
	public static Collection<Authority> getAdminAuthorities() {
		return Stream.of(Authority.ADMIN).collect(Collectors.toList());
	}
}
