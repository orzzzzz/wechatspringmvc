package com.self.wechat.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.wechat.message.bean.TemplateBase;
import com.self.wechat.message.bean.TemplateDate;
import com.self.wechat.message.bean.TemplateMessage;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/23
 */
public class MessageTest {
    public static void main(String[] args) throws Exception {
        TemplateMessage message = new TemplateMessage();

        TemplateDate date = new TemplateDate();

        TemplateBase first = new TemplateBase();
        first.setColor("#173177");
        first.setValue("恭喜你购买成功！");

        TemplateBase keynote1 = new TemplateBase();
        keynote1.setColor("#173177");
        keynote1.setValue("巧克力");

        TemplateBase keynote2 = new TemplateBase();
        keynote2.setColor("#173177");
        keynote2.setValue("39.8元");

        TemplateBase keynote3 = new TemplateBase();
        keynote3.setColor("#173177");
        keynote3.setValue("2014年9月22日");

        TemplateBase remark = new TemplateBase();
        remark.setColor("#173177");
        remark.setValue("欢迎再次购买！");

        date.setFirst(first);
        date.setKeynote1(keynote1);
        date.setKeynote2(keynote2);
        date.setKeynote3(keynote3);
        date.setRemark(remark);

        message.setTouser("OPENID");
        message.setTemplate_id("ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY");
        message.setUrl("http://weixin.qq.com/download");
        message.setData(new TemplateDate[]{date});

        ObjectMapper mapper = new ObjectMapper();
        String jsonMessage = mapper.writeValueAsString(message);
        System.out.println(jsonMessage);
    }
}
