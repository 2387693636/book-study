package com.study.jvm.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/27 15:26
 */
@ApiModel("会议室查询对象")
public class ReservationInfoVo {
    @ApiModelProperty("会议室ID")
    private Long id;

    @ApiModelProperty("偏移量")
    private Integer offset;

    @ApiModelProperty("查询参数")
    private String param;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
