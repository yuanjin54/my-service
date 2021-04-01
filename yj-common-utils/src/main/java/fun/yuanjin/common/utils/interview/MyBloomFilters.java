package fun.yuanjin.common.utils.interview;

/**
 * @ClassName MyBloomFilters
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-24 15:20
 * @Version 1.0
 */
public class MyBloomFilters {
    /**
     * 数组长度
     */
    private int size;
    /**
     * 数组
     */
    private int[] arr;

    public MyBloomFilters(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    /**
     * 添加元素
     *
     * @param key
     */
    public void add(String key) {
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);
        arr[first % size] = 1;
        arr[second % size] = 1;
        arr[third % size] = 1;
    }

    /**
     * 查询元素是否存在
     *
     * @param key
     * @return
     */
    public boolean check(String key) {
        int first = hashcode_1(key);
        if (arr[first % size] == 0) {
            return false;
        }
        int second = hashcode_2(key);
        if (arr[second % size] == 0) {
            return false;
        }
        int third = hashcode_3(key);
        return arr[third % size] == 1;
    }

    /**
     * hash 算法1
     *
     * @param key
     * @return
     */
    private int hashcode_1(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    /**
     * hash 算法2
     *
     * @param data
     * @return
     */
    private int hashcode_2(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++) {
            hash = (hash ^ data.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    /**
     * hash 算法3
     *
     * @param key
     * @return
     */
    private int hashcode_3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }
}

class MyBloomFiltersTest {
    public static void main(String[] args) {
        long star = System.currentTimeMillis();
        MyBloomFilters bloomFilters = new MyBloomFilters(10000000);
        for (int i = 0; i < 10000000; i++) {
            bloomFilters.add(i + "");
        }
        System.out.println(bloomFilters.check(1 + ""));
        System.out.println(bloomFilters.check(2 + ""));
        System.out.println(bloomFilters.check(3 + ""));
        System.out.println(bloomFilters.check(999999 + ""));
        System.out.println(bloomFilters.check(400230340 + ""));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }
}