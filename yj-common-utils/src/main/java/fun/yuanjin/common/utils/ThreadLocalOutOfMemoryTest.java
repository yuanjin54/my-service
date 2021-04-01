package fun.yuanjin.common.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocalOutOfMemoryTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-04 23:20
 * @Version 1.0
 */
public class ThreadLocalOutOfMemoryTest {
    static class LocalVariable {
        private Long[] a = new Long[1024*1024];
    }

    // (1)
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(6, 6, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());
    // (2)
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set(new LocalVariable());
            }
        }).start();


        // (3)
        for (int i = 0; i < 50; ++i) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    // (4)
                    localVariable.set(new LocalVariable());
                    // (5)
                    System.out.println("use local varaible");
                    localVariable.remove();

                }
            });

            Thread.sleep(1000);
        }
        // (6)
        System.out.println("pool execute over");
    }
}
