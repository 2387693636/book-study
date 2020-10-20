package com.study.javamind.service;


import com.study.javamind.util.HttpFacade;
import com.study.javamind.vo.douyin.vo.DouyinPublishVideoReqVo;
import com.study.javamind.vo.douyin.vo.DouyinPublishVideoRespVo;
import com.study.javamind.vo.douyin.vo.DouyinThirdUserConfigVo;
import com.study.javamind.vo.douyin.vo.MediaUrlResultVo;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/13 15:17
 */
public interface DouyinPublishService {
    DouyinThirdUserConfigVo getAccessToken(HttpFacade httpFacade, DouyinThirdUserConfigVo vo);

    DouyinPublishVideoRespVo publishVideo(MediaUrlResultVo videoUrl, DouyinPublishVideoReqVo videoReqVo, HttpFacade httpFacade, DouyinThirdUserConfigVo userConfigVo);
}
