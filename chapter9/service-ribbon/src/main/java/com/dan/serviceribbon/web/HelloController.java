package com.dan.serviceribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.serviceribbon.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/hello")
	public String sayHello(@RequestParam String name) {
		return helloService.helloService(name);
	}
	
}