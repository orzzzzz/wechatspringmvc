package com.self.wechat.material.bean;

/**
 * 描述：图文消息素材列表item结构
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class NewsItem {
    /**
     * 素材id
     */
    private String media_id;
    /**
     * 图文内容
     */
    private NewsContent content;
    /**
     * 更新时间
     */
    private Long update_time;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public NewsContent getContent() {
        return content;
    }

    public void setContent(NewsContent content) {
        this.content = content;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }
}
