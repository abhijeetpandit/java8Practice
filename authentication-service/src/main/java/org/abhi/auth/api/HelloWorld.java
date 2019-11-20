package org.abhi.auth.api;

import org.abhi.auth.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello-service")
public class HelloWorld {
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE, path = "/hello")
	public String sayHello() {
		return "Hello Worldd " + tokenUtil.getSecret();
	}
}
