package fun.yuanjin.common.utils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ListTest
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-07 10:16
 * @Version 1.0
 */
public class ListTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
//            String tmp = iter.next();
//            System.out.println(tmp);
//            if (tmp.equals("1")) {
//                list.remove("1");
//            }
//        }
        ReentrantLock lock = new ReentrantLock(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("ssda");
                long s = System.currentTimeMillis();
                while (true) {
                    long e = System.currentTimeMillis();
                    if (e - s > 20000) {
                        break;
                    }
                }
                lock.unlock();
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                long s = System.currentTimeMillis();
                while (true) {
                    long e = System.currentTimeMillis();
                    if (e - s > 30000) {
                        break;
                    }
                }
                System.out.println("ssda2222");
                lock.unlock();
            }
        },"t2").start();


    }
}
