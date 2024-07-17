package com.sycamore.nextblog.adapter.filter.user;

import com.sycamore.nextblog.client.user.api.IUserBaseService;
import com.sycamore.nextblog.client.user.dto.resp.UserSessionMetadataQueryCO;
import com.sycamore.nextblog.infrastructure.UserContext;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * @author 桑运昌
 */
@Component
@Aspect
@Slf4j
public class AuthAspect {
    @Resource
    private IUserBaseService userBaseService;

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public AuthAspect(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
    @Pointcut("@within(com.sycamore.nextblog.adapter.filter.user.Authenticated) || @annotation(com.sycamore.nextblog.adapter.filter.user.Authenticated)")
    public void authenticated() {
    }

    @Around("authenticated()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.info("[{}] 请求头未包含 Authorization ",request.getRequestURI() );
            return null;
        }
        UserSessionMetadataQueryCO metaData = userBaseService.queryUserSessionMetadata(token);
        if (Objects.isNull(metaData) || !metaData.isValid() ){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.info("[{}] token 无效",request.getRequestURI());
            return null;
        }
        log.debug("userId: [ {} ]",metaData.getUserId());
        // 在这里解析 token 并填充用户上下文
        UserContext.setUser(metaData.getUserId(),metaData.getUserName());
        try {
            // 执行目标方法
            return joinPoint.proceed();
        } finally {
            // 清除用户上下文
            UserContext.clear();
        }


    }
}
