package com.self.wechat.menu.bean;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class Button {
    /**
     * 菜单标题，不超过16个字节，子菜单不超过40个字节
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
