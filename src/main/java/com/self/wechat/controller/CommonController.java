package com.self.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述：测试的
 *
 * @author zhangmengwen
 * @date 2016/8/29
 */
@Controller
public class CommonController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toIndex(){
        return "page/index";
    }
    @RequestMapping(value = "/shopcar", method = RequestMethod.GET)
    public String toShopCar(){
        return "page/shopcar";
    }
}
