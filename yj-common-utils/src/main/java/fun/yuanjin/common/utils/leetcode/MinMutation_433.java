package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Min
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-14 20:12
 * @Version 1.0
 */
public class MinMutation_433 {

    public static void main(String[] args) {
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        MinMutation_433 m = new MinMutation_433();
        System.out.println(m.minMutation(start, end, bank));
    }

    List<String> res = new ArrayList<>();

    public int minMutation(String start, String end, String[] bank) {
        recur(start, end, new ArrayList<>(), bank);
        return res.size() > 0 ? res.size() : -1;
    }


    public void recur(String str, String end, List<String> item, String[] bank) {
        if (item.contains(end)) {
            res = new ArrayList<>(item);
            return;
        }
        for (String ele : bank) {
            if (isSame(str, ele) && !item.contains(ele)) {
                item.add(ele);
                recur(ele, end, item, bank);
                item.remove(ele);
            }
        }
    }

    private boolean isSame(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int c = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (c > 1) {
                return false;
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                c++;
            }
        }
        return c == 1;
    }
}
