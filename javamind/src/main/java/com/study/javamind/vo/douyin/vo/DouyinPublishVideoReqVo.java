package com.study.javamind.vo.douyin.vo;

/**
 * @author: zou_xq
 * @description: 抖音视频接口传入参数
 * @date: 2020/9/10 10:03
 */
public class DouyinPublishVideoReqVo {

    /** 视频标题 **/
    private String text;
    /** 通过/video/upload/接口得到 调用时刷新**/
    private String videoId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

}


