package com.hsfy.experiments.experiments.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Component
@Aspect
public class MyAspect {
    @Around("execution(* com.hsfy..*.buy*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint joinpoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinpoint.proceed();
        long end = System.nanoTime();
        log.info("方法：{}的执行时间:{}", joinpoint.getSignature().getName(), end - start);
        return result;
    }

    @Around("@within(myInterceptor)||@annotation(myInterceptor)")
    public Object getAuthor(ProceedingJoinPoint proceedingJoinPoint, MyInterceptor myInterceptor) throws Throwable {
        //出了点问题
        log.info("当前方法执行权限是:" +myInterceptor.value());
        return proceedingJoinPoint.proceed();
    }
}
