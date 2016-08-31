package com.self.wechat.message.bean;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/23
 */
public class TemplateMessage {
    private String touser;
    private String template_id;
    private String url;
    private TemplateDate[] data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TemplateDate[] getData() {
        return data;
    }

    public void setData(TemplateDate[] data) {
        this.data = data;
    }
}
