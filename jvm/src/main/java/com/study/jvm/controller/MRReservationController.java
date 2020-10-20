package com.study.jvm.controller;

import com.study.jvm.pojo.AddPersionInfoVo;
import com.study.jvm.pojo.MeetRoomInfoVo;
import com.study.jvm.pojo.ReservationInfoVo;
import com.study.jvm.pojo.UpdateReservationVo;
import com.study.jvm.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/27 15:23
 */
@RestController
@RequestMapping("/meetroom/reservation")
@Api(value = "会议室预定接口")
public class MRReservationController {

    @RequestMapping("/getAllmeetroom")
    @ApiOperation(value = "查看所有会议室信息", httpMethod = "POST")
    public BaseResult<String> getAllmeetroom(@RequestBody ReservationInfoVo infoVo) {
        return BaseResult.success();
    }

    @RequestMapping("/reservationMeetRoom")
    @ApiOperation(value = "预定会议室", httpMethod = "POST")
    public BaseResult<Void> reservationMeetRoom(@RequestBody AddPersionInfoVo persionInfoVo) {
        return BaseResult.success();
    }

    @RequestMapping("/addMeetPersons")
    @ApiOperation(value = "添加与会人员信息", httpMethod = "POST")
    public BaseResult<Void> addMeetPersons(@RequestBody AddPersionInfoVo persionInfoVo) {
        return BaseResult.success();
    }

    @RequestMapping("/getBookedMeetRoom")
    @ApiOperation(value = "查看已预定会议室信息", httpMethod = "POST")
    public BaseResult<MeetRoomInfoVo> predestinateMeetRoom(@RequestBody ReservationInfoVo infoVo) {
        return BaseResult.success();
    }


    @RequestMapping("/updateMeetRoom")
    @ApiOperation(value = "修改所有会议室信息", httpMethod = "POST")
    public BaseResult<Void> updateMeetRoom(@RequestBody UpdateReservationVo infoVo) {
        return BaseResult.success();
    }
}
