package com.powerup.propertymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PropertyMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyMicroserviceApplication.class, args);
    }

}
