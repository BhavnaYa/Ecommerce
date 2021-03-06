package com.inventory;

import com.demo.utility.config.WebConfig;
import com.demo.utility.exceptions.CustomExceptions;
import com.demo.utility.interceptor.HeaderInterceptor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@Import({CustomExceptions.class, HeaderInterceptor.class, WebConfig.class})
@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
