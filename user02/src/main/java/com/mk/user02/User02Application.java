package com.mk.user02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class User02Application {

    public static void main(String[] args) {
        SpringApplication.run(User02Application.class, args);
    }

}
