package fun.yuanjin.springBootDemo.task;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;
import fun.yuanjin.common.utils.DateUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TokenBucketExecutorTestTask
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-14 10:38
 * @Version 1.0
 */
public class TokenBucketExecutorTestTask implements Runnable {

    private String content;

    public TokenBucketExecutorTestTask(String content) {
        this.content = content;
    }

    @Override
    public void run() {
        System.out.println(DateUtils.getNowString() + " | " + Thread.currentThread().getName() + content);
    }
}
