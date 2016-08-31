package com.self.wechat.menu.bean;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/28
 */
public class mediaButton extends Button{
    private String type = "media_id";
    private String media_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}
