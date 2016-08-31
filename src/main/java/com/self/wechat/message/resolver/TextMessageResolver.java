package com.self.wechat.message.resolver;

import com.self.wechat.message.bean.TextMessage;
import com.self.wechat.util.XmlUtil;

import java.util.Date;
import java.util.Map;

/**
 * 描述：文本消息解析器
 *
 * @author zhangmengwen
 * @date 2016/8/18
 */
public class TextMessageResolver implements IResolver{
    /**
     * 文本消息回复
     *
     * @param message
     * @return
     * @throws Exception
     */
    @Override
    public String resolve(Map<String, String> message) throws Exception {
        TextMessage respMessage = new TextMessage();
        respMessage.setToUserName(message.get("FromUserName"));
        respMessage.setFromUserName(message.get("ToUserName"));
        respMessage.setCreateTime(new Date().getTime());
        respMessage.setMsgType("text");
        respMessage.setContent(message.get("Content")+"-- 来自服务器端的回复！");
        return XmlUtil.messageToXml(respMessage);
    }
}
