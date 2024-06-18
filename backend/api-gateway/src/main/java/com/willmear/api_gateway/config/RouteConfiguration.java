package com.willmear.api_gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.core.OAuth2AccessToken;


@Configuration
@EnableWebFluxSecurity
public class RouteConfiguration {

    @Autowired
    private TokenRelayGatewayFilterFactory filterFactory;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("core-service", r -> r.path("/core-service/**")
                        .filters(f -> f.stripPrefix(1)
                                .filters(filterFactory.apply())
                                .removeRequestHeader("Cookie")
                        )
                        .uri("lb://core-service"))
                        .build();

    }

}
