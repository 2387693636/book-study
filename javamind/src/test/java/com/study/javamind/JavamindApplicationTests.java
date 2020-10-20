package com.study.javamind;

import com.alibaba.fastjson.JSONObject;
import com.study.javamind.vo.UserVo;
import com.sun.corba.se.impl.encoding.CodeSetConversion;
import okhttp3.*;
import okio.ByteString;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.URL;

@SpringBootTest
class JavamindApplicationTests {

    @Test
    void contextLoads() {
        UserVo userVo = new UserVo();
        userVo.setText("aa");
        userVo.setPassword("ssd");
        String s = JSONObject.toJSONString(userVo);
        System.out.println(s);
        UserVo userVo1 = JSONObject.parseObject(s, UserVo.class);
        userVo1.setGender("wdew");
        System.out.println(JSONObject.toJSONString(userVo1));

        String s1 = JSONObject.toJSONString(userVo1);
        userVo1.setGender("ssdasdff");
        String s2 = JSONObject.toJSONString(userVo1);
        System.out.println(s2);

    }

    @Test
    void testOkhttp() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().followRedirects(false)
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.MIXED)
                .addFormDataPart("cover", "/C:/Users/xq2580z/Desktop/images/20200907151851.jpg",
                        okhttp3.RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/C:/Users/xq2580z/Desktop/images/20200907151851.jpg")))
                .addFormDataPart("caption", "哈哈哈哈是测试33")
                .build();
        Request request = new Request.Builder()
                .url("https://open.kuaishou.com/openapi/photo/publish?app_id=ks684828620219089813&access_token=ChFvYXV0aC5hY2Nlc3NUb2tlbhJgH-3qfrumDwEjWePNQJgmpfDIGWabfSJ1-BnpzKqhSw0lgMJXYqcWHoWWgNBpql0akk4maBBmYV91hYAeOzATJLuLnuFZSRiLrEDRm5qd3-wRyuek3kE2u365zJndL9L0GhLd637ev4BKL7l6Qm3dUiG-wociIHqZb0a32lIlFbJDpAtgcMDEusnCchE6mMwsQgd3AhQJKAUwAQ&upload_token=Cg51cGxvYWRlci50b2tlbhKuAgJguwitt_YXspKOL4J1uqC5l8BSZqM1AdwqgT69J1xKS14YmwoZmZave3_6AzkoJmpcMf_Le1UuHJgPB3pz1rhwtvvYiYT7PE1UihUJhSHse2GASBoHpT05hBTXhEHfQhG4dxI2cW_EvQ8v_AHEr-Z1QYh-G9cnzs54ejnKBnohGARrlV4uPfcv-jbQKV47hI-yJmICW2gHnzNd5FtLeaWAaIlq7UQnWOWx0VGpqWKyUb8Zqr-lWsTw3tKsihsV4WwPal5dgZGFAVTfDNpQDv7LZ71Ke-DOCHN82zZ0bLQf8pf67w0lbYmOG-aIxib_FBez2HHkEfheBDV4HPVGmfht7S0jogBNUMDwkGphHGCC3REe2IgUWnjas2JJ5qwbrBtUXpQQWpi_5cEXsRpcGhLr92Hi1iuvTctNGgLQh_PRmJYoBTAC")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(JSONObject.toJSONString(response));
    }

    @Test
    public void testUpload() throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .followRedirects(false)
                .build();
        MediaType mediaType = MediaType.parse("video/mp4");
        String srcStr ="D:\\testKuaishou.mp4";
        byte[] viedioBytes = InputStream2ByteArray(srcStr);
        RequestBody body = RequestBody.create(mediaType, viedioBytes);
        Request request = new Request.Builder()
                .url("https://upload.kuaishouzt.com/api/upload?upload_token=Cg51cGxvYWRlci50b2tlbhKuAji9jOP_CXm73JO4vq4h63_RTJgPVRLFB2Kx4dmKHZ9iofdoZ3HMhFPuqjT_grziLY7WU_o4k94SVHU1S-SIlTZB52kZ5rhQeBGWR_jkt-Nlbs52vTGIIqVZrDO5RMsrI3SVqWQEH1elUWlrHKvIdqlRJgNCcCcMbQJN-WKGmvYmJsJ9IkYbfIns_D29Q_yQw3vvR9DjYM70TQhwnAlfqwAGqYmmj3B6uu2tpJxAIq9-xV8A9hU2JKl_FLsJFbhMzU4OON316wBcz21MQODIm6KIY-ydXgPJ8Sbxdo25cEA6BVLTIdWzsBeBeyXEr27-zUUelq8Jt1iCNGKuS6Ku1Jj4TsfWnmnI1UvbO470He6X6sLcQP15dC4rnqpfaklJiphqvbx2tpneMd9PTSF8GhKkCRIKZo9ILWNN1flmDPsl1A4oBTAC")
                .method("POST", body)
                .addHeader("Content-Type", "video/mp4")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);
    }

    @Test
    public void testPublishVideo() throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .followRedirects(false)
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("cover","/C:/Users/xq2580z/Desktop/images/20200907151851.jpg",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/C:/Users/xq2580z/Desktop/images/20200907151851.jpg")))
                .addFormDataPart("caption", "哈哈哈哈是测试444")
                .build();
        Request request = new Request.Builder()
                .url("https://open.kuaishou.com/openapi/photo/publish?app_id=ks684828620219089813&access_token=ChFvYXV0aC5hY2Nlc3NUb2tlbhJg_iNrrNStIEuxt7qtBhVQd5eIfVJt8tbjasMLEj3_Obu00zWfJUF9O6D1WHZBef4-Xx-T9AAa0xEgH_unPBvoU50beCpkrZ-jPVXksMRh47ebs67umG4J0ZvO1bQrvzQBGhIox2aMP1NAhYDhzFzvRCKGAG0iIGOYAUNgXABtQNPk9bHNOekVv_yyHwtR_qBBqlEQbkijKAUwAQ&upload_token=Cg51cGxvYWRlci50b2tlbhKuAji9jOP_CXm73JO4vq4h63_RTJgPVRLFB2Kx4dmKHZ9iofdoZ3HMhFPuqjT_grziLY7WU_o4k94SVHU1S-SIlTZB52kZ5rhQeBGWR_jkt-Nlbs52vTGIIqVZrDO5RMsrI3SVqWQEH1elUWlrHKvIdqlRJgNCcCcMbQJN-WKGmvYmJsJ9IkYbfIns_D29Q_yQw3vvR9DjYM70TQhwnAlfqwAGqYmmj3B6uu2tpJxAIq9-xV8A9hU2JKl_FLsJFbhMzU4OON316wBcz21MQODIm6KIY-ydXgPJ8Sbxdo25cEA6BVLTIdWzsBeBeyXEr27-zUUelq8Jt1iCNGKuS6Ku1Jj4TsfWnmnI1UvbO470He6X6sLcQP15dC4rnqpfaklJiphqvbx2tpneMd9PTSF8GhKkCRIKZo9ILWNN1flmDPsl1A4oBTAC")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);
    }

    @Test
    public void testMul() throws Exception {
        // 文件sTestsetFile：solr_etl_agent35.json是存有JSON字符串的文件
        String sTestsetFile = "C:/Users/xq2580z/Desktop/images/20200907151851.jpg";
        String sURL = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(sURL);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);

        // 把文件加到HTTP的post请求中
        File f = new File(sTestsetFile);
        builder.addBinaryBody(
                "file",
                new FileInputStream(f),
                ContentType.APPLICATION_OCTET_STREAM,
                f.getName()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();
        String sResponse = EntityUtils.toString(responseEntity, "UTF-8");
        System.out.println("Post 返回结果" + sResponse);
    }

    @Test
    public void testFile() throws Exception {
        String url="https:\\sstatic.med.gzhc365.com\\fss\\publicfile\\7643cddfc1ccaf5e9c8dbb01adcc8ab9fd5ccdc0fd04b860903787360cf29b96.png";
        File f = new File(url);
        String[] temp = url.split("\\/");
        String fileName = temp[temp.length - 1];
        System.out.println(fileName);

        URL videoUrl = new URL(url);
        byte[] bytes = url.getBytes();
        System.out.println(bytes);
//        FileInputStream inputStream = new FileInputStream(f);
//        System.out.println(inputStream);
        System.out.println(f.getName());
    }


    @Test
    public void testFileUpload() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .followRedirects(false)
                .build();
        MediaType mediaType = MediaType.parse("video/mp4");

        String srcStr ="D:\\testKuaishou.mp4";
        byte[] viedioBytes = InputStream2ByteArray(srcStr);
        System.out.println(viedioBytes);
        String content = viedioBytes+"";
        System.out.println(content.getBytes());
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url("https://upload.kuaishouzt.com/api/upload?upload_token=Cg51cGxvYWRlci50b2tlbhKuAgJguwitt_YXspKOL4J1uqC5l8BSZqM1AdwqgT69J1xKS14YmwoZmZave3_6AzkoJmpcMf_Le1UuHJgPB3pz1rhwtvvYiYT7PE1UihUJhSHse2GASBoHpT05hBTXhEHfQhG4dxI2cW_EvQ8v_AHEr-Z1QYh-G9cnzs54ejnKBnohGARrlV4uPfcv-jbQKV47hI-yJmICW2gHnzNd5FtLeaWAaIlq7UQnWOWx0VGpqWKyUb8Zqr-lWsTw3tKsihsV4WwPal5dgZGFAVTfDNpQDv7LZ71Ke-DOCHN82zZ0bLQf8pf67w0lbYmOG-aIxib_FBez2HHkEfheBDV4HPVGmfht7S0jogBNUMDwkGphHGCC3REe2IgUWnjas2JJ5qwbrBtUXpQQWpi_5cEXsRpcGhLr92Hi1iuvTctNGgLQh_PRmJYoBTAC")
                .method("POST", body)
                .addHeader("Content-Type", "video/mp4")
                .build();
        Response response = client.newCall(request).execute();

        String stringBaseResult = JSONObject.toJSONString(response);
        System.out.println(("视频频上传结果为：{}" + stringBaseResult));
    }

    private byte[] InputStream2ByteArray(String filePath) throws IOException {

        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        in.close();

        return data;
    }

    private byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }


}
