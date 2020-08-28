package com.study.javamind.vo;

import com.study.javamind.entity.UserEntity;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/28 14:08
 */
public class UserVo extends UserEntity {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
}
