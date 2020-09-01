package com.study.javamind.service;

import com.study.javamind.entity.UserEntity;
import org.apache.catalina.User;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/28 14:12
 */
public interface UserService {
    public String getUser(UserEntity user);
}
