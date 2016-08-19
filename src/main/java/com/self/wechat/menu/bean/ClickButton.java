package com.self.wechat.menu.bean;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class ClickButton extends Button {
    /**
     *菜单的响应动作类型:点击推事件
     */
    private String type = "click";

    /**
     *菜单KEY值，用于消息接口推送
     */
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
