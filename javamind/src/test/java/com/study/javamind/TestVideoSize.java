package com.study.javamind;

import com.study.javamind.util.Image2Binary;

import java.io.File;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/10/13 11:36
 */
public class TestVideoSize {
    /**
     * 获取网络文件，暂存为临时文件
     * @param url
     * @return
     * @throws Exception
     */
    public static File getFileByUrl(String url) throws Exception{
        File tmpFile = File.createTempFile("temp", ".tmp");//创建临时文件
        Image2Binary.toBDFile(url, tmpFile.getCanonicalPath());
        return tmpFile;
    }

    /**
     * 获取时长
     */
    public static long getDuration(File file) throws Exception{
//        MultimediaInfo m = new Encoder().getInfo(file);
//        return m.getDuration();
        return 0L;
    }

    /**
     * 获取http://mp4.res.hunantv.com/new_video/28/7A0B569858C4B58526273897A2321658_20170926_1_1_256.mp4
     * 时长信息和大小信息
     * @param args
     */
    public static void main(String[] args) {
        try {
            File file = getFileByUrl("http://mp4.res.hunantv.com/new_video/28/7A0B569858C4B58526273897A2321658_20170926_1_1_256.mp4");
            System.out.println("视频大小："+file.length()/1024+"kb");
            System.out.println("视频时长："+getDuration(file)/1000 + "s");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
