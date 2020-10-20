package com.study.javamind.controller;

import com.study.javamind.entity.UserEntity;
import com.study.javamind.interceptor.annotation.CheckConfigNum;
import com.study.javamind.param.UserParam;
import com.study.javamind.service.UserService;
import com.study.javamind.vo.UserVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/28 14:09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("testUser")
    public String testUser(UserEntity user) {
        String result = userService.getUser(user);
        return result;
    }

    @GetMapping("testAnnotation")
    @CheckConfigNum(code = "testAnnotation" , requestKey = "{#capacity}" , errorMsg = "错误")
    public String testAnnotation(@RequestParam("capacity") Integer capacity) {
        return capacity+"";
    }

    @PostMapping("getUserInfo")
    public List<UserVo> getUserInfo(@RequestBody UserParam user) {
        List<UserVo> result = userService.getUserInfo(user);
        return result;
    }


}
