package com.project.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

// 1. The exact correct handler imports for Spring Cloud Gateway MVC
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	// Route Rule 1: Handles all Book Service traffic
	@Bean
	public RouterFunction<ServerResponse> bookRoute() {
		return route("book-service-route")
				.route(path("/book/**"), http())
				.filter(lb("book-service"))
				.build();
	}

	@Bean
	public RouterFunction<ServerResponse> rentalRoute() {
		return route("rental-service-route")
				.route(path("/rental/**"), http())
				.filter(lb("rental-service"))
				.build();
	}
}