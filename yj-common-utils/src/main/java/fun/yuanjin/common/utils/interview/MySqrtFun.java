package fun.yuanjin.common.utils.interview;

/**
 * @ClassName MySqrtFun
 * @Description 力扣地址：https://leetcode-cn.com/problems/sqrtx/
 * 两种实现方法：牛顿迭代 + 二分
 * @Author yuanjin
 * @Date 2021-02-24 14:58
 * @Version 1.0
 */
public class MySqrtFun {
    public static void main(String[] args) {

    }

    /**
     * 遍历
     */
    public static int mySqrt2(int x) {
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
        int r = x;
        int ans = 0;
        while (l < r) {
            int m = (l + r) / 2;
            if (m <= x / m) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    /**
     * 牛顿迭代法
     */
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        double c = x;
        double x0 = x;
        while (true) {
            double x1 = 0.5 * (x0 + c / x0);
            if (x0 - x1 < 1) {
                return (int) x1;
            }
            x0 = x1;
        }
    }
}
