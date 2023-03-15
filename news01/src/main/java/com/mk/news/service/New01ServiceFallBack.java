package com.mk.news.service;

import com.mk.common.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class New01ServiceFallBack implements New01Service {

    private static final Logger log = LoggerFactory.getLogger(New01ServiceFallBack.class);
    @Override
    public ServiceResult get(Object o, String token) {
        log.error("============error============"+token);
        return ServiceResult.defaultError();
    }
}
