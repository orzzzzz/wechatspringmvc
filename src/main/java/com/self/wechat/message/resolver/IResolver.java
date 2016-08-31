package com.self.wechat.message.resolver;

import java.util.Map;

/**
 * 描述：消息解析器接口
 *
 * @author zhangmengwen
 * @date 2016/8/18
 */
public interface IResolver {
    /**
     * 消息回复
     * @param message
     * @return
     * @throws Exception
     */
    String resolve(Map<String, String> message) throws Exception;
}
