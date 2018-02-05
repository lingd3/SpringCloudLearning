package com.dan.servicefeign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService {

	@Override
	public String sayHello(String name) {
		return "hello " + name + ", error!";
	}

}
