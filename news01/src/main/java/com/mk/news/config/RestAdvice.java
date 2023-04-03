package com.mk.news.config;

import com.mk.common.CodeEnum;
import com.mk.common.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@RestControllerAdvice
public class RestAdvice implements ResponseBodyAdvice<Object> {


    private static final Logger log = LoggerFactory.getLogger(RestAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }

    //捕获自定义异常抛出异常信息
    @ExceptionHandler(RuntimeException.class)
    public ServiceResult getAdvice1(RuntimeException e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return ServiceResult.setEnum(CodeEnum.Exception, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResult getAdvice(MethodArgumentNotValidException e) {
        log.error(e.toString());
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        ServiceResult serviceResult = new ServiceResult();
        allErrors.forEach((error) -> {
            serviceResult.setMsg(error.getDefaultMessage());
        });
        serviceResult.setCode(CodeEnum.Exception.getCode());
        serviceResult.setFlag(true);
        return serviceResult;
    }
}
