package com.sip.feigh.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name,String id) {
        return "sorry "+name+"SessionId: "+id;
    }

    @Override
    public String sayHiFromClientTwo(String id) {
        return "sorry SessionId: "+id;
    }
}
