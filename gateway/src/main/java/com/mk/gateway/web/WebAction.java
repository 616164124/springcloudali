package com.mk.gateway.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAction {


    @RequestMapping("/error")
    public String error(){
        return "gateway===error!!!";
    }
}
