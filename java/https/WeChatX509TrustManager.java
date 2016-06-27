package www.hbws.com.util.wechat;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * title:WeChatX509TrustManager
 * author: wangjianfeng
 * date:  2016/5/23 0023
 * description:获取wechat的token需要进行https请求，
 *             这个证书管理器的作用就是让他信任我们指定的证书
 *             下面的代码意味着信任所有证书，不管是否权威机构颁发
 */
public class WeChatX509TrustManager implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
