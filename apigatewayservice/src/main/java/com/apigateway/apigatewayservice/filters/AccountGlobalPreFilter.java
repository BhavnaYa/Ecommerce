package com.apigateway.apigatewayservice.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AccountGlobalPreFilter implements GlobalFilter {

    final Logger logger =
            LoggerFactory.getLogger(AccountGlobalPreFilter.class);

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {
        RequestPath path = exchange.getRequest().getPath();
        if (!path.toString().contains("/account/")) {
            logger.info("Calling account service for token validity");
            RestTemplate restTemplate = new RestTemplate();
            String token = String.valueOf(exchange.getRequest().getHeaders().get("Authorization"));
            String accountUri = "http://localhost:8081/account/validity?token=" + token.substring(1,token.length()-1);
            ResponseEntity<String> response = restTemplate.getForEntity(accountUri, String.class);
            ServerHttpRequest request = exchange.getRequest()
                    .mutate()
                    .header("validated", response.getBody())
                    .build();
            ServerWebExchange exchange1 = exchange.mutate().request(request).build();
            return chain.filter(exchange1);
        }
        return chain.filter(exchange);
    }

}
