package com.sycamore.nextblog.adapter;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.sycamore.nextblog.components.cola.dto.Response;
import com.sycamore.nextblog.components.cola.dto.SingleResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * adapter 全局异常处理
 * @author 桑运昌
 */
@RestControllerAdvice
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
public class AdapterExceptionHandler {

    // 捕获方法参数校验异常
    @ExceptionHandler(ConstraintViolationException.class)
    public Response constraintViolationExceptionHandler(HttpServletRequest request,ConstraintViolationException e){
        log.error("[{}] {} [ex] {}", request.getMethod(), getUrl(request), e.getConstraintViolations().toString());
        SingleResponse<HashMap> response = new SingleResponse<>();
        response.setErrCode("1000");
        response.setErrMessage("异常请求");
        response.setSuccess(false);
        return response;
    }

    // 捕获实体参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response resolveMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        FieldError firstFieldError = CollectionUtil.getFirst(bindingResult.getFieldErrors());
        String exceptionStr = Optional.ofNullable(firstFieldError)
                .map(FieldError::getDefaultMessage)
                .orElse(StrUtil.EMPTY);
        log.error("[{}] {} [errorMsg] {}", request.getMethod(), getUrl(request), exceptionStr);
        SingleResponse<HashMap> response = new SingleResponse<>();
        response.setErrCode("1000");
        response.setErrMessage(exceptionStr);
        response.setSuccess(false);
        return response;
    }

    private String getUrl(HttpServletRequest request) {
        if (StringUtils.hasText(request.getQueryString())) {
            return request.getRequestURL().toString();
        }
        return request.getRequestURL().toString() + "?" + request.getQueryString();
    }
}