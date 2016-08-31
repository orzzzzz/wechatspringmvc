package com.self.wechat.message.resolver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.wechat.message.bean.*;
import com.self.wechat.token.TokenManage;
import com.self.wechat.util.HttpUtil;
import com.self.wechat.util.XmlUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/19
 */
public class EventClickNewsResolver implements IResolver {
    @Override
    public String resolve(Map<String, String> message) throws Exception {
        String respMessage = null;
        String content = message.get("EventKey");
        System.out.println("========================="+message.get("openid"));
        // 创建图文消息
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setToUserName(message.get("FromUserName"));
        newsMessage.setFromUserName(message.get("ToUserName"));
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType("news");
        //newsMessage.setFuncFlag(0);

        List<Article> articleList = new ArrayList<>();
        if ("new1".equals(content)) {
            Article article = new Article();
            article.setTitle("微信公众帐号开发教程Java版");
            article.setDescription("柳峰，80后，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列教程，也希望借此机会认识更多同行！");
            article.setPicUrl("http://s3.51cto.com/wyfs01/M01/32/79/wKioJlKCWrvw_N4VAABoo221tXE159.jpg");
            article.setUrl("http://blog.csdn.net/lyq8479");
            articleList.add(article);
            // 设置图文消息个数
            newsMessage.setArticleCount(articleList.size());
            // 设置图文消息包含的图文集合
            newsMessage.setArticles(articleList);
            // 将图文消息对象转换成xml字符串
            respMessage = XmlUtil.newsMessageToXml(newsMessage);
        }
        // 单图文消息---不含图片
        else if ("new2".equals(content)) {
            Article article = new Article();
            article.setTitle("微信公众帐号开发教程Java版");
            // 图文消息中可以使用QQ表情、符号表情
            article.setDescription("柳峰，80后，"
                    + "，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列连载教程，也希望借此机会认识更多同行！\n\n目前已推出教程共12篇，包括接口配置、消息封装、框架搭建、QQ表情发送、符号表情发送等。\n\n后期还计划推出一些实用功能的开发讲解，例如：天气预报、周边搜索、聊天功能等。");
            // 将图片置为空
            article.setPicUrl("");//http://s9.51cto.com/wyfs01/M00/32/7B/wKioOVKCWt3QYxXaAABw_TiniyA217.jpg
            article.setUrl("http://blog.csdn.net/lyq8479");
            articleList.add(article);
            newsMessage.setArticleCount(articleList.size());
            newsMessage.setArticles(articleList);
            respMessage = XmlUtil.newsMessageToXml(newsMessage);
        }
        // 多图文消息
        else if ("new3".equals(content)) {
            Article article1 = new Article();
            article1.setTitle("微信公众帐号开发教程\n引言");
            article1.setDescription("");
            article1.setPicUrl("http://s2.51cto.com/wyfs01/M02/32/7B/wKioOVKCW4vCY5o2AABuCGt2KSY760.jpg");
            article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");

            Article article2 = new Article();
            article2.setTitle("第2篇\n微信公众帐号的类型");
            article2.setDescription("");
            article2.setPicUrl("http://s2.51cto.com/wyfs01/M02/32/7B/wKioOVKCW4vCY5o2AABuCGt2KSY760.jpg");
            article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8941577");

            Article article3 = new Article();
            article3.setTitle("第3篇\n开发模式启用及接口配置");
            article3.setDescription("");
            article3.setPicUrl("http://s2.51cto.com/wyfs01/M02/32/7B/wKioOVKCW4vCY5o2AABuCGt2KSY760.jpg");
            article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");

            articleList.add(article1);
            articleList.add(article2);
            articleList.add(article3);
            newsMessage.setArticleCount(articleList.size());
            newsMessage.setArticles(articleList);
            respMessage = XmlUtil.newsMessageToXml(newsMessage);
        }
        // 多图文消息---首条消息不含图片
        else if ("new4".equals(content)) {
            Article article1 = new Article();
            article1.setTitle("微信公众帐号开发教程Java版");
            article1.setDescription("");
            // 将图片置为空
            article1.setPicUrl("");
            article1.setUrl("http://blog.csdn.net/lyq8479");

            Article article2 = new Article();
            article2.setTitle("第4篇\n消息及消息处理工具的封装");
            article2.setDescription("");
            article2.setPicUrl("http://s2.51cto.com/wyfs01/M02/32/79/wKioJlKCWvvQ_l2IAABsmYGSp9Q194.jpg");
            article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8949088");

            Article article3 = new Article();
            article3.setTitle("第5篇\n各种消息的接收与响应");
            article3.setDescription("");
            article3.setPicUrl("http://s2.51cto.com/wyfs01/M02/32/79/wKioJlKCWvvQ_l2IAABsmYGSp9Q194.jpg");
            article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8952173");

            Article article4 = new Article();
            article4.setTitle("第6篇\n文本消息的内容长度限制揭秘");
            article4.setDescription("");
            article4.setPicUrl("http://s2.51cto.com/wyfs01/M02/32/79/wKioJlKCWvvQ_l2IAABsmYGSp9Q194.jpg");
            article4.setUrl("http://blog.csdn.net/lyq8479/article/details/8967824");

            articleList.add(article1);
            articleList.add(article2);
            articleList.add(article3);
            articleList.add(article4);
            newsMessage.setArticleCount(articleList.size());
            newsMessage.setArticles(articleList);
            respMessage = XmlUtil.newsMessageToXml(newsMessage);
        }
        // 多图文消息---最后一条消息不含图片
        else if ("new5".equals(content)) {
            Article article1 = new Article();
            article1.setTitle("第7篇\n文本消息中换行符的使用");
            article1.setDescription("");
            article1.setPicUrl("http://s1.51cto.com/wyfs01/M01/32/7B/wKioOVKCWxeBEpiAAAB17HoroIU457.jpg");
            article1.setUrl("http://blog.csdn.net/lyq8479/article/details/9141467");

            Article article2 = new Article();
            article2.setTitle("第8篇\n文本消息中使用网页超链接");
            article2.setDescription("");
            article2.setPicUrl("http://s1.51cto.com/wyfs01/M01/32/7B/wKioOVKCWxeBEpiAAAB17HoroIU457.jpg");
            article2.setUrl("http://blog.csdn.net/lyq8479/article/details/9157455");

            Article article3 = new Article();
            article3.setTitle("如果觉得文章对你有所帮助，请通过博客留言或关注微信公众帐号xiaoqrobot来支持柳峰！");
            article3.setDescription("");
            // 将图片置为空
            article3.setPicUrl("");
            article3.setUrl("http://blog.csdn.net/lyq8479");

            articleList.add(article1);
            articleList.add(article2);
            articleList.add(article3);
            newsMessage.setArticleCount(articleList.size());
            newsMessage.setArticles(articleList);
            respMessage = XmlUtil.newsMessageToXml(newsMessage);
        } else if ("buy".equals(content)) {
            String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
            url = url.replace("ACCESS_TOKEN", TokenManage.getToken().getAccess_token());
            String jsonMessage = creatTemplate(message.get("FromUserName").toString());
            JsonNode jsonNode = HttpUtil.httpsRequest(url, "POST", jsonMessage);
            System.out.println(jsonNode.get("errcode").toString());
            System.out.println(jsonNode.get("errmsg").toString());
            System.out.println(jsonNode.get("msgid").toString());
        }
        System.out.println(respMessage);
        return respMessage;
    }

