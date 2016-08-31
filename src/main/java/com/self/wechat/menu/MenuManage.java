package com.self.wechat.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
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

        //ClickButton cbtn5 = new ClickButton();
        //cbtn5.setName("多图文-最后一条不含图片");
        //cbtn5.setKey("new5");

        ClickButton cbtn6 = new ClickButton();
        cbtn6.setName("模板消息测试");
        cbtn6.setKey("buy");

        ViewButton vbtn1 = new ViewButton();
        vbtn1.setName("百度");
        vbtn1.setUrl("http://www.baidu.com");

        ViewButton vbtn2 = new ViewButton();
        vbtn2.setName("联连资讯");
        vbtn2.setUrl("http://34dcf3de.ngrok.io/wechat/news");

        ComplexButton plxbtn1 = new ComplexButton();
        plxbtn1.setName("网站");
        plxbtn1.setSub_button(new Button[]{vbtn1, vbtn2});

        ComplexButton plxbtn2 = new ComplexButton();
        plxbtn2.setName("image");
        plxbtn2.setSub_button(new Button[]{cbtn1, cbtn2, cbtn3, cbtn4, cbtn6});

        mediaButton mbtn1 = new mediaButton();
        mbtn1.setName("单图文");
        mbtn1.setMedia_id("c-jZORW9mt37UqQuQJIxnhmt3FBfnuWSw-DxN8O0WZI");

        mediaButton mbtn2 = new mediaButton();
        mbtn2.setName("多图文101");
        mbtn2.setMedia_id("c-jZORW9mt37UqQuQJIxno0DQltaCHk4CJFl3Kng158");

        ComplexButton plxbtn3 = new ComplexButton();
        plxbtn3.setName("回复图文");
        plxbtn3.setSub_button(new Button[]{mbtn1, mbtn2});

        Menu menu = new Menu();
        menu.setButton(new Button[]{plxbtn1, plxbtn2,  plxbtn3});

        return menu;

    }

    public static void main(String[] args) throws Exception {

        String token = "SaD9rx88LR7g0vBgtdb-tBvLs4aAgiIwdxDb2B45c3PbbZYbgT3bhrzec-kR-_Hu4c0V8rus8Gin1uZpBrpGZZFb1HFPpPanYTZENhDBGIMuVil1Wc0yjD3PzNR4DDAzDYFaAIANIP";

        Menu menu = initMenu();
        ObjectMapper mapper = new ObjectMapper();
        String jsonMenu = mapper.writeValueAsString(menu);
        //String token = TokenManage.getToken().getAccess_token();
        System.out.println(token);
        logger.info("创建菜单token>>>>>>>>>>>>>>>>>>"+token);
        boolean result = MenuApi.creatMenu(token, jsonMenu);
        if (result) {
            logger.info("菜单创建成功！");
        } else {
            logger.error("菜单创建失败！");
        }

        //String token = TokenManage.getToken().getAccess_token();
        //logger.info("删除菜单token>>>>>>>>>>>>>>>>>>"+token);
        //boolean result = MenuApi.deleteMenu(token);
        //if(result){
        //    logger.info("菜单删除成功！");
        //}else{
        //    logger.error("菜单删除失败！");
        //}


        //logger.info(MenuApi.getMenu(token));
        //
        //logger.info(MenuApi.getMenuInfo(token));
    }
}
