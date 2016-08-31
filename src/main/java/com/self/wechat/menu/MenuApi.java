package com.self.wechat.menu;

import com.fasterxml.jackson.databind.JsonNode;
import com.self.wechat.base.BaseAPI;
import com.self.wechat.base.BaseResult;
import com.self.wechat.client.HttpClientExecutor;
import com.self.wechat.util.HttpUtil;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import static com.self.wechat.client.HttpClientExecutor.executeJsonResult;


/**
 * 描述：菜单 API
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class MenuAPI extends BaseAPI {
    private static Logger logger = LoggerFactory.getLogger(MenuAPI.class);

    /**
     * 菜单创建
     *
     * @param token
     * @param jsonMenu
     * @return
     */
    public static boolean creatMenu(String token, String jsonMenu) {
        String requestUrl = BaseAPI.BASE_URL.concat("/cgi-bin/menu/create?access_token=").concat(token);
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

    /**
     * 删除自定义菜单
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static boolean deleteMenu(String token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URL.concat("/cgi-bin/menu/delete"))
                .addParameter("access_token", token)
                .build();
        BaseResult result = executeJsonResult(httpUriRequest, BaseResult.class);
        if (!StringUtils.isEmpty(result) && result.getErrcode().equals("0")) {
            return true;
        } else {
            logger.error("菜单删除失败：errcode：{} errmsg：{}", result.getErrcode(), result.getErrmsg());
            return false;
        }
    }

    /**
     * 获取自定义菜单
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static String getMenu(String token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URL.concat("/cgi-bin/menu/get"))
                .addParameter("access_token", token)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, String.class);
    }

    /**
     * 获取自定义菜单配置接口
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static String getMenuInfo(String token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URL.concat("/cgi-bin/get_current_selfmenu_info"))
                .addParameter("access_token", token)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, String.class);
    }
}
