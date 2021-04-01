package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;

/**
 * @ClassName ReversePairs493
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-28 21:57
 * @Version 1.0
 */
public class ReversePairs493 {
    public static void main(String[] args) {
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(reversePairs(nums));
        int[] A = {3, 6, 2, 3};
        System.out.println(largestPerimeter1(A));
    }

    public static int largestPerimeter(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    for (int k = 0; k < len; k++) {
                        if (k != i && k != j && A[i] + A[j] > A[k] && Math.abs(A[i] - A[j]) < A[k]) {
                            max = Math.max(max, A[i] + A[j] + A[k]);
                        }
                    }
                }
            }
        }
        return max;
    }

    public static int largestPerimeter1(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 2; j < A.length; j++) {
                if (isTriangle(A[i], A[i + 1], A[j])) {
                    return A[i] + A[i + 1] + A[j];
                } else {
                    break;
                }
            }
        }
        return 0;
    }

    public static boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
