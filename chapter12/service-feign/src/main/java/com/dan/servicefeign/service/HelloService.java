package com.dan.servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-service", fallback = HelloServiceHystrix.class)
public interface HelloService {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String sayHello(@RequestParam(value = "name") String name);
	
}
