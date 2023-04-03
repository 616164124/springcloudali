package com.mk.news.action;


import cn.hutool.core.lang.Snowflake;
import com.com.bean.User;
import com.mk.common.CodeEnum;
import com.mk.common.ServiceResult;
import com.mk.news.bo.UserBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class NewsAction001 {

    private static final Logger log = LoggerFactory.getLogger(NewsAction001.class);

    @Resource
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    @GetMapping("/001/01")
    public ServiceResult get() {
        long l = new Snowflake().nextId();
        System.out.println(l);
        User user = new User();
        user.setPokid(l + "");
        user.setPassword("12313");
        user.setUsername("jnfew");

        ServiceResult serviceResult = restTemplate.postForObject(url + "/one", user, ServiceResult.class);
        if (!"000000".equals(serviceResult.getCode())) {
            return ServiceResult.defaultError();
        }

        return ServiceResult.setEnum(CodeEnum.SUCCESS, serviceResult.getData());

    }

    @PostMapping(value = "/001/02")
    public ServiceResult get02(@RequestBody @Validated UserBo userBo, HttpServletRequest request) {
        log.info(userBo.toString() + "=======");
        userBo.setId(new Snowflake().nextIdStr());
        return ServiceResult.successObject(userBo);
    }

}
