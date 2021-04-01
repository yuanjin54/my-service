package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName SearchMatrix_74
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-30 15:32
 * @Version 1.0
 */
public class SearchMatrix_74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 6;
        System.out.println(binaryMatrixSearch(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        return binaryMatrixSearch(matrix, target) >= 0;
    }

    private static int binaryMatrixSearch(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;

        int left = 0;
        int right = h * w - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid / w][mid % w] == target) {
                return mid;
            } else if (matrix[mid / w][mid % w] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
