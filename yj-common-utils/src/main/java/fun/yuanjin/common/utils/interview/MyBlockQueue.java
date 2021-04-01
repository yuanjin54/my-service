package fun.yuanjin.common.utils.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyBlockQueue
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-25 15:49
 * @Version 1.0
 */
public class MyBlockQueue<T> {
    private int size;
    private final List<T> data = new ArrayList<>();
    private final Lock myLock = new ReentrantLock();

    public MyBlockQueue(int size) {
        this.size = size;
    }

    public void produce(T t) {
        myLock.lock();
        try {
            while (data.size() == this.size) {
                System.out.println("队列中元素数量为" + size + "个，队列进入则阻塞状态");
                this.wait();
            }
            data.add(t);
            ++size;
            System.out.println("生产元素中元素数量size:" + size + " ");
            // 唤醒消费线程进行消费
            this.notifyAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            myLock.unlock();
        }

    }

    public T consumer() {
        T t = null;
        myLock.lock();
        try {
            while (data.size() == 0) {
                this.wait();
            }
            t = data.get(0);
            data.remove(0);
            --size;
            System.out.println("消费容器中元素数量为size:" + size + " ");
            // 唤醒生产线程进行生产
            this.notifyAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            myLock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyBlockQueue<Integer> queue = new MyBlockQueue<>(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer obj = 1;
                queue.produce(obj);
                System.out.println("开始生产：" + obj);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer obj = queue.consumer();
                System.out.println("开始消费：" + obj);
            }
        }).start();
    }
}
