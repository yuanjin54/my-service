package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;

/**
 * @ClassName SortString1370
 * @Description 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * @Author yuanjin
 * @Date 2020-11-25 23:20
 * @Version 1.0
 */
public class SortString1370 {
    public static void main(String[] args) {
        int[] nums1 = {4};
        int[] nums2 = {1, 2, 3};



        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = len % 2 == 1 ? len / 2 : (len / 2 - 1);
        int p = 0;
        int q = 0;
        while (k > 0) {
            k--;
            if (p == nums1.length) {
                q++;
            } else if (q == nums2.length) {
                p++;
            } else {
                if (nums1[p] < nums2[q]) {
                    p++;
                } else {
                    q++;
                }
            }
        }
        System.out.println(p + "  " + q);
        if (len % 2 == 1) {
            if (p == nums1.length) {
                return nums2[q];
            }
            if (q == nums2.length) {
                return nums1[p];
            }
            return Math.min(nums1[p], nums2[q]);
        }
        if (p == nums1.length) {
            return (nums2[q] + nums2[q + 1]) / 2.0;
        }
        if (q == nums2.length) {
            return (nums1[p] + nums1[p + 1]) / 2.0;
        }
        if (p + 1 < nums1.length && nums1[p + 1] < nums2[q]) {
            return (nums1[p] + nums1[p + 1]) / 2.0;
        }
        if (q + 1 < nums2.length && nums2[q + 1] < nums1[p]) {
            return (nums2[q] + nums2[q + 1]) / 2.0;
        }
        return (nums1[p] + nums2[q]) / 2.0;
    }


    public static String sortString(String s) {
        StringBuilder result = new StringBuilder();
        int len = s.length();
        int[] arr = new int[26];
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        while (result.length() < len) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    char c = (char) (i + 'a');
                    result.append(c);
                    arr[i] -= 1;
                }
            }
            for (int i = 0; i < 26; i++) {

                if (arr[25 - i] > 0) {
                    char c = (char) (25 - i + 'a');
                    result.append(c);
                    arr[25 - i] -= 1;
                }
            }
        }
        return result.toString();
    }
}
