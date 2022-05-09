package com.demo.order;

import com.demo.utility.config.WebConfig;
import com.demo.utility.exceptions.CustomExceptions;
import com.demo.utility.interceptor.HeaderInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@Import({CustomExceptions.class, WebConfig.class, HeaderInterceptor.class})
@EnableMongoRepositories
@SpringBootApplication
@OpenAPIDefinition
@EnableEurekaClient
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
