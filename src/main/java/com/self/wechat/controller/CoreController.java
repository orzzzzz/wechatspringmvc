package com.self.wechat.controller;

import com.self.wechat.service.IWechatService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/16
 */
@Controller
@RequestMapping(value = "/core")
public class CoreController {

    @Autowired
    private IWechatService WechatServiceImpl;

    /**
     * 开发者接入
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/service", method = RequestMethod.GET)
    @ResponseBody
    public String validate(HttpServletRequest request) {
        if (isWechatCall(request)) {
            String echostr = request.getParameter("echostr");
            System.out.println(echostr);
            return echostr;
        } else {
            return "failure";
        }
    }

    /**
     * 消息处理
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/service", method = RequestMethod.POST, produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public String processMsg(HttpServletRequest request) throws Exception {
        //if(isWechatCall(request)){
        //    return "";
        //}
        String result = WechatServiceImpl.messageRouter(request);
        //String result = WechatServiceImpl.message(request);
        System.out.println(result);
        return result;
    }

    /**
     * 判断消息是否来自微信
     *
     * @param request
     * @return
     */
    private boolean isWechatCall(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String[] digest = {"wechat_lpsp", timestamp, nonce};
        Arrays.sort(digest);
        //拼接字符串
        StringBuffer sb = new StringBuffer();
        for (String s : digest)
            sb.append(s);
        return DigestUtils.sha1Hex(sb.toString()).equalsIgnoreCase(signature);
    }
}
