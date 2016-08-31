package com.self.wechat.message.resolver;

import java.util.Map;

/**
 * 描述：取关消息解析器
 *
 * @author zhangmengwen
 * @date 2016/8/18
 */
public class UnSubscribeEventResolver implements IResolver{
    /**
     * 取消订阅消息回复
     *
     * @param message
     * @return
     * @throws Exception
     */
    @Override
    public String resolve(Map<String, String> message) throws Exception {
        return "";
    }
}
