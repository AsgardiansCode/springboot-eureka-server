package com.chamali.serviceb.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ServiceBRestController {
    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public ServiceBRestController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        this.restClient = restClientBuilder.build();
    }

    @GetMapping("helloEureka")
    public String helloWorld(){
        ServiceInstance serviceInstance= discoveryClient.getInstances("servicea").get(0);
        String serviceResponse = restClient.get().uri(serviceInstance.getUri()+"/helloWorld").retrieve().body(String.class);
        return serviceResponse;
    }

    @GetMapping("ddiChecker")
    public String ddiChecker(){
        ServiceInstance serviceInstance= discoveryClient.getInstances("drug-interaction-checker").get(0);
        String serviceResponse = restClient.get().uri(serviceInstance.getUri()+"/ddi_checker_test").retrieve().body(String.class);
        return serviceResponse;
    }

}
