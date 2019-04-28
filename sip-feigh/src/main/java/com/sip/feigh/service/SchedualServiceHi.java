package com.sip.feigh.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//fallback = SchedualServiceHiHystric.class 开启熔断器返回实现类
@FeignClient(value = "server-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name,@RequestParam(value = "id") String id);
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    String sayHiFromClientTwo(@RequestParam(value = "id") String id);

}
