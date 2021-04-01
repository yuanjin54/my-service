package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Title0804
 * @Description 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * @Author yuanjin
 * @Date 2020-12-09 22:54
 * @Version 1.0
 */
public class Title0804 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.toString());
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        String res = "";
        String ss = "";
        for (int j = 0; j < s.length(); j++) {
            String e = String.valueOf(s.charAt(j));
            if (!ss.contains(e)) {
                ss += e;
            } else {
                if (res.length() < ss.length()) {
                    res = ss;
                }
                int i1 = ss.indexOf(s.charAt(j));
                ss = ss.substring(i1 + 1) + e;
            }
        }
        return res.length();
    }

    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        Set<Character> list = new HashSet<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (!list.contains(s.charAt(j))) {
                list.add(s.charAt(j));
            } else {
                res = Math.max(res, j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    list.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
        }
        res = Math.max(res, s.length() - i);
        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int e : nums) {
            List<List<Integer>> cp = new ArrayList<>(result);
            for (List<Integer> item : cp) {
                List<Integer> list = new ArrayList<>(item);
                list.add(e);
                result.add(list);
            }
        }
        return result;
    }
}
