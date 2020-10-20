package com.study.jvm.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/27 15:45
 */
@ApiModel("会议室修改信息对象")
public class UpdateReservationVo {


    @ApiModelProperty("会议室ID")
    private Long id;

    @ApiModelProperty("会议室容纳人数")
    private Integer number;

    @ApiModelProperty("会议室设备")
    private String equipment;

    @ApiModelProperty("会议室位置")
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
