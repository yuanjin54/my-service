package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName FindCircleNum_547
 * @Description 547. 省份数量
 * https://leetcode-cn.com/problems/number-of-provinces/
 * @Author yuanjin
 * @Date 2021-01-07 14:58
 * @Version 1.0
 */
public class FindCircleNum_547 {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(findCircleNum(isConnected));

    }

    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    count++;
                    findCircle(i, j, isConnected);
                }
            }
        }
        return count;
    }

    private static void findCircle(int i, int j, int[][] isConnected) {
        if (isConnected[i][j] == 0) {
            return;
        }
        isConnected[i][j] = 0;
        for (int k = 0; k < isConnected.length; k++) {
            if (isConnected[j][k] == 1) {
                findCircle(j, k, isConnected);
            }
        }
    }
}
