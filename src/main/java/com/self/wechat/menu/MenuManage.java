package com.self.wechat.menu;

import com.self.wechat.menu.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/17
 */
public class MenuManage {
    private static Logger logger = LoggerFactory.getLogger(MenuManage.class);

    public static Menu initMenu() {
        ClickButton cbtn1 = new ClickButton();
        cbtn1.setName("单图文");
        cbtn1.setKey("new1");

        ClickButton cbtn2 = new ClickButton();
        cbtn2.setName("单图文-不含图片");
        cbtn2.setKey("new2");

        ClickButton cbtn3 = new ClickButton();
        cbtn3.setName("多图文");
        cbtn3.setKey("new3");

        ClickButton cbtn4 = new ClickButton();
        cbtn4.setName("多图文-首条不含图片");
        cbtn4.setKey("new4");

        ClickButton cbtn5 = new ClickButton();
        cbtn5.setName("多图文-最后一条不含图片");
        cbtn5.setKey("new5");

        ViewButton vbtn1 = new ViewButton();
        vbtn1.setName("百度");
        vbtn1.setUrl("http://www.baidu.com");

        ViewButton vbtn2 = new ViewButton();
        vbtn2.setName("爱奇艺");
        vbtn2.setUrl("http://www.iqiyi.com");

        ComplexButton plxbtn1 = new ComplexButton();
        plxbtn1.setName("网站");
        plxbtn1.setSub_button(new Button[]{vbtn1, vbtn2});

        ComplexButton plxbtn2 = new ComplexButton();
        plxbtn2.setName("image");
        plxbtn2.setSub_button(new Button[]{cbtn1, cbtn2, cbtn3, cbtn4, cbtn5});

        Menu menu = new Menu();
        menu.setButton(new Button[]{plxbtn1, plxbtn2});

        return menu;

    }

    public static void main(String[] args) throws Exception {

        System.out.println("start------------");
        logger.debug("菜单创建开始！");

        //Menu menu = initMenu();
        //ObjectMapper mapper = new ObjectMapper();
        //String jsonMenu = mapper.writeValueAsString(menu);
        //
        //boolean result = MenuApi.creatMenu(TokenManage.getToken().getAccess_token(), jsonMenu);
        //if (result) {
        //    logger.info("菜单创建成功！");
        //} else {
        //    logger.error("菜单创建失败！");
        //}
    }
}
