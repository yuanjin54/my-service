package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName t
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-25 21:14
 * @Version 1.0
 */
public class Transpose {

    public int[][] transpose(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] res = new int[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
