package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName MySql_69
 * @Description https://leetcode-cn.com/problems/sqrtx/
 * 69. x 的平方根
 * @Author yuanjin
 * @Date 2021-02-23 22:15
 * @Version 1.0
 */
public class MySql_69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(19));
    }

    /**
     * 牛顿迭代法
     */
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        for (int i = 0; i <= x; i++) {
            if (i * i - x > 0) {
                return i - 1;
            }
        }
        return 0;
    }

    /**
     * 二分查找法
     */
    public static int mySqrt1(int x) {
        if (x < 2) {
            return x;
        }
        int l = 0;
        int r = x / 2 + 1;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }
}
