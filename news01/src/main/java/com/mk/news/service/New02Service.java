package com.mk.news.service;


import com.com.bean.User;
import com.mk.common.ServiceResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 调用外网地址的url
 */
@Component
@FeignClient(name = "feign-api", url = "http://localhost:10000")
public interface New02Service {

    @PostMapping("/asy/test01")
    ServiceResult get(User user);

}
