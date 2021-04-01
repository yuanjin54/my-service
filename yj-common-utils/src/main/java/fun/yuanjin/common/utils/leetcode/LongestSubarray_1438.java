package fun.yuanjin.common.utils.leetcode;

import java.util.TreeMap;

/**
 * @ClassName LongestSubarray_1438
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-21 09:58
 * @Version 1.0
 */
public class LongestSubarray_1438 {
    public static void main(String[] args) {
        int[] nums = {1,5,6,7,8,10,6,5,6};
        System.out.println(longestSubarray(nums, 4));
    }

    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}
