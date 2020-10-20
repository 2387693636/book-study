package com.study.jvm.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/27 15:42
 */
@ApiModel("添加与会人员信息对象")
public class AddPersionInfoVo {

    @ApiModelProperty("员工id")
    private Long id;
    @ApiModelProperty("员工姓名")
    private String name;
    @ApiModelProperty("员工email")
    private String email;
    @ApiModelProperty("员工电话")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
