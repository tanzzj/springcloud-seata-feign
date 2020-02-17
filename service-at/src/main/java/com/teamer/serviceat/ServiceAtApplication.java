package com.teamer.serviceat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceAtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAtApplication.class, args);
    }

}
