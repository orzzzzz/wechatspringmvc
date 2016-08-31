package com.self.wechat.material.bean;

import com.self.wechat.base.BaseResult;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class MaterialCasMessage extends BaseResult{
    private String type;
    private String media_id;
    private Long created_at;

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

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "MediaUploadMessage{" +
                "type='" + type + '\'' +
                ", media_id='" + media_id + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
