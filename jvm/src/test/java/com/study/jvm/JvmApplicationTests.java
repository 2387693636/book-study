package com.study.jvm;

//import com.alibaba.fastjson.JSONObject;
//import com.study.javamind.vo.UserVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.jvm.enums.LiveBizSettingKeyEnum;
import com.study.jvm.pojo.JsonVo;
import com.study.jvm.pojo.LiveBizSettingResultVo;
import com.study.jvm.service.PublishThirdPartyService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class JvmApplicationTests {
    @Autowired
    private PublishThirdPartyService thirdPartyService;
//
//    @Test
//    void contextLoads() {
//        String a = "aa";
//        String b = "bb";
//
//        UserVo accessToken = (UserVo) thirdPartyService.getAccessToken(a, b);
//        System.out.println(JSONObject.toJSONString(accessToken));
//    }
//
//    @Test
//    public void testEnums() {
//        String str = "live.replay.flag";
//        JSONObject json = new JSONObject();
//        json.put("c", "v");
//        json.put("z", "123n");
//        String s = json.toJSONString();
//        System.out.println(s);
//        System.out.println(json);
//    }
//
//    @Test
//    public void testbool() {
//        String str = "live.replay.flag";
//        JSONObject json = new JSONObject();
//        json.put("c", "v");
//        json.put("z", "123n");
//        json.put("sassd", null);
//        String s = json.toJSONString();
//        System.out.println(s);
//        System.out.println(json);
//
//        Boolean bo = true;
//        String result = "aas" +"."+ bo;
//        System.out.println(result);
//        System.out.println(LiveBizSettingKeyEnum.LIVE_REPLAY_FLAG.getCode() + "" + "dad");
//        String replayParam = null;
//        json.put(LiveBizSettingKeyEnum.LIVE_REPLAY_FLAG.getCode(), replayParam);
//        System.out.println(json);
//        String[] split = str.split(",");
//    }
//    @Test
//    public void testsp() {
//        JSONObject jsonStr = new JSONObject();
//        JSONObject replayJson = new JSONObject();
//        replayJson.put("status", "s");
//        replayJson.put("param", "p");
//        Object replay1 = jsonStr.put("replay", replayJson.toJSONString());
//        System.out.println(replay1);
//
//        JSONObject replayJson2 = new JSONObject();
//        replayJson2.put("status", "s2");
//        replayJson2.put("param", "p2");
//        Object replay = jsonStr.put("replay", replayJson2);
//        System.out.println(replay);
//        String data = "{\"shareContent\":{\\\"shareTitle\\\":\\\"test\\\",\\\"shareCover\\\":\\\"https://sstatic.med.gzhc365.com/fss/publicfile/e330bd55517267f043c207345bd0612954c877495fcd8d4d33aa018171e86eed.png\\\",\\\"shareImg\\\":\\\"https://sstatic.med.gzhc365.com/fss/publicfile/2cf05ef2d55e36b78f0b084da412cf7c11375b2cd7dab38d531ab6d0d532208f.png\\\"}}";
//        String s = StringEscapeUtils.unescapeJava(data);
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        System.out.println(jsonObject);
//
//    }
//
//    @Test
//    public void testAS() {
//        JSONObject jsonStr = new JSONObject();
//        jsonStr.put("shareContent", "{\"shareTitle\":\"test\",\"shareCover\":\"https://sstatic.med.gzhc365.com/fss/publicfile/e330bd55517267f043c207345bd0612954c877495fcd8d4d33aa018171e86eed.png\",\"shareImg\":\"https://sstatic.med.gzhc365.com/fss/publicfile/2cf05ef2d55e36b78f0b084da412cf7c11375b2cd7dab38d531ab6d0d532208f.png\"}");
//        String string = jsonStr.toString();
//        String string2 = jsonStr.toJSONString();
//        System.out.println(string);
//        System.out.println(string2);
//        String s = StringEscapeUtils.unescapeJava(string2);
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        System.out.println(jsonObject);
//
//    }

    @Test
    public void testJsono() {
        JSONObject jsonParam = new JSONObject();
//        jsonParam.put("status", "C");
//        jsonParam.put("type", "SAAS");
//        jsonParam.put("param", "");
//        List list = new ArrayList();
//        list.add(true);
//        list.add(true);
//        list.add(false);
//        list.add(true);
//        list.add(false);
//        for (Object o : list) {
//            if (o.equals(false)) {
//                jsonParam.put("status", "D");
//                jsonParam.put("type", "");
//                jsonParam.put("param", "");
//            }
//            System.out.println((jsonParam.toJSONString()));
//        }

        JSONObject defalutParam = new JSONObject();
        defalutParam.put("status", "C");
        defalutParam.put("param", "");
        jsonParam.put("notify", defalutParam);
        jsonParam.put("comment", defalutParam);
        jsonParam.put("advisory", defalutParam);
        jsonParam.put("registered", defalutParam);
        jsonParam.put("replay", defalutParam);
        jsonParam.put("share", defalutParam);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "S");
        jsonObject.put("type", "SAAS");
        jsonParam.put("replay", jsonObject);
        System.out.println(jsonParam);
    }

    @Test
    public void testJsonTOOb() {
        String jsondata="{\"contend\":[{\"bid\":\"22\",\"carid\":\"0\"},{\"bid\":\"22\",\"carid\":\"0\"}],\"result\":100,\"total\":2}";
        JSONObject jsonParam = new JSONObject();
        JSONObject defalutParam = new JSONObject();
        defalutParam.put("status", "C");
        defalutParam.put("param", "");
        jsonParam.put("notify", defalutParam);
        jsonParam.put("comment", defalutParam);
        jsonParam.put("advisory", defalutParam);
        jsonParam.put("registered", defalutParam);
        jsonParam.put("replay", defalutParam);
        jsonParam.put("share", defalutParam);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "S");
        jsonObject.put("type", "SAAS");
        jsonParam.put("replay", jsonObject);

        JSONObject obj= JSON.parseObject(jsondata);
        //map对象
        Map<JSONObject, Object> data =new HashMap<>();

        LiveBizSettingResultVo liveBizSettingResultVo = JSON.parseObject(jsonParam.toJSONString(), LiveBizSettingResultVo.class);
        JsonVo jsonVo = liveBizSettingResultVo.getAdvisory();
        System.out.println(jsonVo.getParam()+":"+jsonVo.getStatus());

        //循环转换
//        Iterator it =jsonParam.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<JSONObject, Object> entry = (Map.Entry<JSONObject, Object>) it.next();
//            data.put(entry.getKey(), entry.getValue());
//        }
//        System.out.println("map对象:"+data.toString());

    }


}
