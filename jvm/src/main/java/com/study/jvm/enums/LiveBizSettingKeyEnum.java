package com.study.jvm.enums;

import java.util.Arrays;
import java.util.Objects;

public enum LiveBizSettingKeyEnum {

	/**
	 * 通知类型
	 */
	LIVE_NOTIFY_TYPE("live.notify.type"),

	/**
	 * 是否支持回放
	 */
	LIVE_REPLAY_FLAG("live.replay.flag"),

	/**
	 * 社群信息配置
	 */
	LIVE_COMMUNITY_INFO("live.community.info");

	private String code;

	private LiveBizSettingKeyEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public LiveBizSettingKeyEnum findByCode(String code) {
		return Arrays.stream(values()).filter(e -> Objects.equals(e.code, code)).findAny().orElse(null);
	}
}
