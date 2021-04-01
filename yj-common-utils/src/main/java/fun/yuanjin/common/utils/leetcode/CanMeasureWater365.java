package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName CanMeasureWater365
 * @Description 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * <p>
 * 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * @Author yuanjin
 * @Date 2020-11-21 18:00
 * @Version 1.0
 */
public class CanMeasureWater365 {
    public static void main(String[] args) {
        Long id = 13162L;
        Integer d = 13162;
//        System.out.println(id == d);
    }

    /**
     * _*x + _*y + _*m + _*n = z ?
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static boolean canMeasureWater(int x, int y, int z) {
        int m = Math.max(x, y);
        int n = Math.min(x, y);
        if (n != 0) {
            n = m % n;
        }
        int[] nums = {x, y, m, n};
        for (int i = 0; i < 4; i++) {
            if (f(nums, i, z)) {
                return true;
            }
        }
        return false;
    }


    public static boolean f(int[] nums, int i, int k) {
        if (i >= nums.length) {
            return false;
        }
        if (nums[i] == 0 || nums[i] > k) {
            return f(nums, i + 1, k);
        }
        if (k % nums[i] == 0) {
            return true;
        }
        return f(nums, i + 1, k % nums[i]);
    }

}
