package com.dan.servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface HelloService {

	@GetMapping("/hello")
	String sayHello(@RequestParam(value = "name") String name);
	
}
