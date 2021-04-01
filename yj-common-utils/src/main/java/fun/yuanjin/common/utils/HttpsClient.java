package fun.yuanjin.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author yuanjin
 */
public class HttpsClient {

    /**
     * 设置信任自签名证书
     *
     * @param keyStorePath 密钥库路径
     * @param keyStorepass 密钥库密码
     * @return SSLContext
     */
    public static SSLContext custom(String keyStorePath, String keyStorepass) throws FileNotFoundException, KeyStoreException {

        String filename = System.getProperty("java.home") + "/lib/security/cacerts".replace('/', File.separatorChar);
        FileInputStream is = new FileInputStream(filename);
        // 必须先加载keystore，才能对其进行访问
        KeyStore jdkKeystore = KeyStore.getInstance(KeyStore.getDefaultType());
        String password = "changeit";

        SSLContext sc = null;
        FileInputStream instream = null;
        KeyStore trustStore = null;
        try {
            // 加载
            jdkKeystore.load(is, password.toCharArray());
            System.out.println("here");
            // 加载了 keystore，就能够从 keystore 读取现有条目，或向 keystore 写入新条目
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            instream = new FileInputStream(new File(keyStorePath));
            trustStore.load(instream, keyStorepass.toCharArray());
            Enumeration<String> sa = jdkKeystore.aliases();
            while (sa.hasMoreElements()) {
                String alias = sa.nextElement();
                Certificate cert = jdkKeystore.getCertificate(alias);
                trustStore.setCertificateEntry(alias, cert);
            }
            System.out.println("there");


            // 相信自己的CA和所有自签名的证书
            sc = SSLContexts.custom().loadTrustMaterial(trustStore, null).build();
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException | KeyManagementException e) {
            e.printStackTrace();
        } finally {
            try {
                instream.close();
            } catch (IOException e) {
            }
        }
        return sc;
    }

    /**
     * 模拟请求
     *
     * @param url      资源地址
     * @param map      参数列表
     * @param encoding 编码
     * @return
     * @throws IOException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws ClientProtocolException
     */
    public static String send(String url, Map<String, String> map, String encoding) throws ClientProtocolException, IOException, KeyStoreException {
        String body = "";

        //tomcat是我自己的密钥库的密码，你可以替换成自己的
        //如果密码为空，则用"nopassword"代替
        SSLContext sslcontext = custom("/home/wsl/workspace/tsap-adapter/tsap-adapter-sdk-script/src/main/resources/client1.jks", "123456");

        // 设置协议http和https对应的处理socket链接工厂的对象
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

        //创建自定义的httpclient对象
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();
//		CloseableHttpClient client = HttpClients.createDefault();

        //创建post方式请求对象
        HttpGet httpPost = new HttpGet(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }


        System.out.println("请求地址：" + url);
        System.out.println("请求参数：" + nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
//        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
//        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }

    public static void main(String[] args) throws ParseException, IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        String url = "https://www.baidu.com";
        String body = send(url, null, "utf-8");
        System.out.println("交易响应结果长度：" + body);

        System.out.println("-----------------------------------");


    }
}
