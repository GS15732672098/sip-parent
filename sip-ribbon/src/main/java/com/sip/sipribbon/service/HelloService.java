package com.sip.sipribbon.service;

        import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")//对该方法创建了熔断器的功能
    public String hiService(String name) {
        String abc=restTemplate.getForObject("http://SERVER-HI/hi?name="+name,String.class);
        return abc;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}

