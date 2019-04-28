package com.sip.feigh;

import com.sip.feigh.feigh.FeignHystrixConcurrencyStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@SpringBootApplication
@EnableEurekaClient //注释
@EnableDiscoveryClient
@EnableFeignClients  //启动feign客户端
@EnableRedisHttpSession
public class SipFeighApplication {
    public static void main(String[] args) {
        SpringApplication.run(SipFeighApplication.class, args);
    }
    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
        return new FeignHystrixConcurrencyStrategy();
    }
}
