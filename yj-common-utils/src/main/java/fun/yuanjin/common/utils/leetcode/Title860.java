package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName Title860
 * @Description 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * @Author yuanjin
 * @Date 2020-12-10 23:12
 * @Version 1.0
 */
public class Title860 {
    public static void main(String[] args) {

    }

    public static boolean lemonadeChange(int[] bills) {
        int f = 0;
        int t = 0;
        for (int b : bills) {
            if (b == 5) {
                f++;
            }
            if (b == 10) {
                if (f == 0) {
                    return false;
                }
                f--;
                t++;
            }
            if (b == 20) {
                if (t > 0 && f > 0) {
                    f--;
                    t--;
                } else if (f > 2) {
                    f = f - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
