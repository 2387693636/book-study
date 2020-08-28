package com.study.javamind.controller;

import com.study.javamind.entity.UserEntity;
import com.study.javamind.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String testUser(@RequestBody UserEntity user) {
        String result = userService.getUser(user);
        return result;
    }
}
