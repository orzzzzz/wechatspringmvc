package com.self.wechat.material.bean;

/**
 * 描述：图文消息素材列表文章集合
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class NewsContent {
    /**
     * 图文消息集合
     */
    private NewsSingleItem[] news_item;

    public NewsSingleItem[] getNews_item() {
        return news_item;
    }

    public void setNews_item(NewsSingleItem[] news_item) {
        this.news_item = news_item;
    }
}
