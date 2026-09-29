package lk.ijse.pulsefit.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * PulseFit Platform - API Gateway.
 * Single entry point for the frontend. Routes /api/members/**,
 * /api/classes/** and /api/bookings/** to the matching backend
 * microservice, resolved dynamically through Eureka (lb://SERVICE-NAME),
 * so it keeps working as each microservice's Managed Instance Group
 * scales up or down. Route definitions live in the Config Server
 * (see config-server/src/main/resources/config-repo/api-gateway.yml).
 */
@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