    public static String creatTemplate(String openId) throws Exception {
        TemplateMessage message = new TemplateMessage();

        TemplateDate date = new TemplateDate();

        TemplateBase first = new TemplateBase();
        first.setColor("#FF0000");
        first.setValue("恭喜你购买成功！");

        TemplateBase keynote1 = new TemplateBase();
        keynote1.setColor("#FF0000");
        keynote1.setValue("巧克力");

        TemplateBase keynote2 = new TemplateBase();
        keynote2.setColor("#FF0000");
        keynote2.setValue("39.8元");

        TemplateBase keynote3 = new TemplateBase();
        keynote3.setColor("#FF0000");
        keynote3.setValue("2014年9月22日");

        TemplateBase remark = new TemplateBase();
        remark.setColor("#FF0000");
        remark.setValue("欢迎再次购买！");

        date.setFirst(first);
        date.setKeynote1(keynote1);
        date.setKeynote2(keynote2);
        date.setKeynote3(keynote3);
        date.setRemark(remark);

        message.setTouser(openId);//"olnbTw-HrfZdQvj-qqvwnvib5wg4"
        message.setTemplate_id("MpI4c-quoVO4tM3NMX97BJXaC8HXIJ3yAiSvGIBKZ-4");
        message.setUrl("www.baidu.com");
        message.setData(new TemplateDate[]{date});

        ObjectMapper mapper = new ObjectMapper();
        String jsonMessage = mapper.writeValueAsString(message);
        System.out.println(jsonMessage);
        return jsonMessage;
    }
}
