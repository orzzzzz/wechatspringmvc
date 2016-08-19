package com.self.wechat.message.bean;

import com.self.wechat.base.BaseMessage;

import java.util.List;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/19
 */
public class NewsMessage extends BaseMessage{
    private int ArticleCount;
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
