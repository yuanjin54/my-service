package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName Title85
 * @Description 85. 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 * @Author yuanjin
 * @Date 2020-12-26 19:00
 * @Version 1.0
 */
public class Title85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));

    }

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] points = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (points[i][j] == 0 && matrix[i][j] == '1') {
                    int res = getMax(i, j, points, matrix, 0);
                    max = Math.max(max, res);
                }
            }
        }
        return 0;
    }

    private static int getMax(int i, int j, int[][] points, char[][] matrix, int res) {
        // 终止条件
        if (points[i][j] == 1) {
            return res;
        }
        // 当前层逻辑
        points[i][j] = 1;
        res++;
        int max = res;
        // 下探到下一层
        int[][] directs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int k = 0; k < 4; k++) {
            int x = i + directs[k][0];
            int y = j + directs[k][1];
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length &&
                    points[x][y] == 0 && matrix[x][y] == '1') {
                max = Math.max(getMax(x, y, points, matrix, res), max);
            }
        }
        return max;
    }
}
