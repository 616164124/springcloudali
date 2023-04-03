package com.mk.news.service;

import com.mk.common.ServiceResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(value = "user",fallback =New01ServiceFallBack.class,name = "user")
public interface New01Service  {

    @PostMapping(value = "/one")
    ServiceResult get(@RequestBody Object o, @RequestHeader(name="token",required = true) String token);


}
