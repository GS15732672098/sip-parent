package com.sip.serverhi;

import brave.sampler.Sampler;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix  //@EnableHystrix注解开启断路器
@EnableHystrixDashboard  //开启HystrixDashboard
@EnableCircuitBreaker  //开启断路器功能
@EnableRedisHttpSession
public class ServerHiApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServerHiApplication.class, args );
    }

    @Value("${server.port}")
    String port;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOG = Logger.getLogger(ServerHiApplication.class.getName());

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name", defaultValue = "sip") String name, HttpServletRequest request) {
//        String sessionid = "";
//        try {
//            HttpSession session = request.getSession();
//            sessionid=session.getId();
//        } catch (Exception e) {
//            System.out.println("-----获取sessionid-1失败----");
//            e.printStackTrace();
//        }
        LOG.log(Level.INFO, "calling trace service-hi  ");
        String id = request.getSession().getId();
        System.out.println("ServerHi----ID--"+id);

        HttpSession session = request.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(StringUtils.isEmpty(sessionId)){ //"sessionId", "testSessionRedis|" + System.currentTimeMillis()
            session.setAttribute("sessionId","8899");
        }
        LOG.log(Level.WARNING, "加入成功");
        LOG.log(Level.INFO, request.getSession().getAttribute("sessionId")+"");
        LOG.log(Level.WARNING, "获取成功");
        return "hi " + name + " ,i am from port:" + port+", i am from SessionID: "+sessionId;
    }

    @RequestMapping("/hello-h")
    public String info(){
        LOG.log(Level.INFO, "calling trace service-hi ");
        return "i'm service-hi";
    }

    @RequestMapping("/server-hi")
    public String callHome(){
        LOG.log(Level.INFO, "calling trace service-hi  ");
        return restTemplate.getForObject("http://sip-ribbon/hello-r", String.class);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    public String hiError(String name, HttpServletRequest request) {
        return "hi,"+name+",sorry,error!";
    }

    @GetMapping("/gethi")
    public String getUser(HttpServletRequest request){
        LOG.log(Level.INFO, "info is being called");
        LOG.log(Level.INFO, request.getSession().getAttribute("sessionId")+"");
        LOG.log(Level.WARNING, "获取成功");
        return restTemplate.getForObject("http://localhost:8763/gethi",String.class);

    }

}
