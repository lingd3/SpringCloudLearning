package com.dan.serviceturbineamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
@EnableDiscoveryClient
public class ServiceTurbineAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTurbineAmqpApplication.class, args);
	}
}
