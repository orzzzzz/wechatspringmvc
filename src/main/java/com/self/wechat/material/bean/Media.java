package com.self.wechat.material.bean;

import com.self.wechat.base.BaseResult;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/29
 */
public class Media extends BaseResult {
    private String type;
    private String url;
    private String media_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    @Override
    public String toString() {
        return "Media{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", media_id='" + media_id + '\'' +
                '}';
    }
}
