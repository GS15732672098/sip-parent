package com.sip.feigh.controller;

import com.sip.feigh.service.SchedualServiceHi;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HiController {

    @Autowired
    private SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name, HttpServletRequest request){

        String id = request.getSession().getId();
        System.out.println("feigh----ID--"+id);
        HttpSession session2 = request.getSession();
        String sessionId = (String)session2.getAttribute("sessionId");
        if(StringUtils.isEmpty(sessionId)){
            session2.setAttribute("sessionId", "testSessionRedis|" + request.getSession().getId());
        }

        return schedualServiceHi.sayHiFromClientOne(name,id);
    }
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(HttpServletRequest request){
        String id = request.getSession().getId();
        return schedualServiceHi.sayHiFromClientTwo(id);
    }
}
