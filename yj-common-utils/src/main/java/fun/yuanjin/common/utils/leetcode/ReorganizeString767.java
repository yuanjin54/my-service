package fun.yuanjin.common.utils.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ReorganizeString767
 * @Description 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * @Author yuanjin
 * @Date 2020-11-30 21:30
 * @Version 1.0
 */
public class ReorganizeString767 {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }

    public static String reorganizeString(String S) {
        int[] nums = new int[26];
        int max = 0;
        // 统计字符次数
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            nums[index]++;
            max = Math.max(max, nums[index]);
        }
        if (max > (S.length() + 1) >> 2) {
            return "";
        }
        // 找出最大的字符
        int idx = 0;
        for (int i = 1; i < 26; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }



        return null;
    }
}
