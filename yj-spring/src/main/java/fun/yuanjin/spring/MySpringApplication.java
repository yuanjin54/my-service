package fun.yuanjin.spring;

import fun.yuanjin.spring.conf.AppConfig;
import fun.yuanjin.spring.service.IndexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MySpringApplication
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-10-21 10:40
 * @Version 1.0
 */
public class MySpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        System.out.println(context.getBean(IndexService.class));
    }
}
