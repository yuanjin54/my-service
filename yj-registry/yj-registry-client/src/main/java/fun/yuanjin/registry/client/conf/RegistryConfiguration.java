package fun.yuanjin.registry.client.conf;

import fun.yuanjin.registry.client.beat.BeatDetector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RegistryConfiguration
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-09-11 17:25
 * @Version 1.0
 */
@Configuration
public class RegistryConfiguration {
    @Value("${registry.center.address}")
    private String address;

    @Value("${registry.center.token}")
    private String accessToken;

    @Value("${app.name}")
    private String appName;

    @Value("${registry.center.port}")
    private int port;

    @Bean
    public BeatDetector detector() {
        BeatDetector beatDetector = new BeatDetector();
        beatDetector.setAddress(address);
        beatDetector.setAppName(appName);
        beatDetector.setToken(accessToken);
        beatDetector.setPort(port);
        return beatDetector;
    }

}
