package fun.yuanjin.common.utils.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName NumEquivDominoPairs_1128
 * @Description https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 * @Author yuanjin
 * @Date 2021-01-26 22:49
 * @Version 1.0
 */
public class NumEquivDominoPairs_1128 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger c = new AtomicInteger();
        for (int[] domino : dominoes) {
            int s1 = domino[0] * 10 + domino[1];
            int s2 = domino[1] * 10 + domino[0];
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else if (map.containsKey(s2)) {
                map.put(s2, map.get(s2) + 1);
            } else {
                map.put(s1, 1);
            }
        }
        map.forEach((k, v) -> {
            if (v > 1) {
                c.addAndGet(v);
            }
        });
        return c.get();

    }
}
