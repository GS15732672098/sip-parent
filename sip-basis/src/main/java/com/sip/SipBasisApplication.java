package com.sip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class SipBasisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SipBasisApplication.class, args);
    }

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

