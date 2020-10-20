package com.study.javamind.vo.douyin.vo;

import java.io.Serializable;

/**
 * @author: zou_xq
 * @description: 抖音配置
 * @date: 2020/9/8 18:51
 */
public class DouyinConfigVo implements Serializable {
    private static final long serialVersionUID = 9156826624206672902L;
    /**
     * 	抖音应用的唯一标识 client_key
     */
    private String clientKey;
    /**
     * 	自媒体的client_secret
     */
    private String clientSecret;

    /** access_token 全局唯一接口调用凭据 调用各接口时都需使用access_token*/
    private String accessToken;
    /** 应用授权作用域,多个授权作用域以英文逗号（,）分隔*/
    private String scope;
    /**授权成功后的回调地址 */
    private String redirectUri;

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    /**
     * 平台编号
     */
    private String platformId;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }


    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
