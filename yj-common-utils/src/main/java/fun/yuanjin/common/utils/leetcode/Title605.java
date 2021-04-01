package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;

/**
 * @ClassName Title605
 * @Description 605. 种花问题
 * https://leetcode-cn.com/problems/can-place-flowers/
 * @Author yuanjin
 * @Date 2021-01-01 18:24
 * @Version 1.0
 */
public class Title605 {
    public static void main(String[] args) {
        canPlaceFlowers(new int[]{0,0,1,0,0}, 1);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean left = i == 0 || flowerbed[i - 1] == 0;
                boolean right = i + 1 == flowerbed.length || flowerbed[i + 1] == 0;
                if (left && right) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(flowerbed));
        return count == n;
    }
}
