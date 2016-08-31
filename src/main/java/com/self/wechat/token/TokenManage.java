package com.self.wechat.token;

import com.self.common.config.SysConfig;
import com.self.wechat.token.bean.Token;
import org.slf4j.Logger;

/**
 * 描述：token中控服务器
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class TokenManage {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(TokenManage.class);

    /**
     * access_token
     */
    private static Token token;

    /**
     * 获取access_token
     *
     * @return
     */
    public static Token getToken() throws Exception {
        System.out.println(token==null);
        if (token == null) {
            refreshToken();
            logger.info("token================null 获取token");
            return token;
        }
        if (System.currentTimeMillis() >= token.getExpires_in()) {
            refreshToken();
            logger.info("System.currentTimeMillis() >= token.getExpires_in()");
            return token;
        }
        logger.info("缓存的token>>>>>>>>>>>" + token.getAccess_token());
        return token;
    }

    /**
     * 刷新access_token
     */
    public static void refreshToken() throws Exception {

        token = TokenAPI.getToken(SysConfig.WECHAT_APP_ID, SysConfig.WECHAT_APP_SECRET);
        logger.info(token.getAccess_token());
    }
}
