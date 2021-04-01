package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Combine_77
 * @Description https://leetcode-cn.com/problems/combinations/
 * @Author yuanjin
 * @Date 2021-03-27 22:42
 * @Version 1.0
 */
public class Combine_77 {
    public static void main(String[] args) {
        Combine_77 o = new Combine_77();
        System.out.println(o.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        recursion(0, 0, n, k, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    private void recursion(int i, int level, int n, int k, List<Integer> list) {
        if (k - list.size() > n - i) {
            return;
        }
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < n; j++) {
            Integer o = j + 1;
            list.add(o);
            recursion(j + 1, level + 1, n, k, list);
            list.remove(o);
        }
    }

}
