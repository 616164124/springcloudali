package com.mk.news.action;


import com.com.bean.User;
import com.mk.common.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewsAction001 {

    @Resource
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    @GetMapping("/001/01")
    public ServiceResult get() {
        User user = new User();
        user.setPassword("12313");
        user.setUsername("jnfew");

        restTemplate.postForObject(url+"/one", user,ServiceResult.class );

        return ServiceResult.defaultSuccess();

    }

}
