package com.demo.order;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableMongoRepositories
@SpringBootApplication
@OpenAPIDefinition
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
