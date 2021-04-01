package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName RemoveStones_947
 * @Description 947. 移除最多的同行或同列石头
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 * @Author yuanjin
 * @Date 2021-01-15 10:33
 * @Version 1.0
 */
public class RemoveStones_947 {

    public static void main(String[] args) {
        int[][] stones = {{0, 1}, {1, 0}, {1, 1}};
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        int count = 0;
        int[] x = new int[stones.length];
        int[] y = new int[stones.length];
        for (int[] stone : stones) {
            int dx = stone[0];
            int dy = stone[1];
            if (x[dx] == 0 && y[dy] == 0) {
                x[dx] = 1;
                y[dy] = 1;
                continue;
            }
            x[dx] = 1;
            y[dy] = 1;
            count++;
        }
        return count;
    }
}
