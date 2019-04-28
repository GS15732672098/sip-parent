package com.sip;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //Eureka服务器(注册中心)
public class SipServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SipServerApplication.class, args);
    }

}

