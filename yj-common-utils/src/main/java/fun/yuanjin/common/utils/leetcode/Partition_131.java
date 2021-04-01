package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Partition_131
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-07 08:53
 * @Version 1.0
 */
public class Partition_131 {

    public static void main(String[] args) {
        Partition_131 p = new Partition_131();
        System.out.println(p.partition("aabaa"));
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        convert(0, s, new ArrayList<>());
        return res;
    }

    private void convert(int idx, String s, List<String> list) {
        if (idx == s.length()) {
            res.add(list);
            return;
        }
        for (int i = idx + 1; i < s.length() + 1; i++) {
            String item = s.substring(idx, i);
            if (isHuiWen(item)) {
                List<String> k = new ArrayList<>(list);
                k.add(item);
                convert(i, s, k);
            }
        }
    }

    private boolean isHuiWen(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
