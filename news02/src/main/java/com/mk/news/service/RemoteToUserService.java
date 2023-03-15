package com.mk.news.service;

import com.mk.common.ServiceResult;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "user",fallback = RemoteToUserServiceFallBack.class)
@Component
public interface RemoteToUserService {

    @PostMapping(value = "one",headers = "")
    @Hystrix
    ServiceResult getUsr(Object user);
}
