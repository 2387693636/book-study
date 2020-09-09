package com.study.javamind;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.study.javamind.constant.RssConstant;
import com.study.javamind.constant.TouTiaoConstant;
import com.study.javamind.controller.KuaichuanRssController;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.io.IOUtil;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.DocFlavor;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
class JavamindApplicationTests {

    @Test
    void contextLoads() throws MalformedURLException, FeedException {
        KuaichuanRssController controller = new KuaichuanRssController();
        controller.parseXml(new URL(RssConstant.RSS_URL));
    }

    @Test
    void testRSS() {
        try {
            //String url = "http://localhost:8080/rss";

            try (XmlReader reader = new XmlReader(new URL(RssConstant.RSS_URL))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                System.out.println(feed.getTitle());
                System.out.println("***********************************");
                SyndEntry entry = feed.getEntries().get(0);
                System.out.println(entry);
                System.out.println("***********************************");

                System.out.println("Done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void teesCookies() throws IOException {
        // 测试cookies模拟登录
        String cookieVal = "MONITOR_WEB_ID=d28d99dd-c25e-4f48-acdf-bd3c6dd770be; WIN_WH=1280_946; PIXIEL_RATIO=1; UM_distinctid=1744d9734ac3ca-03c42c706eb758-31647304-2a3000-1744d9734ad71a; _ba=BA0.2-20200902-5110e-0STwoJBLEIDg3AFO5Pwu; s_v_web_id=verify_kel0ya4t_6AMwWO04_LRqJ_4LOE_9vVA_Ve4tXuoiPuTz; xigua_csrf_token=O6WckJD9yMkCitu_GejL8kWI; CNZZDATA1272960458=840065659-1599029366-%7C1599185890; CNZZDATA1273049018=1045828107-1599029382-%7C1599183435; passport_csrf_token=b4aaba608d380b6dd399f30e31347c8d; sso_auth_status=1995744dc0749274d1e2ba623ca64ac3; sso_uid_tt=535be55fd899ef927a72c11531722fc9; sso_uid_tt_ss=535be55fd899ef927a72c11531722fc9; toutiao_sso_user=fc48cb49bd6edc4a348032ce628e85b4; toutiao_sso_user_ss=fc48cb49bd6edc4a348032ce628e85b4; passport_auth_status=4b12585dced6814f75ecfd25b5203c0a%2C29a0183927efb24074f34c54669944f2; sid_guard=9ea7fa9b1d86d2dc027238528d801235%7C1599187539%7C5184000%7CTue%2C+03-Nov-2020+02%3A45%3A39+GMT; uid_tt_ss=740b99ecb9403d11e05d452f7da2a80c; sid_tt=9ea7fa9b1d86d2dc027238528d801235; sessionid=9ea7fa9b1d86d2dc027238528d801235; sessionid_ss=9ea7fa9b1d86d2dc027238528d801235; tt_webid=6868458125897991687; uid_tt=740b99ecb9403d11e05d452f7da2a80c8ffe84610153b0089ce4c92e6a995bcc; gftoken=OWVhN2ZhOWIxZHwxNTk5MTg4MzA3MDF8fDAGBgYGBgY; tt_scid=tJL1ZcQzjDZ.fie7VbVpExid0WAL0IQVUTVbDevTLPqrcAy5EM2H2wEqNDLJiA8c8076";
        URL url = new URL(TouTiaoConstant.TOUTIAO_AUTH);
        HttpURLConnection resumeConnection = (HttpURLConnection) url.openConnection();
        File file = new File("D:\\IDEA\\projects\\xq2580z\\xq-read-book\\javamind\\src\\main\\resources\\a.txt");
        //发送cookie信息上去，以表明自己的身份，否则会被认为没有权限
        resumeConnection.setRequestProperty("Cookie", cookieVal);
        resumeConnection.connect();
        InputStream urlStream = resumeConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(urlStream));
        String ss = null;
        String total = "";
        while ((ss = bufferedReader.readLine()) != null) {
            total += ss;
        }
        System.out.println(resumeConnection.getResponseMessage());
        IOUtil.writeText(total, file);

        //发布文章
        URL url1 = new URL(TouTiaoConstant.TOUTIAO_PUBLISH);
        HttpURLConnection resumeConnection1 = (HttpURLConnection) url1.openConnection();
        resumeConnection1.setRequestProperty("Cookie", cookieVal);
        resumeConnection1.connect();
        InputStream urlStream1 = resumeConnection1.getInputStream();
        BufferedReader bufferedReader1 = new BufferedReader(
                new InputStreamReader(urlStream));
        String ss1 = null;
        String total1 = "";
        while ((ss1 = bufferedReader1.readLine()) != null) {
            total1 += ss1;
        }
        System.out.println(resumeConnection1.getResponseMessage());
        IOUtil.writeText(total, file);

        bufferedReader.close();
    }

    @Test
    public void testPublishArticle() throws IOException {
        //发布文章首先需要判断是否有发文权限
        String cookieVal = "MONITOR_WEB_ID=d28d99dd-c25e-4f48-acdf-bd3c6dd770be; WIN_WH=1280_946; PIXIEL_RATIO=1; UM_distinctid=1744d9734ac3ca-03c42c706eb758-31647304-2a3000-1744d9734ad71a; _ba=BA0.2-20200902-5110e-0STwoJBLEIDg3AFO5Pwu; s_v_web_id=verify_kel0ya4t_6AMwWO04_LRqJ_4LOE_9vVA_Ve4tXuoiPuTz; xigua_csrf_token=O6WckJD9yMkCitu_GejL8kWI; CNZZDATA1272960458=840065659-1599029366-%7C1599185890; CNZZDATA1273049018=1045828107-1599029382-%7C1599183435; passport_csrf_token=b4aaba608d380b6dd399f30e31347c8d; sso_auth_status=1995744dc0749274d1e2ba623ca64ac3; sso_uid_tt=535be55fd899ef927a72c11531722fc9; sso_uid_tt_ss=535be55fd899ef927a72c11531722fc9; toutiao_sso_user=fc48cb49bd6edc4a348032ce628e85b4; toutiao_sso_user_ss=fc48cb49bd6edc4a348032ce628e85b4; passport_auth_status=4b12585dced6814f75ecfd25b5203c0a%2C29a0183927efb24074f34c54669944f2; sid_guard=9ea7fa9b1d86d2dc027238528d801235%7C1599187539%7C5184000%7CTue%2C+03-Nov-2020+02%3A45%3A39+GMT; uid_tt_ss=740b99ecb9403d11e05d452f7da2a80c; sid_tt=9ea7fa9b1d86d2dc027238528d801235; sessionid=9ea7fa9b1d86d2dc027238528d801235; sessionid_ss=9ea7fa9b1d86d2dc027238528d801235; tt_webid=6868458125897991687; uid_tt=740b99ecb9403d11e05d452f7da2a80c8ffe84610153b0089ce4c92e6a995bcc; gftoken=OWVhN2ZhOWIxZHwxNTk5MTg4MzA3MDF8fDAGBgYGBgY; tt_scid=tJL1ZcQzjDZ.fie7VbVpExid0WAL0IQVUTVbDevTLPqrcAy5EM2H2wEqNDLJiA8c8076";
        //账户信息
        URL url = new URL(TouTiaoConstant.TOUTIAO_SPELL_CHECK);
        HttpURLConnection resumeConnection = (HttpURLConnection) url.openConnection();

        //发送cookie信息上去，以表明自己的身份，否则会被认为没有权限
        resumeConnection.setRequestProperty("Cookie", cookieVal);

        resumeConnection.connect();
        System.out.println(resumeConnection.getResponseMessage());
        System.out.println(resumeConnection.getResponseCode());
        System.out.println(resumeConnection.getRequestMethod());
        if ("200".equals(resumeConnection.getResponseCode())) {
            System.out.println("链接失败");
        }


    }

    @Test
    public  void testTrim() {
        String img = "[\"https://sstatic.med.gzhc365.com/fss/publicfile/1a8cd02f4b428d6e48a12cae5aad2810ec1845f5e0f7866e15290bf6c4c749c9.JPG\"]";
        String replace = img.replace("[", "").replace("]", "");
        System.out.println(replace);
    }

    @Test
    public  void testGetAccessTokenUrl() {
        String meida_id = "aaa";
        String client_secret = "bbb";

        String yidianAccessTokenUrl="https://open-mp.yidianzixun.com/apis/auth/token?grant_type=client_credentials&client_id=%s&client_secret=%s";
        String format = String.format(yidianAccessTokenUrl, meida_id, client_secret);
        System.out.println(format);
    }



}
