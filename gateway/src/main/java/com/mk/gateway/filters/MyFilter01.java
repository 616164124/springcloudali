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

/**
 * 对请求的过滤
 */
@Component
public class MyFilter01 implements GlobalFilter, Ordered {
    public static final Long EXPIRE = 1000L;
    private static final Logger log = LoggerFactory.getLogger(MyFilter01.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********************自定义全局过滤器被执行 MyFilter01**********************");
        //请求
        ServerHttpRequest request = exchange.getRequest();

        //返回的结果
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getPath().toString();
        log.info("path=====>"+path);
        //
        if(path.contains("/login/register/common")){
        return chain.filter(exchange);
        }

        //重定向等等操作
        //继续往下执行
        return chain.filter(exchange);
    }

    /**
     * 多个过滤器的执行顺序
     *
     * @return int
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
