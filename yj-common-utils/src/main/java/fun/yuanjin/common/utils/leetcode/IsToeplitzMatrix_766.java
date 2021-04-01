package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName IsToeplitzMatrix_766
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-22 23:45
 * @Version 1.0
 */
public class IsToeplitzMatrix_766 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        boolean s = isToeplitzMatrix(matrix);
        System.out.println(s);
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        final int a =10;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
