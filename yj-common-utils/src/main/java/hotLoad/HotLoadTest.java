package hotLoad;

import java.lang.reflect.Method;

/**
 * @ClassName HotLoadTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-18 22:58
 * @Version 1.0
 */
public class HotLoadTest {
    public static void main(String[] args) {
        //自定义类加载器for循环加载Demo1.class。修改Demo1类的test()方法之后，重新编译，Demo1.class被重新加载，实现热替换
        while (true){
            try {
                MyClassLoader myClassLoader = new MyClassLoader("/Users/yuanjin/IdeaProjects/my-service/yj-common-utils/src/main/java/hotLoad/");
                Class clazz = myClassLoader.findClass("Demo1");
                Object o = clazz.newInstance();
                Method method = clazz.getMethod("test");
                method.invoke(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
