package com.self.wechat.material;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.wechat.base.BaseApi;
import com.self.wechat.base.BaseResult;
import com.self.wechat.client.HttpClientExecutor;
import com.self.wechat.material.bean.Articles;
import com.self.wechat.material.bean.MaterialCasMessage;
import com.self.wechat.material.bean.Media;
import com.self.wechat.material.bean.NewsSingleArticles;
import com.self.wechat.util.HttpUtil;
import com.self.wechat.util.JSONUtils;
import com.self.wechat.util.MimeType;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class MaterialApi extends BaseApi {
    private static Logger logger = LoggerFactory.getLogger(MaterialApi.class);

    /**
     * 下载临时素材
     *
     * @param token
     * @param media_id
     * @return
     * @throws Exception
     */
    public static MaterialCasMessage downloadMaterial(String token, String media_id) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URL.concat("/cgi-bin/media/get"))
                .addParameter("access_token", token)
                .addParameter("media_id", media_id)
                .addHeader("content-type", "application/json")
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, MaterialCasMessage.class);
    }

    /**
     * 上传图片或语音素材到微信
     *
     * @param url
     * @param filePath
     * @return
     */
    public static String uploadImgOrVoice(String url, String filePath) {
        File file = new File(filePath);
        if (!file.exists())
            return null;
        OutputStream output = null;
        InputStream input = null, response = null;
        try {
            String boundary = "-----------------------------" + System.currentTimeMillis();
            HttpURLConnection conn = connection(url, boundary);
            input = new FileInputStream(file);
            output = new DataOutputStream(conn.getOutputStream());
            writeDate(output, input, boundary, file.getName());
            output.flush();
            output.close();
            input.close();

            response = conn.getInputStream();
            String result = readResponse(response);
            response.close();
            return result;
        } catch (Exception e) {
            logger.error("上传图片或语音失败", e);
        } finally {
            try {
                if (output != null) output.close();
                if (input != null) input.close();
                if (response != null) response.close();
            } catch (IOException e) {
                logger.error("字节流关闭异常", e);
            }
        }
        return null;
    }

    /**
     * 上传图文素材
     *
     * @param token
     * @param article
     * @throws Exception
     */
    public static void uploadNewsMaterial(String token, Articles article) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonItem = mapper.writeValueAsString(article);
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", token);
        JsonNode jsonNode = HttpUtil.httpsRequest(url, "POST", jsonItem);
        if (null != jsonNode && null == jsonNode.get("errcode")) {
            String media_id = jsonNode.get("media_id").toString();
            logger.info(media_id);
        } else {
            logger.info(jsonNode.get("errcode").toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>" + jsonNode.get("errmsg").toString());
        }
    }

    /**
     * 删除永久素材
     *
     * @param token
     * @param media_id
     * @return
     * @throws Exception
     */
    public static BaseResult deleteMaterial(String token, String media_id) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("media_id", media_id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URL + "/cgi-bin/material/del_material")
                .addParameter("access_token", token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 修改永久图文素材
     *
     * @param token
     * @param media_id
     * @param index
     * @param articles
     * @return
     * @throws Exception
     */
    public static BaseResult updateNewsMaterial(String token, String media_id, String index, NewsSingleArticles articles) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("media_id", media_id);
        map.put("index", index);
        map.put("articles", articles);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URL + "/cgi-bin/material/update_news")
                .addParameter("access_token", token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 创建上传文件的链接
     *
     * @param url
     * @param boundary
     * @return
     * @throws Exception
     */
    private static HttpURLConnection connection(String url, String boundary) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(30000);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setRequestProperty("Cache-Control", "no-cache");
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        return conn;
    }

    /**
     * 将上传文件的字节写入上传管道
     *
     * @param output
     * @param input
     * @param boundary
     * @param fileName
     * @throws IOException
     */
    private static void writeDate(OutputStream output, InputStream input,
                                  String boundary, String fileName) throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("--").append(boundary).append("\r\n")
                .append("Content-Disposition: form-data;name=\"media\";filename=\"").append(fileName).append("\"\r\n")
                .append("Content-Type: ").append(MimeType.fileMimeType(fileName)).append("\r\n\r\n");

        output.write(buffer.toString().getBytes("utf-8"));
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = input.read(data)) > -1) {
            output.write(data, 0, len);
        }
        output.write(("--" + boundary + "\r\n").getBytes("utf-8"));
    }

    /**
     * 获取上传的响应结果
     *
     * @param input
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    private static String readResponse(InputStream input) throws IOException {
        StringBuffer sb = new StringBuffer();
        int len = 0;
        byte[] data = new byte[512];
        while ((len = input.read(data)) > -1)
            sb.append(new String(data, 0, len, "utf-8"));
        logger.info("上传文件结果：{}", sb.toString());
        return sb.toString();
    }

    /**
     * 新增其他非图文类型永久素材
     *
     * @param access_token
     * @param type
     * @param media
     * @return
     */
    public static Media mediaUploadGraphic(String access_token, String type, File media) {
        Media weixinMedia = new Media();
        String result = null;
        try {
            // 拼装请求地址
            String uploadMediaUrl = String.format(
                    "http://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%1s&type=%2s",
                    access_token,
                    type);
            URL url = new URL(uploadMediaUrl);
            //File file = new File("mediaFileUrl");
            if (!media.exists() || !media.isFile()) {
                out.println("上传的文件不存在");
            }

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false); // post方式不能使用缓存
            // 设置请求头信息
            con.setRequestProperty("Connection", "Keep-Alive");
            con.setRequestProperty("Charset", "UTF-8");
            // 设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            // 请求正文信息
            // 第一部分：
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            String filename = media.getName();
            sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + filename + "\" \r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");

            // 获得输出流
            OutputStream out = new DataOutputStream(con.getOutputStream());
            // 输出表头
            out.write(head);
            // 文件正文部分
            // 把文件已流文件的方式 推入到url中
            DataInputStream in = new DataInputStream(new FileInputStream(media));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            in.close();

            // 结尾部分
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            out.write(foot);
            out.flush();
            out.close();

            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = null;
            // 定义BufferedReader输入流来读取URL的响应
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            if (result == null) {
                result = buffer.toString();
            }

            System.out.println(result);
            //Gson gson = new Gson();
            // 解析返回结果
            //Map jsonObject = gson.fromJson(result, Map.class);
            JsonNode jsonNode = null;

            ObjectMapper mapper = new ObjectMapper();
            jsonNode = mapper.readTree(result);

            if (jsonNode.get("errcode") != null) {
                weixinMedia.setErrcode(jsonNode.get("errcode").toString());
                weixinMedia.setErrmsg(jsonNode.get("errmsg").toString());

                return weixinMedia;
            }

            weixinMedia.setType(type);
            weixinMedia.setUrl(jsonNode.get("url").toString());

            // type等于thumb时的返回结果和其它类型不一样
            if ("thumb".equals(type)) {
                weixinMedia.setMedia_id(jsonNode.get("thumb_media_id").toString());
            } else {
                weixinMedia.setMedia_id(jsonNode.get("media_id").toString());
            }


        } catch (IOException e) {
            out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        } finally {
        }

        return weixinMedia;
    }
}
