package com.dan.servicefeign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.servicefeign.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;
    
    @GetMapping(value = "/hello")
    public String sayHi(@RequestParam(value = "name") String name){
        return helloService.sayHello(name);
    }
}