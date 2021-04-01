package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Title290
 * @Description 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * @Author yuanjin
 * @Date 2020-12-16 22:11
 * @Version 1.0
 */
public class Title290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        String[] ss = new String[26];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            int idx = pattern.charAt(i) - 'a';
            if (ss[idx] == null ) {
                if (!list.contains(arr[i])) {
                    list.add(arr[i]);
                    ss[idx] = arr[i];
                }else {
                    return false;
                }
            } else if (!ss[idx].equals(arr[i])) {
                return false;
            }
        }
        return true;
    }
}
