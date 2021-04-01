package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName FlipAndInvertImage_832
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-24 20:43
 * @Version 1.0
 */
public class FlipAndInvertImage_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int h = A.length;
        int w = A[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w / 2; j++) {
                int t = A[i][j];
                A[i][j] = A[i][w - 1 - j] == 1 ? 0 : 1;
                A[i][w - 1 - j] = t == 1 ? 0 : 1;
            }
            if (w % 2 == 1) {
                A[i][w / 2] = A[i][w / 2] == 1 ? 0 : 1;
            }
        }
        return A;
    }
}
