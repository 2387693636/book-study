package com.study.javamind.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.study.javamind.entity.UserEntity;
import com.study.javamind.service.UserService;
import com.study.javamind.vo.UserVo;
import org.apache.catalina.User;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/28 14:12
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public String getUser(UserEntity user){
        UserVo vo = new UserVo();
        try {
            logger.info("传入参数userentity,{}", JSONObject.toJSONString(user));
            PropertyUtils.copyProperties(vo, user);
            logger.info("copyProperties转化UserVo后，vo为,{}", JSONObject.toJSONString(vo));
            vo.setText("1111111");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo.getUsername() + "" + vo.getText() + JSONObject.toJSONString(vo);
    }
}
