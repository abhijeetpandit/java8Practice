package org.abhi.auth.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.abhi.auth.beans.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class TokenUtil {
	
	@Value("${jwt.secret}")
	private String secret;
	
	public static final long TOKEN_VALIDITY = 60 * 1000;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public String generateToken(UserInfo userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(Claims.SUBJECT, userDetails.getUsername());
		long currentTimeMillis = System.currentTimeMillis();
		claims.put(Claims.ISSUED_AT, new Date(currentTimeMillis));
		claims.put(Claims.EXPIRATION, new Date(currentTimeMillis + TOKEN_VALIDITY));
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public boolean isTokenExpired(String token) {
		return new Date(System.currentTimeMillis()).after(getClaimFromToken(token, Claims::getExpiration));
	}
	
	public boolean validateToken(String token, UserInfo userDetails) {
		String username = getUserNameFromToken(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
	
	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claimsResolver.apply(claims);
	}
}
