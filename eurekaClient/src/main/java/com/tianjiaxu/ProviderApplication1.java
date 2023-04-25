package com.tianjiaxu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication1.class,args);
    }
}
