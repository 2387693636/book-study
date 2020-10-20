package com.study.javamind.vo.douyin.vo;

/**
 * @author: zou_xq
 * @description: 视频封面图上传接口传入的参数
 * @date: 2020/9/10 10:41
 */
public class DouyinUploadVideoPictureReqVo {

    /** 视频封面图文件, 支持(jpeg,png,jpg), 最大支持5M */
    private String pic;

    private byte[] picContent;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public byte[] getPicContent() {
        return picContent;
    }

    public void setPicContent(byte[] picContent) {
        this.picContent = picContent;
    }
}
