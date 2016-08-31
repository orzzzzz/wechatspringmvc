package com.self.wechat.material.bean;

/**
 * 描述：图文消息素材列表文章
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class NewsSingleArticles {
    /**
     * 图文消息的标题
     */
    private String title;
    /**
     * 封面图片素材id
     */
    private String thumb_media_id;
    /**
     * 是否显示封面，0为false，即不显示，1为true，即显示
     */
    private int show_cover_pic;
    /**
     * 作者
     */
    private String author;
    /**
     * 图文消息的摘要
     */
    private String digest;
    /**
     * 图文消息的具体内容
     */
    private String content;
    /**
     * 图文消息的原文地址
     */
    private String content_source_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public int getShow_cover_pic() {
        return show_cover_pic;
    }

    public void setShow_cover_pic(int show_cover_pic) {
        this.show_cover_pic = show_cover_pic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_source_url() {
        return content_source_url;
    }

    public void setContent_source_url(String content_source_url) {
        this.content_source_url = content_source_url;
    }
}
