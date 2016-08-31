package com.self.wechat.ticket;

import com.self.wechat.ticket.bean.Ticket;
import com.self.wechat.token.TokenManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/24
 */
public class TicketManage {
    private static Logger logger = LoggerFactory.getLogger(Ticket.class);

    /**
     * 缓存ticket
     */
    private static Ticket ticket;

    /**
     * 获取ticket
     *
     * @return
     * @throws Exception
     */
    public synchronized Ticket getTicket() throws Exception {
        if (ticket == null) {
            refreshTicket();
            return ticket;
        }

        if (ticket.getExpires_in() >= System.currentTimeMillis()) {
            refreshTicket();
        }
        logger.info("缓存的ticket>>>>>>>>>>>" + ticket.getTicket());
        return ticket;
    }

    /**
     * 刷新ticket
     *
     * @throws Exception
     */
    public static void refreshTicket() throws Exception {
        String token = TokenManage.getToken().getAccess_token();
        ticket = TicketApi.getTicket(token);
        ticket.setExpires_in(System.currentTimeMillis() + 7000 * 1000);
    }
}
