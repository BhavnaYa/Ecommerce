package com.demo.order;

import com.demo.utility.exceptions.CustomExceptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableMongoRepositories
@SpringBootApplication
@Import(CustomExceptions.class)
//@EnableEurekaClient
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
