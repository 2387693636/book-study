package com.study.javamind.controller;

import com.study.javamind.service.ContentPlatformService;
import com.study.javamind.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/10/9 16:27
 */
@RestController
@RequestMapping("/")
public class AC {
    @Autowired
    private ContentPlatformService service;

    public String testA() {
        String s = "aa";
        Object accessToken = service.getAccessToken(s, s, s);
        String userVo = service.get(s, s, s);
        return accessToken+"";
    }
}
