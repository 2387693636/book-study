package com.study.jvm.pojo;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/28 19:39
 */
public class JsonVo {

    private String param;
    private String status;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JsonVo{" +
                "param='" + param + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
