package com.study.javamind.constant;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/9/4 11:55
 */
public class TouTiaoConstant {



    /**
     * 头条认证用户是否存在文章发布权限接口
     */
    public static final String TOUTIAO_AUTH = "https://mp.toutiao.com/article/browser_auth/?redirect_uri=/core/article/new_article/";
    /**
     * 头条审核文章标题接口
     */
    public static final String TOUTIAO_TITLE_CHECK= "https://mp.toutiao.com/check_title/";
    /**
     * 头条审核文章拼写接口
     */
    public static final String TOUTIAO_SPELL_CHECK= "https://mp.toutiao.com/article/spell_check_apply/?";
    /**
     * 头条添加图片资源接口
     */
    public static final String TOUTIAO_ADD_PIC_SOURCE= "https://mp.toutiao.com/article/add_pic_source_stat/?";
    /**
     * 头条上传图片资源接口
     */
    public static final String UPLOAD_IMG= "https://mp.toutiao.com/tools/catch_picture/?&";

    /**
     * 头条保存草稿箱接口
     */
    public static final String TOUTIAO_SAVE_DRAFT= "https://mp.toutiao.com/core/article/edit_article_post/?source=mp&type=article";
    /**
     * 头条文章发布接口
     */
    public static final String TOUTIAO_PUBLISH= "https://mp.toutiao.com/core/article/edit_article_post/?source=mp&type=article";

    public static final String TOUTIAO_CHECK_RUMOR= "https://mp.toutiao.com/statistic/rumor_check/?title=";
    public static final String AUTH_CONFIRM= "https://mp.toutiao.com/pc_auth_confirm/";
    public static final String MEDIA_INFO= "https://mp.toutiao.com/get_media_info/";


}
