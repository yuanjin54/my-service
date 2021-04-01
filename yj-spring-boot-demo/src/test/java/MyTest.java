import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName MyTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-10-26 11:20
 * @Version 1.0
 */
public class MyTest {
    public static void main(String[] args) {
        String url = "http://p0.meituan.net/tdchoteldark/0d84b2f1eecd6fb90e2900122969586e781393.jpg";
        String domain = "meituan.com";

        String s2 = "";
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s2 = replaceDomain1(url, domain);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(s2);
        System.out.println((t2 - t1));

        String s1 = "";
        long t3 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s1 = replaceDomain(url, domain);
        }
        long t4 = System.currentTimeMillis();
        System.out.println(s1);
        System.out.println((t4 - t3));
    }


    /**
     * url域名替换成内网
     *
     * @param url    带处理的url
     * @param domain 域名
     * @return 替换域名之后的url
     */
    public static String replaceDomain(String url, String domain) {
        if (url == null || "".equals(url.trim())) {
            return url;
        }
        StringBuilder newUrl = new StringBuilder();
        if (url.contains("//")) {
            String[] arr = url.split("//");
            String[] urlArr = arr[1].split("/");
            if (urlArr.length > 1) {
                newUrl.append(arr[0]).append("//").append(domain);
                for (int i = 1; i < urlArr.length; i++) {
                    newUrl.append("/").append(urlArr[i]);
                }
                return newUrl.toString();
            }
        }
        return url;
    }

    /**
     * url域名替换成内网
     *
     * @param url    带处理的url
     * @param domain 域名
     * @return 替换域名之后的url
     */
    public static String replaceDomain1(String url, String domain) {
        if (url == null || "".equals(url.trim())) {
            return url;
        }
        if (url.contains("//")) {
            String[] arr = url.split("//");
            String[] urlArr = arr[1].split("/");
            String oldDomain = urlArr[0];

            return url.replace(oldDomain, domain);

        }
        return url;
    }

}
