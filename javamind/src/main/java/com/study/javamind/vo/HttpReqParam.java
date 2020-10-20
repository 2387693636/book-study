package com.study.javamind.vo;


import okhttp3.internal.http2.Header;

public class HttpReqParam {
    private static final long serialVersionUID = 1L;

    private String address;
    private String body;
    private String reqCharSet;
    private String respCharSet;
    private String contentType;
    private String soapAction;
    private Header[] headers;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getReqCharSet() {
        return reqCharSet;
    }

    public void setReqCharSet(String reqCharSet) {
        this.reqCharSet = reqCharSet;
    }

    public String getRespCharSet() {
        return respCharSet;
    }

    public void setRespCharSet(String respCharSet) {
        this.respCharSet = respCharSet;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getSoapAction() {
        return soapAction;
    }

    public void setSoapAction(String soapAction) {
        this.soapAction = soapAction;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }

    public HttpReqParam(String address, String body, String reqCharSet, String respCharSet, String contentType, String soapAction, Header[] headers) {
        this.address = address;
        this.body = body;
        this.reqCharSet = reqCharSet;
        this.respCharSet = respCharSet;
        this.contentType = contentType;
        this.soapAction = soapAction;
        this.headers = headers;
    }

    public HttpReqParam(String address) {
        this.address = address;
    }

    public HttpReqParam(String address, String body) {
        this.address = address;
        this.body = body;
    }

    public HttpReqParam() {
    }
}
