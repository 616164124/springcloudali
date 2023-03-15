package com.mk.news.action;

import com.com.bean.User;
import com.mk.common.ServiceResult;
import com.mk.news.service.New01Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewsAction {

    private static final Logger log = LoggerFactory.getLogger(NewsAction.class);
    @Value("${server.port}")
    private String port;
    @Resource
    private New01Service new01Service;



    @RequestMapping(value = "new01",method = RequestMethod.GET)
    public ServiceResult getUser01(){
        log.info("new01===>"+port);
        User user = new User();
        user.setPassword("12331");
        ServiceResult serviceResult = new01Service.get(user,"hfuwkiekkw");
        serviceResult.setMsg(port);
        return  serviceResult;
    }

    @RequestMapping(value = "new02",method = RequestMethod.GET)
    public ServiceResult getUser02(){
        log.info("new01===>"+port);
        User user = new User();
        user.setPassword("12331");
        ServiceResult serviceResult = new01Service.get(user,"hjhfuiw");
        serviceResult.setMsg(port);
        return  serviceResult;
    }

}
