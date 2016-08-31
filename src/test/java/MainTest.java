import com.self.wechat.material.bean.Media;
import com.self.wechat.token.TokenManage;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.self.wechat.material.MaterialAPI.mediaUploadGraphic;

/**
 * 描述：TODO
 *
 * @author zhangmengwen
 * @date 2016/8/24
 */
public class MainTest {

    private static Logger logger = LoggerFactory.getLogger(MainTest.class);

    public static void main(String[] args) throws Exception {
        String type = "image";
        //String token = "f9ppV9lxD27r-m2FYWpcKsYwF0h2TdAMtlynVE1L7xPn_SMX_0rMMF2TaeY_cCuvjG-8lbgL3Nr56BF1dF_a5ZGVSeLWu-kz2aZL3YV6K7WIucT6npyL3LZlkQJWF_AYFKXeADALQD";
        String token = TokenManage.getToken().getAccess_token();
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + token + "&type=" + type;

        File file = new File("E:/animal.jpg");
        Media media = mediaUploadGraphic(token, "image", file);
        System.out.println(media.toString());
    }

    //public static void main(String[] args) throws Exception {
    //    String str = "http://blog.csdn.net/ligang2585116/article/details/52315710";
    //    //1.HttpClient
    //    //CloseableHttpClient httpClient = HttpClients.createDefault();
    //    //HttpGet httpGet = new HttpGet(str);
    //    //CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
    //    //
    //    //System.out.println(httpResponse);
    //
    //    //2.HttpURLConnection
    //    URL url = new URL(str);
    //    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    //    HttpURLConnection conn = httpURLConnection;
    //    conn.setRequestMethod("GET");
    //    conn.setConnectTimeout(5000);
    //    conn.setReadTimeout(5000);
    //    conn.setDoInput(true);
    //    conn.setDoOutput(true);
    //    conn.setUseCaches(false);
    //    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
    //    conn.connect();
    //    InputStream inputStream = conn.getInputStream();
    //    OutputStream outputStream = new FileOutputStream("E://test.html");
    //    int byteRead = 0;
    //    byte[] buffer = new byte[8192];
    //    while((byteRead = inputStream.read(buffer,0,8192)) != -1){
    //        outputStream.write(buffer,0,byteRead);
    //    }
    //    outputStream.close();
    //    inputStream.close();
    //}
    @Test
    @Ignore
    public void testMultipartEntityBuilder() {
        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            String BOUNDARY = "----------" + System.currentTimeMillis();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.setCharset(Charset.forName("UTF-8"));
            builder.setContentType(ContentType.MULTIPART_FORM_DATA);
            builder.setBoundary(BOUNDARY);

            File media = new File("E:/moning.png");
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            String filename = media.getName();
            sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + filename + "\" \r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");


            HttpPost httpPost = new HttpPost();
            byte[] head = sb.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void testHttpServletRequest(HttpServletRequest request) {
        Map map = new HashMap();

        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }

        Set<Map.Entry<String, String>> set = map.entrySet();
        System.out.println("------------------------------");
        for (Map.Entry entry : set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("------------------------------");
    }
}
