package com.hsfy.experiments.experiments.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyInterceptor {
    AuthorType[] value() default AuthorType.USER;
    public static enum AuthorType{
        USER,ADMIN,SUPERADMIN
    }
}
