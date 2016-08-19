package com.self.wechat.message.bean;

import com.self.wechat.base.BaseMessage;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/18
 */
public class LocationMessage extends BaseMessage{
    private String Event;
    private String Latitude;
    private String Longitude;
    private String Precision;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }
}
