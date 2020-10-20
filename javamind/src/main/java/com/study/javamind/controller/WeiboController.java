package com.study.javamind.controller;

import com.study.javamind.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/10 16:35
 */
@RestController
@RequestMapping("/weibo")
public class WeiboController {

    @RequestMapping(value = "getCodeRedirect", method = {RequestMethod.POST, RequestMethod.GET})
    public String getCodeRedirect(String code) {
        return code;
    }
}
