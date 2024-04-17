package com.alstom.alstomsecondservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlstomSecondServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlstomSecondServiceApplication.class, args);
    }

}
