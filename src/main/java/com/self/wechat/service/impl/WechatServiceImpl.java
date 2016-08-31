package com.self.wechat.service.impl;

import com.self.wechat.message.MessageRouter;
import com.self.wechat.message.bean.TextMessage;
import com.self.wechat.service.IWechatService;
import com.self.wechat.util.XmlUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 描述：消息处理
 *
 * @author zhangmengwen
 * @date 2016/8/18
 */
@Service
public class WechatServiceImpl implements IWechatService{
    /**
     * 消息处理
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String message(HttpServletRequest request) throws Exception {
        String responseXml = null;
        Map<String, String> map = XmlUtil.parseXml(request);
        String msgType = map.get("MsgType");

        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(map.get("MsgType"));

        if(msgType.equals("event")){
            String eventType = map.get("Event");
            if(eventType.equals("subscribe")){
                textMessage.setContent("感谢您的关注！");

                responseXml = XmlUtil.messageToXml(textMessage);
            }
            // 取消订阅
            else if (eventType.equals("unsubscribe")) {
                // TODO 暂不做处理
            }
        }
        return responseXml;
    }

    /**
     * 消息处理 路由
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String messageRouter(HttpServletRequest request) throws Exception {
        Map<String, String> map = XmlUtil.parseXml(request);
        return MessageRouter.router(map);
    }
}
