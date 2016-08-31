package com.self.wechat.token.bean;

import com.self.wechat.base.BaseResult;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class Token extends BaseResult {
    /**
     *	获取到的凭证
     */
    private String access_token;

    /**
     *凭证有效时间，7200秒
     */
    private Long expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "Token{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
