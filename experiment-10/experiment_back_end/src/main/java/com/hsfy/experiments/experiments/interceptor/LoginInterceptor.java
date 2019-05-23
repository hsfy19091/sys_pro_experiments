package com.hsfy.experiments.experiments.interceptor;

import com.hsfy.experiments.experiments.components.EncryptorComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    EncryptorComponent encryptorComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("登录拦截器开始工作");
        //这种写法有问题,具体原因不明
//        String token = Optional.ofNullable(request.getHeader("Authorization"))
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录"));

        String token = Optional.ofNullable(request.getHeader("Authorization"))
                //曲线救国,加密组件解密NoToken时会抛异常
                .orElse("NoToken");
        Map map = encryptorComponent.decrypt(token);
        request.setAttribute("uid", map.get("uid"));
        request.setAttribute("aid", map.get("aid"));
        return true;
    }
}
