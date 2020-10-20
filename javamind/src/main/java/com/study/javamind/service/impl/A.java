package com.study.javamind.service.impl;

import com.study.javamind.service.ContentPlatformService;
import org.springframework.stereotype.Service;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/10/9 16:26
 */
@Service
public class A implements ContentPlatformService {

    @Override
    public Object getAccessToken(Object o, Object o1, Object o3) {
        return "aaa" + o.toString();
    }

    @Override
    public Object publish() {
        return null;
    }

    @Override
    public <T> T get(T d, T d2, T d3) {

        return null;
    }
}
