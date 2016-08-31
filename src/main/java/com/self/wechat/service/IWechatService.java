package com.self.wechat.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：消息处理接口
 *
 * @author zhangmengwen
 * @date 2016/8/18
 */
public interface IWechatService {
    /**
     * 消息处理
     *
     * @param request
     * @return
     * @throws Exception
     */
    String message(HttpServletRequest request) throws Exception;

    /**
     * 消息处理 路由
     *
     * @param request
     * @return
     * @throws Exception
     */
    String messageRouter(HttpServletRequest request) throws Exception;
}
