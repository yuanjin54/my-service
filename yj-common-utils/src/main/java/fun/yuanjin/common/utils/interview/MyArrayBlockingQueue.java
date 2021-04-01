package fun.yuanjin.common.utils.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Q
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-25 15:37
 * @Version 1.0
 */
public class MyArrayBlockingQueue<T> {
    /*
     * 调用无参构造方法，阻塞队列的默认长度
     */
    public static final int SIZE_VALUE = 10;
    /*
     * 队列的容器存放队列的元素
     */
    public final List<T> lists = new ArrayList<>();
    /*
     * 队列的最大容量
     */
    private final int maxSize;
    /*
     * 队列当前元素个数
     */
    private int size = 0;

    public MyArrayBlockingQueue() {
        super();
        this.maxSize = SIZE_VALUE;
    }

    /**
     * 带参构造方法，创建时可设定队列最大元素
     *
     * @param maxSize 队列最大元素数量
     */
    public MyArrayBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 生产者向容器中插入元素时调用的方法
     *
     * @param t 传入队列中的元素
     * @throws InterruptedException 向上抛出线程中断的异常
     */
    public synchronized void put(T t) throws InterruptedException {
        while (lists.size() == maxSize) {
            System.out.println("队列中元素数量为" + maxSize + "个，队列进入则阻塞状态");
            this.wait();
        }
        lists.add(t);
        ++size;
        System.out.println("生产元素中元素数量size:" + size + " ");
        this.notifyAll();//唤醒消费线程进行消费
    }

    /**
     * 消费者从容器中取元素时调用的方法
     */
    public synchronized T get() {
        T t = null;
        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.get(0);
        lists.remove(0);
        --size;
        System.out.println("消费容器中元素数量为size:" + size + " ");
        this.notifyAll();//唤醒生产线程进行生产
        return t;
    }

    /**
     * 队列当前元素数量
     */
    public int getSize() {
        return size;
    }


    public static void main(String[] args) {
        MyArrayBlockingQueue<Integer> integerQueue = new MyArrayBlockingQueue<Integer>(3);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                Integer threadId = finalI;
                try {
                    integerQueue.put(threadId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Integer take = integerQueue.get();
                System.out.println(take);
            }).start();
        }
    }
}
