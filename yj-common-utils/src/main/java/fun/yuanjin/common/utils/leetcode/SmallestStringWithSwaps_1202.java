package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SmallestStringWithSwaps_1202
 * @Description 1202. 交换字符串中的元素
 * https://leetcode-cn.com/problems/smallest-string-with-swaps/
 * @Author yuanjin
 * @Date 2021-01-11 22:33
 * @Version 1.0
 */
public class SmallestStringWithSwaps_1202 {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        lists.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        lists.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(2);
        lists.add(list3);
        System.out.println(smallestStringWithSwaps(s, lists));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        for (List<Integer> pair : pairs) {
            s = getStr(s, pair);
        }
        return s;
    }

    private static String getStr(String s, List<Integer> list) {
        return s.substring(0, list.get(0)) + s.charAt(list.get(1)) +
                s.substring(list.get(0) + 1, list.get(1)) + s.charAt(list.get(0)) +
                s.substring(list.get(1) + 1);
    }

}
