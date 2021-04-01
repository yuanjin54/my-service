package fun.yuanjin.common.utils;

/**
 * @ClassName TestJvm
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-17 22:05
 * @Version 1.0
 */
public class TestJvm {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] a4;
//        a1 = new byte[2 * _1M];
//        a2 = new byte[2 * _1M];
//        a3 = new byte[2 * _1M];
        a4 = new byte[10 * _1M];

        Integer i = 10;
        Thread.sleep(100000);

    }
}
