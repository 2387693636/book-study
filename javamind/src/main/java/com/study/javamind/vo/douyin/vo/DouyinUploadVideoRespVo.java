package com.study.javamind.vo.douyin.vo;

import java.util.Date;

/**
 * @author: zou_xq
 * @description: 上传视频获取postUrl响应参数
 * @date: 2020/9/10 10:46
 */
public class DouyinUploadVideoRespVo {
    /** 上传返回的参数 success failed */
    private String status;

    /** 成功返回 文件格式 */
    private String contentType;

    /** 成功返回的参数 视频链接 */
    private String url;
    /** 成功返回	授权token */
    private String token;
    /** 成功返回 授权时间 */
    private Date date;

    /** 失败码 1：缺少参数 ； 2:文件后缀错误*/
    private Integer errcode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }
}
