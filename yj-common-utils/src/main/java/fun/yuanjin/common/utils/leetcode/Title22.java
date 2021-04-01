package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Title22
 * @Description 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @Author yuanjin
 * @Date 2020-12-26 20:08
 * @Version 1.0
 */
public class Title22 {

    public static void main(String[] args) {
        Title22 t = new Title22();
        t.recursion2(0, 0, 3, "");
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion3(0, 0, n, "", res);
        return res;
    }

    public void recursion(int level, int param) {
        // 1、递归终止条件
        // 2、递归体
        // 3、下探到下一层
        // 4、恢复当前层(一般不需要)
    }

    /**
     * 类似穷举所有的情况
     *
     * @param level 当前层
     * @param n     总的层数
     * @param s     结果
     */
    public void recursion1(int level, int n, String s) {
        // 1、递归终止条件
        if (level >= n) {
            System.out.println(s);
            return;
        }
        // 2、递归体
        // 3、下探到下一层
        recursion1(level + 1, n, s + "("); //添加左括号
        recursion1(level + 1, n, s + ")"); //添加右括号
        // 4、恢复当前层(一般不需要)
    }

    /**
     * 优化了 recursion1，提前去除无效的情况
     *
     * @param left  左括号的数量
     * @param right 右括号的数量
     * @param max   最大数量
     * @param s     当前值
     */
    public void recursion2(int left, int right, int max, String s) {
        // 1、递归终止条件
        if (left == max && right == max) {
            System.out.println(s);
            return;
        }
        // 2、递归体
        // 3、下探到下一层
        if (left < max) {
            //添加左括号
            recursion2(left + 1, right, max, s + "(");
        }

        if (right < left) {
            //添加右括号
            recursion2(left, right + 1, max, s + ")");
        }
        // 4、恢复当前层(一般不需要)
    }

    public void recursion3(int left, int right, int max, String s, List<String> res) {
        // 1、递归终止条件
        if (left == max && right == max) {
            res.add(s);
            return;
        }
        // 2、递归体
        // 3、下探到下一层
        if (left < max) {
            //添加左括号
            recursion3(left + 1, right, max, s + "(", res);
        }

        if (right < left) {
            //添加右括号
            recursion3(left, right + 1, max, s + ")", res);
        }
        // 4、恢复当前层(一般不需要)
    }
}
