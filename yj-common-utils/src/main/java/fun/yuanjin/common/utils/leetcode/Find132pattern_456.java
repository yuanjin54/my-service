package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName Find132pattern_456
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-24 19:42
 * @Version 1.0
 */
public class Find132pattern_456 {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1,4,0,-1,-2,-3,-1,-2}));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int a = nums[0];
        int b = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int c = nums[i];
            if (fix(a, b, c)) {
                return true;
            }
            a = Math.min(a, b);
            b = Math.max(b, c);
        }
        return false;
    }

    private static boolean fix(int a, int b, int c) {
        return a < c && c < b;
    }
}
