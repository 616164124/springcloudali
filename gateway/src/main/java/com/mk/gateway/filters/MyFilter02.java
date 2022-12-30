package com.mk.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyFilter02 implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(MyFilter02.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //请求
        ServerHttpRequest request = exchange.getRequest();
        //返回的结果
        ServerHttpResponse response = exchange.getResponse();
        log.info("*********************自定义全局过滤器被执行 MyFilter02**********************");
        //继续往下执行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
