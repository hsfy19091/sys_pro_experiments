package com.hsfy.experiments.experiments.interceptor;

import com.hsfy.experiments.experiments.component.EncryptorComponent;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    private EncryptorComponent encryptorComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Optional.ofNullable(request.getHeader("Authorization")).ifPresent(token->{
//            Map map = encryptorComponent.decrypt(token);
//            request.setAttribute("userName", map.get("userName"));
//        });
        if (request.getHeader("Authorization")==null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录");
        } else {
            Map map = encryptorComponent.decrypt(request.getHeader("Authorization"));
            request.setAttribute("userName", map.get("userName"));
        }
        return true;
    }
}
