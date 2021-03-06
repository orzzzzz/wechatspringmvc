package com.self.wechat.ticket.bean;

/**
 * 描述：ticket bean
 *
 * @author zhangmengwen
 * @date 2016/8/24
 */
public class Ticket {
    private String ticket;
    private Long expires_in;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }
}
