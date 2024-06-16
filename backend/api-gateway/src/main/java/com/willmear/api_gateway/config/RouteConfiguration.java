package com.willmear.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes().route("core-service", r -> r.path("/core-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://core-service"))
                        .build();

    }

}
