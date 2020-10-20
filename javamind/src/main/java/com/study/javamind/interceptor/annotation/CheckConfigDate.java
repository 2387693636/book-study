package com.study.javamind.interceptor.annotation;

/**
 * @Description: 校验查询是否在限制的时间段内
 * @Author: caidian
 * @Date: 2020/10/15
 */
public @interface CheckConfigDate {
    /**
     * 资源代码
     * @return
     */
    String code();

    /**
     * 请求参数key(用于获取查询的开始时间和结束时间 格式yyyy-MM-dd)
     * String[0]为开始时间
     * String[1]为结束时间
     * @return
     */
    String[] requestKeys();

    /**
     * 错误信息
     * @return
     */
    String errorMsg();
}
