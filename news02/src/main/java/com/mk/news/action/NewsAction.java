package com.mk.news.action;

import com.mk.common.CodeEnum;
import com.mk.common.ServiceResult;
import com.mk.news.service.RemoteToUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class NewsAction {

    private static final Logger log = LoggerFactory.getLogger(NewsAction.class);
    @Value("${server.port}")
    private String port;



    @RequestMapping(value = "new01",method = RequestMethod.GET)
    public String getUser01(){
        log.info("one===>"+port);
        return "one===>"+port;
    }

    @RequestMapping(value = "newToUser",method = RequestMethod.GET)
    public ServiceResult newToUser(){
        log.info("port====>"+port);

        return ServiceResult.success(CodeEnum.SUCCESS,port);
    }

}
