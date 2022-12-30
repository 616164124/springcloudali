package com.mk.user01.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserAction {

    private static final Logger log = LoggerFactory.getLogger(UserAction.class);
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "one",method = RequestMethod.GET)
    public String getUser01(){
        log.info("one===>"+port);
        return "one===>"+port;
    }
    @RequestMapping(value = "two",method = RequestMethod.GET)
    public String getUser02(){
        log.info("one===>"+port);
        return "one===>"+port;
    }

}
