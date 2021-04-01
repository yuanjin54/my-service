package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName Title5
 * @Description 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * @Author yuanjin
 * @Date 2020-12-09 11:37
 * @Version 1.0
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaa"));
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int[][] f = new int[s.length()][s.length()];
        String res = "";
        int k = 0;
        while (k < s.length()) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + k;
                if (j == s.length()) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || i == j - 1 || f[i + 1][j - 1] == 1) {
                        f[i][j] = 1;
                        String substring = s.substring(i, j + 1);
                        if (substring.length() > res.length()) {
                            res = substring;
                        }
                        PrintlnUtil.print2Array(f);
                    }
                }
            }
            k++;
        }
        return res;
    }
}
