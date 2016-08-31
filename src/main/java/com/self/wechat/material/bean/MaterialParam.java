package com.self.wechat.material.bean;

/**
 * 描述：永久素材的列表请求参数
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class MaterialParam {
    /**
     * 素材类型：图片（image）、视频（video）、语音 （voice）、图文（news）
     */
    private String type;
    /**
     * 偏移位置
     */
    private int offset;
    /**
     * 	返回素材的数量，取值在1到20之间
     */
    private int count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
