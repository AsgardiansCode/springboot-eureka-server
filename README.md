# Eureka Server Application

This Eureka Server application provides service discovery for microservices. It acts as a registry where microservices can register themselves and discover other registered services.

## Features

- **Service Registration:** Microservices can register themselves with Eureka Server.
- **Service Discovery:** Microservices can discover other registered services to facilitate communication.
- **High Availability:** Supports running multiple instances for high availability and load balancing.

The configuration for Eureka Server can be found in the `application.properties` file. Here are some key properties:

- **Server Port:** The default port is set to `8761`.
- **Eureka Server:** Basic configurations for Eureka server.
