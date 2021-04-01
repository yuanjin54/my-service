package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName FindLengthOfLCIS_674
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-24 09:35
 * @Version 1.0
 */
public class FindLengthOfLCIS_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0;
        int max = 0;
        int c = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] - nums[j - 1] > 0) {
                c++;
            } else {
                max = Math.max(max, c);
                c = 1;
            }
        }
        return Math.max(max, c);
    }
}
