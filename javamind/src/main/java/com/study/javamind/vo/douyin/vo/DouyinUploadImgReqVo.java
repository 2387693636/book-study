package com.study.javamind.vo.douyin.vo;

/**
 * @author: zou_xq
 * @description:  图片发布至抖音参数
 * @date: 2020/9/8 19:27
 */
public class DouyinUploadImgReqVo {
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
