package com.study.javamind.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.study.javamind.entity.UserEntity;
import com.study.javamind.param.UserParam;
import com.study.javamind.service.UserService;
import com.study.javamind.vo.UserVo;
import org.apache.catalina.User;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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
    public String getUser(UserEntity user) {
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

    @Override
    public List<UserVo> getUserInfo(UserParam param) {
        logger.info("传入参数userentity,{}", JSONObject.toJSONString(param));

        List<UserVo> userVoList = new ArrayList<>();
        if (null != param.getTagIdStr()) {
            String stringList=param.getTagIdStr();
            String[] split = stringList.split(",");

            for (int i = 0; i < split.length; i++) {
                logger.info(split[i]);
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername("username" + split[i]);
                userEntity.setPassword("password" + split[i]);
                userEntity.setGender("gender" + split[i]);
                userEntity.setPhone("phone" + split[i]);
                UserVo vo = new UserVo();
                try {
                    PropertyUtils.copyProperties(vo, userEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                userVoList.add(vo);
                logger.info(userVoList.get(i).getUsername());
            }
            logger.info(JSONObject.toJSONString(userVoList));
            return userVoList;
        }
        return null;
    }
}
