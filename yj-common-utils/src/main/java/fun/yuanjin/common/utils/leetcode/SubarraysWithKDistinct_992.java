package fun.yuanjin.common.utils.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName SubarraysWithKDistinct_992
 * @Description 992. K 个不同整数的子数组
 * https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
 * @Author yuanjin
 * @Date 2021-02-09 17:28
 * @Version 1.0
 */
public class SubarraysWithKDistinct_992 {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 1, 2};
        int K = 1;
        System.out.println(subarraysWithKDistinct(A, K));
    }

    public static int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        for (int i = 0; i < A.length - K + 1; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(A[i]);
            for (int j = i; j < A.length; j++) {
                set.add(A[j]);
                if (set.size() == K) {
                    count++;
                } else if (set.size() > K) {
                    break;
                }
            }
        }
        return count;
    }
}
