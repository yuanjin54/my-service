package fun.yuanjin.springBootDemo.exector;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;
import fun.yuanjin.springBootDemo.task.TokenBucketExecutorTestTask;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @ClassName TokenBucketExecutor
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-14 10:33
 * @Version 1.0
 */
@Component
public class TokenBucketExecutor {
    /**
     * create thread pool
     */
    private static final ExecutorService EXECUTORS = new ThreadPoolExecutor(
            2,
            100,
            100L,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(100000),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    private ListeningExecutorService executorService = MoreExecutors.listeningDecorator(EXECUTORS);

    public void doTask() {
        // 指定每秒放入多少个令牌
        RateLimiter limiter = RateLimiter.create(1);
        for (int i = 0; i < 50; i++) {
            // 获取令牌数
            int count = 0;
            if (i == 0) {
                count = 2;
            } else if (i == 1) {
                count = 10;
            } else {
                count = 2;
            }
            // 表示获取count个令牌时，需要等待的时间
            Double acquire = limiter.acquire(count);
            executorService.submit(new TokenBucketExecutorTestTask("执行第" + i + "个任务，获取" + count + "个令牌成功，耗时：" + acquire + "秒"));
        }
    }

}
