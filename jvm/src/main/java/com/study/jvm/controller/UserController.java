package com.study.jvm.controller;

import com.study.javamind.facade.UserFacade;
import com.study.javamind.param.UserParam;
import com.study.javamind.vo.UserVo;
import com.study.jvm.service.PublishThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/31 10:53
 */
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private PublishThirdPartyService thirdPartyService;

    @GetMapping("/getUser")
    public List<UserVo> getUser(UserParam user) {
        List<UserVo> userInfo = userFacade.getUserInfo(user);
        String s = "assd";
        thirdPartyService.getAccessToken(userInfo, s);

        return userInfo;
    }


}
