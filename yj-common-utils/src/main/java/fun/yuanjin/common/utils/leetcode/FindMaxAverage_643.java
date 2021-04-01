package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName FindMaxAverage_643
 * @Description 643. 子数组最大平均数 I
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * @Author yuanjin
 * @Date 2021-02-04 23:04
 * @Version 1.0
 */
public class FindMaxAverage_643 {
    public static void main(String[] args) {

    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max * 1.0 / k;
    }
}
