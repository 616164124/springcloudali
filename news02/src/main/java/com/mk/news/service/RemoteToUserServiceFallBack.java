package com.mk.news.service;

import com.mk.common.CodeEnum;
import com.mk.common.ServiceResult;
import org.springframework.stereotype.Component;

@Component
public class RemoteToUserServiceFallBack implements RemoteToUserService {
    @Override
    public ServiceResult getUsr(Object user) {
        return ServiceResult.error(CodeEnum.ERROR,user);
    }
}
