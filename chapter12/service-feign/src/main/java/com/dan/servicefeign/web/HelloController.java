package com.dan.servicefeign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.servicefeign.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name) {
        return helloService.sayHello(name);
    }
}