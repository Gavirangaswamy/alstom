package com.alstom.alstomdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AlstomDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlstomDiscoveryServerApplication.class, args);
    }

}
