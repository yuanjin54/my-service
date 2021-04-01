package fun.yuanjin.common.utils.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FourSumCount454
 * @Description TODO
 * [1,2]
 * [-2,-1]
 * [-1,2]
 * [0,2]
 * @Author yuanjin
 * @Date 2020-11-27 10:25
 * @Version 1.0
 */
public class FourSumCount454 {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(fourSumCount(A, B, C, D));

    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int item = a + b;
                if (!map.containsKey(item)) {
                    map.put(item, 1);
                } else {
                    map.put(item, map.get(item) + 1);
                }
            }
        }
        for (int c : C) {
            for (int d : D) {
                int item = -(c + d);
                if (map.containsKey(item)) {
                    count += map.get(item);
                }
            }
        }
        return count;
    }
}
