package com.mk.gateway.filters;

import com.alibaba.fastjson.JSON;
import com.mk.common.ServiceResult;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 对返回值进行过滤 （看情况把过滤器放在合适的位置用返回的order方法来进行操作） order返回值小于-1
 *
 */
@Component
public class MyFilter02 implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(MyFilter02.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********************自定义全局过滤器被执行 MyFilter01**********************");
        ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
                    return super.writeWith(fluxBody.map(dataBuffer -> {
                        // probably should reuse buffers
                        byte[] content = new byte[dataBuffer.readableByteCount()];
                        dataBuffer.read(content);
                        //释放掉内存
                        DataBufferUtils.release(dataBuffer);

                        /****************这部分可以对返回值进行修改*********************/
                        String s = new String(content, Charset.forName("UTF-8"));
                        log.info("sssssssssssss===>"+s);
                        ServiceResult serviceResult = JSON.parseObject(s, ServiceResult.class);
                        if ("000000".equals(serviceResult.getCode())) {
                            serviceResult.setMsg("kkk");
                        }
                        s=serviceResult.toString();
                        serviceResult=null;
                        //TODO，s就是response的值，想修改、查看就随意而为了
                        byte[] uppedContent = new String(s.getBytes(StandardCharsets.UTF_8), Charset.forName("UTF-8")).getBytes();
                        /********************************************************/

                        return bufferFactory.wrap(uppedContent);
                    }));
                }
                // if body is not a flux. never got there.
                return super.writeWith(body);
            }
        };
        // replace response with decorator
        return chain.filter(exchange.mutate().response(decoratedResponse).build());
    }


    @Override
    public int getOrder() {
        return -2;
    }
}
