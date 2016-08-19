package com.self.wechat.menu.bean;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class ViewButton extends Button {
    /**
     * 菜单的响应动作类型:跳转URL
     */
    private String type = "view";

    /**
     * 网页链接
     */
    private String url;

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
}
