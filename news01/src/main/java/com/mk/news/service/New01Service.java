package com.mk.news.service;

import com.mk.common.ServiceResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(value = "user",fallback =New01ServiceFallBack.class)
public interface New01Service  {

    @GetMapping(value = "/one")
    ServiceResult get(@RequestBody Object o, @RequestHeader(name="token",required = true) String token);


}
