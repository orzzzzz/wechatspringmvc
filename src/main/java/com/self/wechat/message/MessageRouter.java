package com.self.wechat.message;

import com.self.wechat.message.resolver.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：消息路由
 *
 * @author zhangmengwen
 * @date 2016/8/18
 */
public class MessageRouter {
    /**
     * 创建消息类型对应处理类 map
     */
    private static Map<String, Class> resolvers = new HashMap<String, Class>() {{
        put("text", TextMessageResolver.class);
        put("eventsubscribe", SubscribeEventResolver.class);
        put("eventunsubscribe", UnSubscribeEventResolver.class);
        put("eventLOCATION", LocationMessageResolver.class);
        put("eventCLICK", EventClickNewsResolver.class);
    }};

    /**
     * 路由选择
     *
     * @param map
     * @return
     * @throws Exception
     */
    public static String router(Map<String, String> map) throws Exception {
        String MsgType = map.get("MsgType");
        String Event = map.get("Event");
        Class clazz = resolvers.get((MsgType + Event).replace("null", ""));

        System.out.println(map.size());
        for (String key : map.keySet())
            System.out.println("key=" + key + ",value=" + map.get(key));

        if (clazz == null) {
            return "";
        }

        Method method = clazz.getDeclaredMethod("resolve", new Class[]{Map.class});
        if (method == null) {
            return "";
        }
        return (String) method.invoke(clazz.newInstance(), map);
    }
}
