package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName Title64
 * @Description 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * 限制：1 <= n <= 10000
 * <p>
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * @Author yuanjin
 * @Date 2020-12-09 20:07
 * @Version 1.0
 */
public class Title64 {
    public static void main(String[] args) {

    }

    public static int sumNums(int n) {
        boolean x = n > 0 && sumNums(n - 1) > 0;
        return n + sumNums(n - 1);
    }
}
