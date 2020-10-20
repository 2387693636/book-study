package com.study.javamind.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.alibaba.fastjson.JSON.toJSON;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/10/20 17:34
 */
public class JsonRespTool
{
    public static void writeJson(HttpServletResponse resp, String json) throws IOException
    {
        resp.setContentType("application/json");
        resp.getWriter().append(json);
        resp.getWriter().flush();
        resp.flushBuffer();
    }
    public static void writeJson(HttpServletResponse resp,Integer code,String msg,Object data) throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().append(
                toJSON(MapTool.getSOMap(
                        "code",code,
                        "msg",msg,
                        "data",data
                )).toString()
        );
        resp.getWriter().flush();
        resp.flushBuffer();
    }
    public static void writeJson(HttpServletResponse resp,Integer code,String msg) throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().append(
                toJSON(MapTool.getSOMap(
                        "code",code,
                        "msg",msg
                )).toString()
        );
        resp.getWriter().flush();
        resp.flushBuffer();
    }
}
