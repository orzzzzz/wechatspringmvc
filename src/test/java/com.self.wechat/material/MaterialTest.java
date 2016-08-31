package com.self.wechat.material;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.wechat.base.BaseResult;
import com.self.wechat.material.bean.Articles;
import com.self.wechat.material.bean.Media;
import com.self.wechat.material.bean.NewsSingleArticles;
import com.self.wechat.token.TokenManage;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：素材管理测试
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class MaterialTest {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("a","a1");
        map.put(null,"ahdah");
        map.put("b","b1");
        map.put("a","a2");
        System.out.println(map.entrySet().toString());

    }

    /**
     * 测试上传图片或语音
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testUploadImgOrVoice() throws Exception {
        String type = "image";
        String token = "QADFL8S3QPhUir5gW9qw_JlrTE4bKyc3vkEpyu7-Z31eHhUPZqqTbGm24AFhyjykDwVzulOKS52Yapg36i74lEHGD3g-sik_vWGu3uVM6QU9T9OPkVOkfMhs4z-Sp1OgTMLaAHAMFE";
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + token + "&type=" + type;
        String uploadMediaUrl = String.format(
                "http://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%1s&type=%2s",
                token,
                type);
        String result = MaterialAPI.uploadImgOrVoice(uploadMediaUrl, "E:/moning.png");
        System.out.println(result);
    }

    /**
     * 测试新增其他非图文类型永久素材
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testMediaUploadGraphic() throws Exception {
        String token = "9--B8N4GM8Q_RsI1bNE5M51KLqaaDkWMJC_TMCNrGJHkfJhyFA20lRnfnGzQuhfCBOvzg3uhs8ZIyc1J6Uosgav0A7GSL-kgKmW6L0XSP2vYQ9dGYJMbExBWoTbktItDWXUbAHANOL";
        File file = new File("E:/animal.jpg");
        Media media = MaterialAPI.mediaUploadGraphic(token, "image", file);
        System.out.println(media.getErrcode());
        System.out.println(media.toString());
    }

    /**
     * 测试删除永久素材
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testDeleteMaterial() throws Exception {
        String token = TokenManage.getToken().getAccess_token();
        BaseResult result = MaterialAPI.deleteMaterial(token,"c-jZORW9mt37UqQuQJIxnnT0w2qcgVJ5-m_tGCv1jRg");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(result));
    }

    /**
     * 测试修改永久图文素材
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testUpdateNewsMaterial() throws Exception {
        String token = TokenManage.getToken().getAccess_token();
        String media_id = "c-jZORW9mt37UqQuQJIxnhmt3FBfnuWSw-DxN8O0WZI";
        NewsSingleArticles articles = new NewsSingleArticles();
        articles.setTitle("小松鼠");
        articles.setThumb_media_id("c-jZORW9mt37UqQuQJIxnlK7qn4X4R0OtV-SW9ofHfg");
        articles.setAuthor("zmw");
        articles.setDigest("松鼠很可爱！！");
        articles.setShow_cover_pic(1);
        articles.setContent("松鼠爱吃松仁。");
        articles.setContent_source_url("http://lijingshou.iteye.com/blog/2003020");

        BaseResult result = MaterialAPI.updateNewsMaterial(token, media_id, "0", articles);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(result));
    }

    @Test
    @Ignore
    public void testUploadNewsMaterial() throws Exception {
        String token = "SaD9rx88LR7g0vBgtdb-tBvLs4aAgiIwdxDb2B45c3PbbZYbgT3bhrzec-kR-_Hu4c0V8rus8Gin1uZpBrpGZZFb1HFPpPanYTZENhDBGIMuVil1Wc0yjD3PzNR4DDAzDYFaAIANIP";
        Articles articles = new Articles();
        NewsSingleArticles articles1 = new NewsSingleArticles();
        articles1.setTitle("多图文第一条");
        articles1.setThumb_media_id("c-jZORW9mt37UqQuQJIxnlK7qn4X4R0OtV-SW9ofHfg");
        articles1.setAuthor("zmw");
        articles1.setDigest("第一条摘要");
        articles1.setShow_cover_pic(1);
        articles1.setContent("第一条正文内容");
        articles1.setContent_source_url("http://mp.weixin.qq.com/wiki/14/7e6c03263063f4813141c3e17dd4350a.html");

        NewsSingleArticles articles2 = new NewsSingleArticles();
        articles2.setTitle("多图文第二条");
        articles2.setThumb_media_id("c-jZORW9mt37UqQuQJIxnpqYtPls3BTATmzyxg3Vz78");
        articles2.setAuthor("zmw");
        articles2.setDigest("第二条摘要");
        articles2.setShow_cover_pic(0);
        articles2.setContent("第二条正文内容");
        articles2.setContent_source_url("http://blog.csdn.net/xueyushenzhou/article/details/52372499");

        NewsSingleArticles articles3 = new NewsSingleArticles();
        articles3.setTitle("多图文第三条");
        articles3.setThumb_media_id("c-jZORW9mt37UqQuQJIxnkA2KexL5dNy884Jd7klLZQ");
        articles3.setAuthor("zmw");
        articles3.setDigest("第三条摘要");
        articles3.setShow_cover_pic(1);
        articles3.setContent("第三条正文内容");
        articles3.setContent_source_url("http://mp.weixin.qq.com/wiki/17/fa4e1434e57290788bde25603fa2fcbd.html");

        articles.setArticles(new NewsSingleArticles[]{articles1, articles2, articles3});
        MaterialAPI.uploadNewsMaterial(token,articles);
    }
}
