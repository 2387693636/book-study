package com.study.javamind.util;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/10/13 11:50
 */
public class Image2Binary
{
    private static Logger log = LoggerFactory.getLogger(Image2Binary.class);

    public static File getFileByUrl(String url) throws UnknownHostException, IOException{
        File tmpFile = File.createTempFile("temp", ".tmp");//创建临时文件
        Image2Binary.toBDFile(url, tmpFile.getCanonicalPath());
        return tmpFile;
    }

    private static byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024*4];
        int n=0;
        while ( (n=in.read(buffer)) !=-1) {
            out.write(buffer,0,n);
        }
        return out.toByteArray();
    }

    /**
     * 网络文件转换为byte二进制
     * @Title: toByteArray
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param url
     * @param @return
     * @param @throws IOException    设定文件
     * @return byte[]    返回类型
     * @throws
     */
    private static byte[] toByteArray(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream in = new DataInputStream(conn.getInputStream());
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024*4];
        int n=0;
        while ( (n=in.read(buffer)) !=-1) {
            out.write(buffer,0,n);
        }
        return out.toByteArray();
    }

    /**
     * @throws IOException
     * @throws MalformedURLException
     * 网络文件转换为本地文件
     * @Title: toByteArray
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param url
     * @param @return
     * @param @throws IOException    设定文件
     * @return byte[]    返回类型
     * @throws
     */
    public static void toBDFile(String urlStr, String bdUrl) throws IOException,UnknownHostException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream in = new DataInputStream(conn.getInputStream());
        byte[] data=toByteArray(in);
        in.close();
        FileOutputStream out=new FileOutputStream(bdUrl);
        out.write(data);
        out.close();
    }

    /**
     * 直接获取网络文件的md5值
     * @param urlStr
     * @return
     */
    private static String getMd5ByUrl(String urlStr){
        String md5 = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            DataInputStream in = new DataInputStream(conn.getInputStream());
            md5 = DigestUtils.md5Hex(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return md5;
    }

    /**
     * 获取网络文件的输入流
     * @param urlStr
     * @return
     */
    private static InputStream getInputStreamByUrl(String urlStr){
        DataInputStream in = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            in = new DataInputStream(conn.getInputStream());
        } catch (IOException e) {
            log.error("url转换输入流失败,错误信息{}",e.getMessage());
        }
        return in;
    }
    private static String ReadVideoSize(File source) {
        FileChannel fc = null;
        String size = "";
        try {
            @SuppressWarnings("resource")
            FileInputStream fis = new FileInputStream(source);
            fc = fis.getChannel();
            BigDecimal fileSize = new BigDecimal(fc.size());
            size = fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP) + "MB";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fc) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return size;
    }


    public static void main(String[] args) throws IOException {
        File a = getFileByUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496324940814&di=1d70e0de447be6547c372718b9b30ff6&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F204%2F22%2FYMG9CAUWUM15.jpg");
        System.out.println(ReadVideoSize(a));
        System.out.println("视频大小：" + a.length() / 1024 + "kb");
    }
}