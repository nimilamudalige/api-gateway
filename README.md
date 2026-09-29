# PulseFit — API Gateway

## Project Description

The single public entry point for the PulseFit backend. Built with Spring
Cloud Gateway (WebFlux), it routes incoming requests to the correct
microservice — resolved dynamically via Eureka service discovery
(`lb://MEMBER-SERVICE`, `lb://CLASS-SERVICE`, `lb://BOOKING-SERVICE`) — so it
automatically load-balances across however many instances each service's
Managed Instance Group happens to be running, with zero Gateway
configuration changes needed when autoscaling kicks in.

Route definitions and CORS policy live in the Config Server
(`config-server/.../config-repo/api-gateway.yml`), not in this repo, per the
module's "centralize configuration" requirement.

## Technology Stack

- Java 25
- Spring Boot 4.0.8
- Spring Cloud 2025.1.3 — Gateway (`spring-cloud-starter-gateway-server-webflux`) + Eureka Client + Config Client
- PM2 (process management on the deployed VM)

## Routes

| Path | Forwards to |
|---|---|
| `/api/members/**` | `member-service` |
| `/api/classes/**` | `class-service` |
| `/api/bookings/**` | `booking-service` |

## Setup / Getting Started

### Prerequisites

- Java 25 JDK, Maven 3.9+
- A running `config-server` and `service-registry` for full functionality

### Run locally

```bash
mvn clean package
java -jar target/api-gateway.jar
```

Verify: `curl http://localhost:8080/actuator/health` returns `{"status":"UP"}`.

## Student Information

- **Student Name:** Pasan Nimila
- **Student Number:** 2301692034
- **Slack Handle:** pasan_nimila
- **GCP Project ID:** pulsefit-capstone
