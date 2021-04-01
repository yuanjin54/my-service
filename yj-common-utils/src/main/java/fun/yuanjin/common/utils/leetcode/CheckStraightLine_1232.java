package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName CheckStraightLine_1232
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-17 22:50
 * @Version 1.0
 */
public class CheckStraightLine_1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3) {
            return true;
        }
        int a = coordinates[0][0] - coordinates[1][0];
        int b = coordinates[0][1] - coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int aa = coordinates[i - 1][0] - coordinates[i][0];
            int bb = coordinates[i - 1][1] - coordinates[i][1];
            if (a * bb != b * aa) {
                return false;
            }
        }
        return true;
    }
}
