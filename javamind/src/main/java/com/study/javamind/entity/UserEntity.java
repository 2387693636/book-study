package com.study.javamind.entity;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/28 14:07
 */
public class UserEntity {
    private String username;
    private String password;
    private String phone;
    private String gender;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
