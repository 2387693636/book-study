package com.study.javamind.vo;

import java.io.Serializable;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/1 16:52
 */
public class IdVo<T> implements Serializable {

    private T data;

    public IdVo() {
    }
    public IdVo(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
