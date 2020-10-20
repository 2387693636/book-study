package com.study.javamind;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.javamind.enums.FunctionTypeEnum;
import com.study.javamind.util.BaseResult;
import com.study.javamind.util.HttpFacade;
import com.study.javamind.vo.HttpReqParam;
import com.study.javamind.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.URLEncoder;
import java.util.*;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/10/13 15:41
 */
public class AAA
{
    @Autowired
    private HttpFacade httpFacade;
    @Test
    public void testaa()
    {
        String weiboPublishArticleUrl = "https://api.weibo.com/proxy/article/publish.json?title=%s&content=%s&cover=%s&text=%s&access_token=%s";
        String accessToken = "aaa";
        //String publishUrl = String.format(weiboPublishArticleUrl, accessToken, accessToken, accessToken, accessToken, accessToken);

        String encodeContent = URLEncoder.encode("asasdasfawfas我是大");
        String publishUrl = String.format(weiboPublishArticleUrl, "标题1111", encodeContent, "https://uop.med.gzhc365.com/propaganda/mch/images/logoIcon/bai_jia_hao.png", "标题1111", accessToken);

        System.out.println(publishUrl);
    }
    @Test
    public void testaaa()
    {
        String weiboPublishArticleUrl = "https://api.weibo.com/proxy/article/publish.json?title=%s&content=%s&cover=%s&text=%s&access_token=%s";
        String accessToken = "aaa";
        //String publishUrl = String.format(weiboPublishArticleUrl, accessToken, accessToken, accessToken, accessToken, accessToken);

        String encodeContent = URLEncoder.encode("asasdasfawfas我是大");
        String publishUrl = String.format(weiboPublishArticleUrl, "标题1111", encodeContent, "https://uop.med.gzhc365.com/propaganda/mch/images/logoIcon/bai_jia_hao.png", "标题1111", accessToken);

        BaseResult<String> post = httpFacade.post(new HttpReqParam(publishUrl));
        System.out.println(post.checkAndGetData());
    }

    @Test
    public void testDS()
    {
        UserVo userVo = new UserVo();
        userVo.setPassword("sss");
        userVo.setText("sdasd");
        System.out.println(JSONObject.toJSONString(userVo));

    }

    @Test
    public void testEnums()
    {
        System.out.println(FunctionTypeEnum.FUNCTION_TYPE_VIDEO_STORAGE.code);
        System.out.println(FunctionTypeEnum.FUNCTION_TYPE_VIDEO_STORAGE.getCode());
        int a = -1;

        System.out.println(a);
        System.out.println(a+5);

    }

    @Test
    public void testJSON()
    {
        List<UserVo> list = new ArrayList<>();
        UserVo userVo = new UserVo();
        userVo.setText("sdfaf");
        list.add(userVo);
        String string = JSON.toJSON(list).toString();
        System.out.println(string);
        String text = "SDAS";
        List<JSONObject> jsonObjectList = JSON.parseArray(string, JSONObject.class);
        // 遍历json数组并取出想要的数据
        for (JSONObject jsonObject2 : jsonObjectList) {
            text = Objects.isNull(jsonObject2.getString("text")) ? "1" : jsonObject2.getString("text");
        }
        System.out.println(text);
    }

}
