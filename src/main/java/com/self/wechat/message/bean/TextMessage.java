package com.self.wechat.message.bean;

import com.self.wechat.base.BaseMessage;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class TextMessage extends BaseMessage{
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
