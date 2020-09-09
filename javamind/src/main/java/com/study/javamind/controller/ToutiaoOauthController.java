package com.study.javamind.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.study.javamind.constant.TouTiaoConstant;
import com.study.javamind.result.BaseResult;
import com.sun.deploy.net.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zou_xq
 * @description: 头条号模拟登录 发布文章
 * @date: 2020/9/4 11:53
 */
@RestController
@RequestMapping("toutiao")
public class ToutiaoOauthController {


    @RequestMapping("/toOauthToutiao")
    public BaseResult<String> toOauthToutiao(String cookies)throws Exception  {
        //首先需要判断用户是否认证过，能否发布文章
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(TouTiaoConstant.AUTH_CONFIRM);

        httpPost.setHeader("Cookie",cookies);
        JSONObject j = new JSONObject();
        j.put("key", "value");
        StringEntity se = new StringEntity(j.toString());
        se.setContentType("text/json");
        httpPost.setEntity(se);
        HttpResponse response=httpClient.execute(httpPost);
        JSONObject obj =null;
        //if(response != null && response.getStatusLine().getStatusCode() == 200) {
            String result = EntityUtils.toString(response.getEntity());
            obj = JSONObject.parseObject(result);
        //}

        return BaseResult.success(obj.toJSONString());

    }

}
