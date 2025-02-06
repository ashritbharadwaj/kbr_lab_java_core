package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator productAppRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/employeems/**")
                        .filters( f -> f.rewritePath("/employeems/(?<segment>.*)",
                                        "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("mycircuitbreaker")
                                        .setFallbackUri("forward:/fallback"))
                        )
                        .uri("lb://EMPAPP"))
                .route(p -> p
                        .path("/departmentms/**")
                        .filters( f -> f.rewritePath("/departmentms/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                        )
                        .uri("lb://DEPTAPP"))
                .build();
    }
}
