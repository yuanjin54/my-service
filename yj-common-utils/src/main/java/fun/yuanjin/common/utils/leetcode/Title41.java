package fun.yuanjin.common.utils.leetcode;

import java.util.*;

/**
 * @ClassName Title41
 * @Description 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * @Author yuanjin
 * @Date 2020-12-08 22:38
 * @Version 1.0
 */
public class Title41 {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int i = 1;
        boolean f = true;
        while (f) {
            for (int num : nums) {
                if (num == i) {
                    f = true;
                    i++;
                    break;
                }
            }
        }
        return i;
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums1) {
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else {
                map.put(i, 1);
            }
        }
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0){
                res.add(j);
                map.put(j, map.get(j)-1);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            arr[i] = re;
            i++;
        }
        return arr;
    }
}
