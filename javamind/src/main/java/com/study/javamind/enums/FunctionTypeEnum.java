package com.study.javamind.enums;


public enum FunctionTypeEnum
{

    FUNCTION_TYPE_MANAGE_TOOLS("manageTools", "管理工具"),
    FUNCTION_TYPE_MULTI_TERMINAL_LOGIN("multiTerminalLogin", "多终端登录"),
    FUNCTION_TYPE_SUB_ACCOUNT("subAccount", "专属子账号体系"),
    FUNCTION_TYPE_HIS_MERCHANT_MOBILE("hisMerchantMobile", "蝶代移动端"),
    FUNCTION_TYPE_AI_TOOLS("aiTools", "AI工具"),
    FUNCTION_TYPE_SEARCH_SENTIMENT_BYTIME("searchSentimentByTime", "舆情时间维度搜索"),
    FUNCTION_TYPE_ADD_SENTIMENT_KEYWORD("addSentimentKeyword", "舆情关键词新增"),
    FUNCTION_TYPE_MEDICAL_HOT("medicalHot", "医疗热点"),
    FUNCTION_TYPE_MEDICAL_POSTER("medicalPoster", "医疗海报生成"),
    FUNCTION_TYPE_CONTENT_MANAGE("contentManage", "内容管理"),
    FUNCTION_TYPE_IMAGETEXT_STORAGE("imageTextStorage", "图文存储"),
    FUNCTION_TYPE_VIDEO_STORAGE("videoStorage", "视频存储"),
    FUNCTION_TYPE_MICRO_WEB("microWeb", "科普微站"),
    FUNCTION_TYPE_SITE_TEMPLATE("siteTemplate", "站点个性化模板"),
    FUNCTION_TYPE_COLUMN("column", "栏目配置"),
    FUNCTION_TYPE_H5_MICRO_WEB("h5MicroWeb", "H5微站"),
    FUNCTION_TYPE_KNOWLEDGE_PAYMENT("knowledgePayment", "知识付费"),
    FUNCTION_TYPE_APPLETS_MICRO_WEB("appletsMicroWeb", "小程序微站"),
    FUNCTION_TYPE_PERSON_ICON("personIcon", "个性化图标"),
    FUNCTION_TYPE_STANDARD_SHARE("standardShare", "标准分享"),
    FUNCTION_TYPE_PERSON_SHARE("personShare", "个性化分享"),
    FUNCTION_TYPE_REGISTER_SERVICE("registerService", "挂号服务嵌入"),
    FUNCTION_TYPE_ONLINE_CONSULT_SERVICE("onlineConsultService", "在线咨询服务嵌入"),
    FUNCTION_TYPE_DOCTOR_SERVICE("doctorService", "医生服务连接"),
    FUNCTION_TYPE_CREATE_QRCODE("createQrcode", "二维码/短连接生成"),
    FUNCTION_TYPE_LIVE_MANAGE("liveManage", "直播管理"),
    FUNCTION_TYPE_CREATE_LIVE("createLive", "直播间创建"),
    FUNCTION_TYPE_LIVE_FLOW("liveFlow", "直播流量"),
    FUNCTION_TYPE_DOWNLOAD_LIVE_VIDEO("downloadLiveVideo", "直播视频下载"),
    FUNCTION_TYPE_LIVE_PLAYBACK("livePlayback", "直播回放"),
    FUNCTION_TYPE_SERVICE_SUBSCRIBE("serviceSubscribe", "服务号预约"),
    FUNCTION_TYPE_SMS_SUBSCRIBE("smsSubscribe", "短信预约"),
    FUNCTION_TYPE_LIVE_EXTENSION("liveExtension", "直播推广（转播）"),
    FUNCTION_TYPE_LIVE_FORBIDDENWORDS("liveForbiddenwords", "直播间禁言踢人"),
    FUNCTION_TYPE_LIVE_QUESTION("liveQuestion", "直播提问"),
    FUNCTION_TYPE_SETTING_LIVE_ADMIN("settingLiveAdmin", "直播管理员设置"),
    FUNCTION_TYPE_LIVE_GROUP("liveGroup", "直播社群引导"),
    FUNCTION_TYPE_LIVE_STANDARD_SHARE("liveStandardShare", "直播标准分享"),
    FUNCTION_TYPE_LIVE_PERSON_SHARE("livePersonShare", "直播个性化海报分享"),
    FUNCTION_TYPE_LIVE_H5("liveH5", "直播H5端嵌入"),
    FUNCTION_TYPE_LIVE_APP_LETS("liveApplets", "直播小程序端嵌入"),
    FUNCTION_TYPE_LIVE_DEFINITION("liveDefinition", "视频清晰度"),
    FUNCTION_TYPE_LIVE_REGISTER_SERVICE("liveRegisterService", "挂号服务嵌入"),
    FUNCTION_TYPE_LIVE_ONLINE_CONSULT_SERVICE("liveOnlineConsultService", "在线咨询服务嵌入"),
    FUNCTION_TYPE_LIVE_DOCTOR_SERVICE("liveDoctorService", "医生服务连接"),
    FUNCTION_TYPE_MARKETING_TOOLS("marketingTools", "营销工具"),
    FUNCTION_TYPE_ONEKEY_PUBLISH("onekeyPublish", "一键发布"),
    FUNCTION_TYPE_FISSION_TOOLS("fissionTools", "裂变工具"),
    FUNCTION_TYPE_QUESTIONNAIRE("questionnaire", "问卷调查"),
    FUNCTION_TYPE_LUCKDRAW("luckdraw", "抽奖转盘"),
    FUNCTION_TYPE_DATA_MANAGE("dataManage", "数据管理"),
    FUNCTION_TYPE_CONTENT_STATISTICS("contentStatistics", "内容统计"),
    FUNCTION_TYPE_MICRO_WEB_STATISTICS("microWebStatistics", "微站统计"),
    FUNCTION_TYPE_LIVE_STATISTICS("liveStatistics", "直播统计"),
    FUNCTION_TYPE_MULTIPLATFORM_STATISTICS("multiplatformStatistics", "多平台统计"),
    FUNCTION_TYPE_TIMEINTERVAK_STATISTICS("timeintervakStatistics", "时段统计"),
    FUNCTION_TYPE_USERINFO_MANAGE("userinfoManage", "用户信息管理"),
    FUNCTION_TYPE_INCREMENT_SERVICE("incrementService", "增值服务"),
    FUNCTION_TYPE_NATIONWIDE_CDN_DISPATCH("nationwideCdnDispatch", "全国CDN智能调度"),
    FUNCTION_TYPE_PERSON_DEV_OPS_GUARANTEE("personDevOpsGuarantee", "专人运维保障"),
    FUNCTION_TYPE_PRIVATEDOMAIN_DEPLOY("privatedomainDeploy", "私域部署"),
    FUNCTION_TYPE_ONLINE_OPERATE_SERVICE("onlineOperateService", "线上运营服务【如需现场协助，请咨询运营经理】"),
    FUNCTION_TYPE_OPERATIONS_MANAGER("operationsManager", "专属运营经理一对一咨询"),
    FUNCTION_TYPE_HOT_TOPICS_PLANNING("HotTopicsPlanning", "热点选题策划"),
    FUNCTION_TYPE_ASSIST("assist", "执行辅助"),
    FUNCTION_TYPE_LIVE_TRAIN("liveTrain", "直播培训"),
    FUNCTION_TYPE_GROUP_OPERATION("groupOperation", "社群运营");

    public String code;

    public String name;

    private FunctionTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String toName(String code) {
        for (FunctionTypeEnum type : values()) {
            if (type.getCode() == code) {
                return type.getName();
            }
        }
        return null;
    }


}
