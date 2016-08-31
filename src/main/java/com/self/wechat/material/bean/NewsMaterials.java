package com.self.wechat.material.bean;

/**
 * 描述：图文消息素材列表
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class NewsMaterials {
    /**
     * 该类型的素材的总数
     */
    private String total_count;
    /**
     * 本次调用获取的素材的数量
     */
    private String item_count;
    /**
     * 素材列表
     */
    private NewsItem[] item;

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getItem_count() {
        return item_count;
    }

    public void setItem_count(String item_count) {
        this.item_count = item_count;
    }

    public NewsItem[] getItem() {
        return item;
    }

    public void setItem(NewsItem[] item) {
        this.item = item;
    }
}
