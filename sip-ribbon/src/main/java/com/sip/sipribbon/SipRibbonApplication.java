package com.sip.sipribbon;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix  //熔断器注解
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SipRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(SipRibbonApplication.class, args);
    }
   @Bean
   @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
   }

    private static final Logger LOG = Logger.getLogger(SipRibbonApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello-r")
    public String home(){
        LOG.log(Level.INFO, "hi is being called");
        return "hi i'm ribbon!";
    }

    @RequestMapping("/ribbon")
    public String info(){
        LOG.log(Level.INFO, "正在调用ribbon-info");
        return restTemplate.getForObject("http://server-hi/hello-h",String.class);
    }

//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }


}
