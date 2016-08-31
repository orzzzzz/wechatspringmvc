package com.self.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/29
 */
@Controller
@RequestMapping("/system")
public class SystemController {
    @RequestMapping(value = "/shopcar", method = RequestMethod.GET)
    public String toShopCar(){
        return "page/shopcar";
    }
}
