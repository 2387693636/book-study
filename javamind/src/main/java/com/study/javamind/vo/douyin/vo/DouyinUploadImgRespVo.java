package com.study.javamind.vo.douyin.vo;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/8 19:24
 */
public class DouyinUploadImgRespVo {
    /**
     * 上传img至一点平台获取到的url
     */
    private String url;

    private Integer code;

    private String msg;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
