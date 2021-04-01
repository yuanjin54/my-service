package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName FairCandySwap_888
 * @Description https://leetcode-cn.com/problems/fair-candy-swap/
 * @Author yuanjin
 * @Date 2021-02-01 22:28
 * @Version 1.0
 */
public class FairCandySwap_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = Arrays.stream(A).sum();
        int sb = Arrays.stream(B).sum();
        int mid = (sa + sb) >> 2;
        Set<Integer> set = new HashSet<>();
        for (int e : A) {
            set.add(e);
        }
        int[] res = new int[2];
        for (int b : B) {
            int s = sa + b - mid;
            if (set.contains(s)) {
                res[0] = s;
                res[1] = b;
                break;
            }
        }
        return res;
    }
}
