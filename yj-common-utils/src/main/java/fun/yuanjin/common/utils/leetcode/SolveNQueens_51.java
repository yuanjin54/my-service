package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SolveNQueens_51
 * @Description 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 * @Author yuanjin
 * @Date 2021-01-09 22:24
 * @Version 1.0
 */
public class SolveNQueens_51 {
    static List<Integer> yList = new ArrayList<>();
    static List<Integer> xDyList = new ArrayList<>();
    static List<Integer> xAyList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solveNQueens(10));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> item = new ArrayList<>();
        dfs(0, n, res, item);
        return res;
    }

    private static void dfs(int i, int n, List<List<String>> res, List<String> item) {
        if (i == n) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(i, j)) {
                String s = getItem(j, n);
                item.add(s);
                add(i, j);
                dfs(i + 1, n, res, item);
                item.remove(s);
                remove(i, j);
            }
        }
    }

    private static String getItem(int index, int size) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == index) {
                s.append("Q");
            } else {
                s.append(".");
            }
        }
        return s.toString();
    }

    private static void remove(Integer x, Integer y) {
        yList.remove(y);
        xAyList.remove((Integer) (x + y));
        xDyList.remove((Integer) (x - y));
    }

    private static boolean isValid(int x, int y) {
        return !yList.contains(y) && !xDyList.contains(x - y) && !xAyList.contains(x + y);
    }

    private static void add(int x, int y) {
        yList.add(y);
        xAyList.add(x + y);
        xDyList.add(x - y);
    }
}
