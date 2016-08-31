package com.self.wechat.token;

import com.self.wechat.token.bean.Token;
import org.slf4j.Logger;

/**
 * 描述：TODO
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
        logger.info("真的进来了======================");
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

        token = TokenApi.getToken("wx5184e09f3973c95b", "bbeccfdecbd117cbc6edd0fcddc5ca03");
        logger.info(token.getAccess_token());
    }
}
