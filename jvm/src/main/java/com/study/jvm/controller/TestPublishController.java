package com.study.jvm.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/29 14:18
 */
public class TestPublishController {
//    /** 测试使用 **/
//    @RequestMapping(value = "/publishToutiao",method = {RequestMethod.POST})
//    public BaseResult<String> publishToutiao(PublishMaterialVo vo) {
//        LOGGER.info("同步头条号开始---->");
//        ToutiaoArticleVo toutiaoArticleParam = new ToutiaoArticleVo();
//        MaterialEntity materialEntity = materialMapper.selectByPrimaryKey(vo.getMaterialId());
//        toutiaoArticleParam.setMaterialEntity(materialEntity);
//        toutiaoArticleParam.setPfType("3");
//        UserChannelAuthenticationParamVo paramVo = new UserChannelAuthenticationParamVo();
//        paramVo.setHisId(vo.getHisId());
//        paramVo.setPfType(PFTypeEnum.PF_TYPE_3.code);
//        //通过hisId、psType查出认证信息 cookie
//        toutiaoArticleParam.setCookies("ttcid=46011c30721344299f931d140dad79e529; WEATHER_CITY=%E5%8C%97%E4%BA%AC; csrftoken=cce32b75b1bca3c3bc7b13bb5b36d864; UM_distinctid=17452cfbd93134-025e34ebe7ade4-f7b1332-1fa400-17452cfbd94910; odin_tt=f19ca572153124a8f61d5f01470811c8ac4b0264bfff89daa0ea7e0f17fa2723ffab5faf60c1c93accde1a6b82916b56f09ec47530bab05dddfa9275a9b0c065; passport_auth_status=b18acbaca40ba8a5996787e97d814fde%2Cfa2d47fb85a2731e0db7e3a52523a426; ccid=12633176804d42f48af9101ae8ce0322; _ga=GA1.2.1981622762.1599120195; _gid=GA1.2.1934055062.1599120195; s_v_web_id=verify_keocuq9e_Pu4TfK8C_M49r_4YYj_9Zaq_BuHTItgW9yvX; CNZZDATA1272960458=1726736023-1599116929-%7C1599230806; __tasessionId=1io9yvu0i1599231013274; tt_webid=6868644891003618824; tt_webid=6868644891003618824; passport_csrf_token=7036ceda3610d81f0b5e5d0314bb0ef4; __ac_nonce=05f52576700d2db11b2ad; __ac_signature=_02B4Z6wo00f01kJyFTQAAIBC-rRrauvLauJCdhGAAM.bQsDyZeIFHSqVQ67zqcZVp6E3lofXp86d54GnXWYWE7SMd89t5eAVO9PZCGbNfNjPclLioKBgMv2QXpYenwz5dmcOfiRhiO5cb8JH21; MONITOR_WEB_ID=74e99b22-e103-4d79-8d5e-ae3a7193075c; tt_scid=.-5OmlCkUc6A77Ot-nIJowVDCWOO7MT2OdjKW6FF6C.h6EPo6uCGXFLKBqhRUwqc26d0; sso_uid_tt=3a00698f4a8f51455fa35ee030316713; sso_uid_tt_ss=3a00698f4a8f51455fa35ee030316713; toutiao_sso_user=81696696701c77589e3fe353de2102e7; toutiao_sso_user_ss=81696696701c77589e3fe353de2102e7; sid_guard=e3437299ffd503797f83572df41a67ae%7C1599232028%7C5184000%7CTue%2C+03-Nov-2020+15%3A07%3A08+GMT; uid_tt=1141bff528b9aca7657f30541d501a49; uid_tt_ss=1141bff528b9aca7657f30541d501a49; sid_tt=e3437299ffd503797f83572df41a67ae; sessionid=e3437299ffd503797f83572df41a67ae; sessionid_ss=e3437299ffd503797f83572df41a67ae");
//        //发布相关文章信息到头条平台
//        LOGGER.info("同步头条平台开始，参数信息：{}--->", JSONObject.toJSONString(toutiaoArticleParam));
//        BaseResult<String> stringBaseResult = toutiaoPublishService.toutiaoPublish(toutiaoArticleParam);
//        LOGGER.info("同步头条平台完成，头条平台返回信息：{}--->", JSONObject.toJSONString(stringBaseResult));
//        if (0 != stringBaseResult.getCode()) {
//            LOGGER.info("同步失败,{}",stringBaseResult.getMsg());
//            return BaseResult.fail(stringBaseResult.getMsg());
//        }
//        return BaseResult.success(stringBaseResult.getMsg());
//    }
//
//    @RequestMapping(value = "/getArticle",method = {RequestMethod.POST})
////    public BaseResult<String> publishWeibo() {
////        WeiboThirdUserCfgVo weiboConfigVo = new WeiboThirdUserCfgVo();
////
////        WeiboArticleReqVo weiboArticleReqVo = new WeiboArticleReqVo();
////        weiboArticleReqVo.setTitle("测试标题1");
////        weiboArticleReqVo.setContent("测试内容1111");
////        weiboArticleReqVo.setCover("");
////        //同步的微博文本内容
////        weiboArticleReqVo.setText("测试发微博内容111");
////
////        //通过hisId和平台类型5得到平台账户的关于client_id和secret,再去得到access_token
//////        String accountInfo = "{\"clientId\": \"2861957868\",\"clientSecret\": \"d5a11362b7fff8830bd6b6cca26e6c64\"\n" +
//////                "{\"clientId\": \"2861957868\",\"clientSecret\": \"d5a11362b7fff8830bd6b6cca26e6c64\"\n" +
//////                ",\"redirectUri\":\"http://23347e7v58.imwork.net/api/mch/weibo/authredirect\"}";
//////        JSONObject obj1 = JSONObject.parseObject(accountInfo);
////        weiboConfigVo.setClientId("2861957868");
////        weiboConfigVo.setClientSecret("d5a11362b7fff8830bd6b6cca26e6c64");
////        weiboConfigVo.setCode("");
////        weiboConfigVo.setPlatformId("5");
////        WeiboArticleRespVo weiboArticleRespVo = weiboPublishArticleService.publishWeiboArticle(weiboArticleReqVo, httpFacade, weiboConfigVo);
////        if (!StringUtils.equals("0", weiboArticleRespVo.getCode())) {
////            LOGGER.info("同步新浪微博文章失败---->，原因：{}", weiboArticleRespVo.getMsg());
////        } else {
////            LOGGER.info("同步新浪微博文章结束---->");
////        }
////        return BaseResult.success(weiboArticleRespVo.getData());
////    }

//    @RequestMapping(value = "/getArticle",method = {RequestMethod.POST})
//    public BaseResult<String> testDouyin() {
//        DouyinThirdUserConfigVo userConfigVo = new DouyinThirdUserConfigVo();
//        userConfigVo.setClientKey("aw6f2s2ws2qz6x3w");
//        userConfigVo.setClientSecret("f0667b3debd6fe6001f5191d0dc08c67");
//        userConfigVo.setScope("user_info,video.create");
//        userConfigVo.setCode("8zAYVNuXmvd3Qewys1d3YVhjohVxpdwYShoF");
//        DouyinPublishVideoReqVo videoReqVo = new DouyinPublishVideoReqVo();
//        Long relVideoId = 18L;
//        BaseResult<GetMediaUrlResultVo> mediaUrl = videoFacade.getMediaUrl(new IdVo<>(relVideoId));
//        MediaUrlResultVo videoUrl = new MediaUrlResultVo();
//        if (mediaUrl.checkAndGetData() != null) {
//            //视屏文件
//            videoUrl.setMediaUrl(mediaUrl.getData().getMediaUrl());
//            videoUrl.setCoverUrl(mediaUrl.getData().getCoverUrl());
//        }
//        //视频素材标题
//        videoReqVo.setText("hello");
//        //这里查出的内容为json格式 在用户登陆授权回调的时候写入，在此处查
//        DouyinThirdUserConfigVo accessToken = douyinPublishService.getAccessToken(httpFacade, userConfigVo);
//        DouyinPublishVideoRespVo douyinPublishVideoRespVo = douyinPublishService.publishVideo(videoUrl, videoReqVo, httpFacade, accessToken);
//        if (douyinPublishVideoRespVo.getErrorCode() == 0) {
//
//        } else {
//
//        }
//        return BaseResult.success();
//    }
//    @RequestMapping(value = "/getArticle",method = {RequestMethod.POST})
//    public BaseResult<String> testDouyin() {
//        DouyinThirdUserConfigVo userConfigVo = new DouyinThirdUserConfigVo();
//        userConfigVo.setClientKey("aw6f2s2ws2qz6x3w");
//        userConfigVo.setClientSecret("f0667b3debd6fe6001f5191d0dc08c67");
//        userConfigVo.setScope("user_info,video.create");
//        userConfigVo.setCode("8zAYVNuXmvd3Qewys1d3YVhjohVxpdwYShoF");
//        DouyinPublishVideoReqVo videoReqVo = new DouyinPublishVideoReqVo();
//        Long relVideoId = 18L;
//        BaseResult<GetMediaUrlResultVo> mediaUrl = videoFacade.getMediaUrl(new IdVo<>(relVideoId));
//        MediaUrlResultVo videoUrl = new MediaUrlResultVo();
//        if (mediaUrl.checkAndGetData() != null) {
//            //视屏文件
//            videoUrl.setMediaUrl(mediaUrl.getData().getMediaUrl());
//            videoUrl.setCoverUrl(mediaUrl.getData().getCoverUrl());
//        }
//        //视频素材标题
//        videoReqVo.setText("hello");
//        //这里查出的内容为json格式 在用户登陆授权回调的时候写入，在此处查
//        DouyinThirdUserConfigVo accessToken = douyinPublishService.getAccessToken(httpFacade, userConfigVo);
//        DouyinPublishVideoRespVo douyinPublishVideoRespVo = douyinPublishService.publishVideo(videoUrl, videoReqVo, httpFacade, accessToken);
//        if (douyinPublishVideoRespVo.getErrorCode() == 0) {
//
//        } else {
//
//        }
//        return BaseResult.success();
//    }
}
