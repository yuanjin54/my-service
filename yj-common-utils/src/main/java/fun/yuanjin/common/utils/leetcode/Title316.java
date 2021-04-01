package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;

/**
 * @ClassName Title316
 * @Description 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * @Author yuanjin
 * @Date 2020-12-20 11:03
 * @Version 1.0
 */
public class Title316 {
    public static void main(String[] args) {
        int a = 'a';
        System.out.println();
        moveZeroes(new int[]{1, 0});
    }

    public String removeDuplicateLetters(String s) {
        String target = "abcdefghijklmnopqrstuvwxyz";
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                res.append(target.charAt(i));
            }
        }
        return res.toString();
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (left < nums.length && right < nums.length) {
            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            if (nums[left] != 0){
                left++;
            }
            right++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
