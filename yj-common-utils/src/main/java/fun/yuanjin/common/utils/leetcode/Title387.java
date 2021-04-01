package fun.yuanjin.common.utils.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Title387
 * @Description 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * @Author yuanjin
 * @Date 2020-12-23 23:06
 * @Version 1.0
 */
public class Title387 {
    public static void main(String[] args) {

    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
