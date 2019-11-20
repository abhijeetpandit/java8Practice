package org.abhi.auth;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationService {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AuthenticationService.class);
		springApplication.setDefaultProperties(Collections.singletonMap("server.port", 8888));
		springApplication.run();
	}
}
