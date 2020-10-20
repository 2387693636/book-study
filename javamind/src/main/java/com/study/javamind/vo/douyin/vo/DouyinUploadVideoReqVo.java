package com.study.javamind.vo.douyin.vo;

/**
 * @author: zou_xq
 * @description: 上传视频获取postUrl参数
 * @date: 2020/9/10 10:46
 */
public class DouyinUploadVideoReqVo {
    /** 待上传视频名称, 支持格式（mp4,mkv,flv,f4v,swf,wmv,avi,mov,rmvb,3gp,vob） **/
    private String fileName;

    private byte[] fileContent;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
}
