package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralOrder_2
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-15 10:38
 * @Version 1.0
 */
public class SpiralOrder_54 {

    public static void main(String[] args) {
        // [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix = {{1},{2},{3}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        if (matrix[0].length == 1) {
            for (int[] ints : matrix) {
                list.add(ints[0]);
            }
            return list;
        }
        while (left <= right && top <= down) {
            if (left == right && right == top && right == down) {
                list.add(matrix[left][right]);
            }
            for (int i = left; i < right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top; i < down; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                list.add(matrix[down][i]);
            }
            for (int i = down; i > top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            down--;
        }
        return list;
    }

}
