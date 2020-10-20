package com.study.jvm.service;

import com.study.jvm.util.BaseResult;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/22 10:09
 */
public interface PublishThirdPartyService<T> {
    Object getAccessToken(T object1, T object2);

    Object publish(T object1, T object2);

    BaseResult<T> upload(T object1, T object2, T object3);
}
