package com.study.javamind.interceptor.annotation;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/10/19 10:43
 */
public @interface Annotation
{
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
