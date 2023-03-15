package com.mk.gateway.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RouteUtill  {

    private static final Logger log = LoggerFactory.getLogger(RouteUtill.class);

    @Resource
    private GatewayProperties gatewayProperties;

}
