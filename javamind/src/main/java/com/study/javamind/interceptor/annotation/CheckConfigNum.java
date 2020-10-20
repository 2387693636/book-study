package com.study.javamind.interceptor.annotation;

/**
 * @Description: 校验医院资源是否充足
 * @Author: caidian
 * @Date: 2020/10/15
 */
public @interface CheckConfigNum {
    /**
     * 资源代码
     * @return
     */
    String code();

    /**
     * 请求参数key(用于获取本次使用数量)
     * @return
     */
    String requestKey();

    /**
     * 错误信息
     * @return
     */
    String errorMsg();
}
