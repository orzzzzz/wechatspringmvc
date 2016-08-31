package com.self.wechat.ticket;

import com.self.wechat.base.BaseAPI;
import com.self.wechat.client.HttpClientExecutor;
import com.self.wechat.ticket.bean.Ticket;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * 描述：微信js-sdk调用临时凭证API
 *
 * @author zhangmengwen
 * @date 2016/8/24
 */
public class TicketAPI extends BaseAPI {

    /**
     * 获取jsapi_ticket
     *
     * @param access_token
     * @return
     * @throws Exception
     */
    public static Ticket getTicket(String access_token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URL.concat("/cgi-bin/ticket/getticket"))
                .addParameter("access_token", access_token)
                .addParameter("type", "jsapi")
                .build();

        return HttpClientExecutor.executeJsonResult(httpUriRequest, Ticket.class);
    }
}
