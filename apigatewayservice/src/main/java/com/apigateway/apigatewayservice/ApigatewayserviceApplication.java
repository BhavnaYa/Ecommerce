package com.apigateway.apigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApigatewayserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayserviceApplication.class, args);
	}
	@Bean
	public GlobalFilter globalFilter() {
		return (exchange, chain) -> {
			System.out.println("First Global filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("Second Global filter");
			}));
		};
	}
}
