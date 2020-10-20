package com.study.javamind.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:  用于校验医院是否拥有该功能配置
 * @Author: caidian
 * @Date: 2020/9/24
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FunctionIsSupport {
    /**
     * 功能配置代码(可以支持传多个code)
     * @return
     */
    String[] bizCode();

    /**
     * 错误消息
     * @return
     */
    String errorMsg();
}

