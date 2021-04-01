package fun.yuanjin.common.utils.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @ClassName MySqrt
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-02 19:14
 * @Version 1.0
 */
public class MySqrt {
    public static void main(String[] args) {
        double p = 8;
        System.out.println(get(p));
        System.out.println(getData(p));
    }

    public static double get(double n) {
        if (n < 0) {
            return -1;
        }
        double l = 0;
        double r = n;
        while (l < r) {
            double m = (l + r) / 2;
            if (m * m > n) {
                r = m - 0.01;
            } else {
                l = m + 0.01;
            }
        }
        DecimalFormat format = new DecimalFormat("######0.00");
        format.setRoundingMode(RoundingMode.FLOOR);
        return Double.parseDouble(format.format(l));
    }

    /**
     * 牛顿迭代法
     */
    public static double getData(double n) {
        if (n < 0) {
            return -1;
        }
        double x0 = n;
        DecimalFormat format = new DecimalFormat("######0.00");
        format.setRoundingMode(RoundingMode.FLOOR);
        while (true) {
            double x1 = 0.5 * (x0 + n / x0);
            if (Math.abs(x1 * x1 - n) <= 0.01) {
                return Double.parseDouble(format.format(x1));
            }
            x0 = x1;
        }
    }
}
