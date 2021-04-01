package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName Title42
 * @Description 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @Author yuanjin
 * @Date 2020-12-20 21:03
 * @Version 1.0
 */
public class Title42 {
    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                int k = l + 1;
                while (k<r && height[k]>height[l]){
                    k++;
                }
            }


        }
return 1;
    }
}
