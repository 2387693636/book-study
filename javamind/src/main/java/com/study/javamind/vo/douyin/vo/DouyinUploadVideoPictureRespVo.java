package com.study.javamind.vo.douyin.vo;

/**
 * @author: zou_xq
 * @description: 视频封面图上传接口返回参数
 * 需要通过该接口将视频封面图文件上传获取封面图链接
 * @date: 2020/9/10 10:35
 */
public class DouyinUploadVideoPictureRespVo {

    /** 上传返回的参数 success failed */
    private String status;

    /** 成功返回 封面图片文件格式 */
    private String format;

    /** 成功返回的参数 视频封面图链接 */
    private String url;

    /** 错误码说明 */
    private Integer code;

    /** 错误原因 */
    private String reason;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
