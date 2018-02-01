package com.dan.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	@Value("${foo}")
	String foo;
	
	@GetMapping("/foo")
	public String getFoo() {
		return foo;
	}
	
}
