package com.self.wechat.message.resolver;

import com.self.wechat.message.bean.TextMessage;
import com.self.wechat.util.XmlUtil;

import java.util.Date;
import java.util.Map;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/18
 */
public class LocationMessageResolver implements IResolver{
    @Override
    public String resolve(Map<String, String> message) throws Exception {
        String content = "纬度："+message.get("Latitude")+"经度:"+message.get("Longitude")+"精度:"+message.get("Precision");
        TextMessage respMessage = new TextMessage();
        respMessage.setToUserName(message.get("FromUserName"));
        respMessage.setFromUserName(message.get("ToUserName"));
        respMessage.setCreateTime(new Date().getTime());
        respMessage.setMsgType("text");
        respMessage.setContent(content+" -- 来自服务器端的回复！");
        return XmlUtil.messageToXml(respMessage);
    }
}
