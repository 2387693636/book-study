package com.study.javamind.vo.douyin.vo;

/**
 * @author: zou_xq
 * @description: 抖音视频接口响应参数
 * @date: 2020/9/10 10:03
 */
public class DouyinPublishVideoRespVo {
    /** 成功返回	抖音视频id  **/
    private String itemId;
    /** 错误码描述  **/
    private String description;

    /** 拓展字段信息  **/
    private String extra;
    /** 返回结果码 0:成功 非0：失败 **/
    private Integer errorCode;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public DouyinPublishVideoRespVo(String itemId, String description, String extra, Integer errorCode) {
        this.itemId = itemId;
        this.description = description;
        this.extra = extra;
        this.errorCode = errorCode;
    }

    public DouyinPublishVideoRespVo() {
    }

    public DouyinPublishVideoRespVo(String extra) {
        this.extra = extra;
    }


}
