package com.study.jvm.pojo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: zou_xq
 * @description: 返回结果状态信息
 * @date: 2020/9/28 19:21
 */
public class LiveBizSettingResultVo {
    public JsonVo getNotify() {
        return notify;
    }

    public void setNotify(JsonVo notify) {
        this.notify = notify;
    }

    public JsonVo getComment() {
        return comment;
    }

    public void setComment(JsonVo comment) {
        this.comment = comment;
    }

    public JsonVo getAdvisory() {
        return advisory;
    }

    public void setAdvisory(JsonVo advisory) {
        this.advisory = advisory;
    }

    public JsonVo getRegistered() {
        return registered;
    }

    public void setRegistered(JsonVo registered) {
        this.registered = registered;
    }

    public JsonVo getReplay() {
        return replay;
    }

    public void setReplay(JsonVo replay) {
        this.replay = replay;
    }

    public JsonVo getShare() {
        return share;
    }

    public void setShare(JsonVo share) {
        this.share = share;
    }

    private JsonVo notify;
    private JsonVo comment;
    private JsonVo advisory;
    private JsonVo registered;
    private JsonVo replay;
    private JsonVo share;

    @Override
    public String toString() {
        return "LiveBizSettingResultVo{" +
                "notify=" + notify +
                ", comment=" + comment +
                ", advisory=" + advisory +
                ", registered=" + registered +
                ", replay=" + replay +
                ", share=" + share +
                '}';
    }
}
