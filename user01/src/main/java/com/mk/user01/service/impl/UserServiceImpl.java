package com.mk.user01.service.impl;

import com.mk.common.CodeEnum;
import com.mk.common.ServiceResult;
import com.mk.user01.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public ServiceResult selectUser() {
        return ServiceResult.success(CodeEnum.SUCCESS, "user01===>selectUser");

    }
}
