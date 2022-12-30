package com.mk.gateway.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebAction {

    @RequestMapping("/error")
    public String error(){
        return "gateway===error!!!";
    }
}
