package com.self.wechat.base;

/**
 * 描述：微信接口返回基础类
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class BaseResult {
    /**
     * 错误码
     */
    private String errcode;

    /**
     * 错误信息
     */
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
