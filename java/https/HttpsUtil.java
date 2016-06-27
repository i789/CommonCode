package www.hbws.com.util.wechat;


import com.sun.deploy.net.HttpResponse;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import sun.net.www.http.HttpClient;
import www.hbws.com.util.Constant;
import www.hbws.com.util.wechat.pojo.AccessToken;
import www.hbws.com.util.wechat.pojo.Menu;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * title:HttpsUtil
 * author: wangjianfeng
 * date:  2016/5/23 0023
 */
public class HttpsUtil {
    private static Logger log = LoggerFactory.getLogger(HttpsUtil.class);

    /**
     * 发送https请求获取JSON对象
     *
     * @param requestUrl 请求url
     * @param requestMethod GET/POST
     * @param outputStr
     * @return 返回请求到的结果 JSON
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();

        try {
            TrustManager[] tm = {
                    new WeChatX509TrustManager()
            };

            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");

            sslContext.init(null, tm, new java.security.SecureRandom());

            // 获取SSLFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(ssf);

            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);

            // 设置请求方式(GET/POST)
            httpsURLConnection.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpsURLConnection.connect();
            }

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流缓存字符串
            InputStream inputStream = httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while (null != (str = bufferedReader.readLine())) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();

            // 释放资源
            inputStream.close();
            inputStream = null;
            httpsURLConnection.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());

        } catch (ConnectException e) {
            log.error("微信服务器连接超时");
        } catch (Exception e) {
            log.error("https request {}", e);
        }

        return jsonObject;
    }
}
