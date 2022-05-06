package com.apigateway.apigatewayservice.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class LoggingGatewayFilterFactory extends
        AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    final Logger logger =
            LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);

    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config){
        return (exchange, chain) -> {
            // Pre-processing
            if (config.isPreLogger()) {
                logger.info("Pre GatewayFilter logging: "
                        + config.getBaseMessage());
            }
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        // Post-processing
                        if (config.isPostLogger()) {
                            logger.info("Post GatewayFilter logging: "
                                    + config.getBaseMessage());
                        }
                    }));
        };
    }
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("baseMessage",
                "preLogger",
                "postLogger");
    }
    @Bean
    public RouteLocator routes(
            RouteLocatorBuilder builder,
            LoggingGatewayFilterFactory loggingFactory) {
        return builder.routes()
                .route("service_route_java_config", r -> r.path("/service/**")
                        .filters(f ->
                                f.rewritePath("/service(?<segment>/?.*)", "$\\{segment}")
                                        .filter(loggingFactory.apply(
                                                new Config("My Custom Message", true, true))))
                        .uri("http://localhost:8081"))
                .build();
    }
@Data
@AllArgsConstructor
@NoArgsConstructor
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}