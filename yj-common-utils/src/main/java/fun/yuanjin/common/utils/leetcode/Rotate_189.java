package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;

/**
 * @ClassName Rotate_189
 * @Description 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * @Author yuanjin
 * @Date 2021-01-08 10:36
 * @Version 1.0
 */
public class Rotate_189 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int t = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = t;
        }
        k = k % nums.length;
        for (int i = 0; i < k / 2; i++) {
            int t = nums[i];
            nums[i] = nums[k - i - 1];
            nums[k - i - 1] = t;
        }
        for (int i = 0; i < (len - k) / 2; i++) {
            int t = nums[i + k];
            nums[i + k] = nums[len - i - 1];
            nums[len - i - 1] = t;
        }
    }
}
