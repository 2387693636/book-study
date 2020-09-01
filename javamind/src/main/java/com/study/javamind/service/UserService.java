package com.study.javamind.service;

import com.study.javamind.entity.UserEntity;
import com.study.javamind.param.UserParam;
import com.study.javamind.vo.UserVo;
import org.apache.catalina.User;

import java.util.List;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/28 14:12
 */
public interface UserService {
    public String getUser(UserEntity user);
    public List<UserVo> getUserInfo(UserParam param);
}
