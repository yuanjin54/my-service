package fun.yuanjin.registry.client.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName BeatThread
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-09-14 11:21
 * @Version 1.0
 */
@Slf4j
public class BeatThread implements Runnable {

    private volatile boolean toStop = false;

    @Override
    public void run() {

    }
}
