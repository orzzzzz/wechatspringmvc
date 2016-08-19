package com.self.wechat.menu.bean;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class Menu {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    private Button[] button;

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }
}
