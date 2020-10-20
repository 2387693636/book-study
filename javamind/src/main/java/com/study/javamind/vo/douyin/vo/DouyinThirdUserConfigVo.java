package com.study.javamind.vo.douyin.vo;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/13 15:46
 */
public class DouyinThirdUserConfigVo {

    /**
     * 	抖音应用的唯一标识 client_key
     */
    private String clientKey;
    /**
     * 	自媒体的client_secret
     */
    private String clientSecret;

    /** 应用授权作用域,多个授权作用域以英文逗号（,）分隔*/
    private String scope;
    /**授权成功后的回调地址 */
    private String redirectUri;
    /** 用户扫码后的授权码 */
    private String code;
    private String accessToken;
    /** 绑定的登陆账户id */
    private String accountId;

    private Long hisId;

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }
    public DouyinThirdUserConfigVo(String scope, String accessToken, String refreshToken, String openId) {
        this.scope = scope;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.openId = openId;
    }
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    private String refreshToken;
    /** 授权用户唯一标识*/
    private String openId;

    // 回调的方法
    private String infoType;

    public DouyinThirdUserConfigVo(String accessToken) {
        this.accessToken = accessToken;
    }

    public DouyinThirdUserConfigVo() {
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
