package fun.yuanjin.registry.client.beat;

import fun.yuanjin.common.utils.RequestUtil;
import fun.yuanjin.common.utils.model.ReturnT;
import fun.yuanjin.registry.client.conf.ParamsConfiguration;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Detector
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-09-11 19:45
 * @Version 1.0
 */
@Slf4j
public class Detector {

    private String token;
    private String appName;
    private String address;
    private int port;

    private Thread registryThread;
    private volatile boolean toStop = false;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void initRegistry() {
        registryThread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        // registry
                        while (!toStop) {
                            try {
                                ReturnT<?> beatResult = RequestUtil.postBody(address + "beat", token, 3, null, String.class);
                                if (beatResult != null && ReturnT.SUCCESS_CODE == beatResult.getCode()) {
                                    beatResult = ReturnT.SUCCESS;
                                    log.debug(">>>>>>>>>>> xxl-job registry success, registryParam:{}, registryResult:{}", new Object[]{beatResult});
                                    break;
                                } else {
                                    log.info(">>>>>>>>>>> xxl-job registry fail, registryParam:{}, registryResult:{}", new Object[]{beatResult});
                                }
                            } catch (Exception e) {
                                if (!toStop) {
                                    log.info(">>>>>>>>>>> xxl-job registry error, registryParam:{}", e);
                                }

                            }

                            try {
                                if (!toStop) {
                                    TimeUnit.SECONDS.sleep(ParamsConfiguration.BEAT_TIMEOUT);
                                }
                            } catch (InterruptedException e) {
                                if (!toStop) {
                                    log.warn(">>>>>>>>>>> xxl-job, executor registry thread interrupted, error msg:{}", e.getMessage());
                                }
                            }
                        }
                    }
                }
        );
    }

}
