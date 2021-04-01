package fun.yuanjin.registry.client.beat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName BeatDetector
 * @Description 心跳检测器
 * @Author yuanjin
 * @Date 2020-09-11 19:43
 * @Version 1.0
 */
public class BeatDetector extends Detector implements ApplicationContextAware, SmartInitializingSingleton, DisposableBean {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeatDetector.applicationContext = applicationContext;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterSingletonsInstantiated() {
        super.initRegistry();
    }
}
