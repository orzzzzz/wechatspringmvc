package com.self.wechat.menu;

import com.fasterxml.jackson.databind.JsonNode;
import com.self.wechat.base.BaseApi;
import com.self.wechat.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class MenuApi extends BaseApi {
    private static Logger logger = LoggerFactory.getLogger(MenuApi.class);

    /**
     * 菜单创建
     *
     * @param token
     * @param jsonMenu
     * @return
     */
    public static boolean creatMenu(String token, String jsonMenu) {
        String requestUrl = BaseApi.BASE_URL.concat("/cgi-bin/menu/create?access_token=").concat(token);
        boolean result = false;

        JsonNode jsonNode = HttpUtil.httpsRequest(requestUrl, "POST", jsonMenu);
        if (null != jsonNode) {
            String errcode = jsonNode.get("errcode").toString();
            String errmsg = jsonNode.get("errmsg").toString();
            if ("0".equals(errcode)) {
                result = true;
            } else {
                result = false;
                logger.error("创建菜单失败：errcode:{} errmsg:{}", errcode, errmsg);
            }
        }
        return result;
    }
}
