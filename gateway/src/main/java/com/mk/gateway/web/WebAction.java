package com.mk.gateway.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebAction {

    @RequestMapping("/error")
    public String error(){
        return "gatewayerror";
    }
}
