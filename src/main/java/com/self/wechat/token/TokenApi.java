package com.self.wechat.token;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.wechat.base.BaseApi;
import com.self.wechat.token.bean.Token;
import com.self.wechat.util.HttpUtil;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class TokenApi extends BaseApi {
    /**
     * 通过接口调用获取access_token
     *
     * @param appID
     * @param appsecret
     * @return
     */
    public static Token getToken(String appID, String appsecret) throws Exception {
        String requestUrl = BASE_URL.concat("/cgi-bin/token?grant_type=client_credential&appid=")
                .concat(appID).concat("&secret=").concat(appsecret);
        JsonNode jsonNode = HttpUtil.httpsRequest(requestUrl,"GET",null);
        Token token = new Token();
        if(null!=jsonNode){
            ObjectMapper mapper = new ObjectMapper();
            token = mapper.readValue(jsonNode.toString(), Token.class);
            token.setExpires_in(System.currentTimeMillis()+7000*1000);
        }
        return token;
    }
}
