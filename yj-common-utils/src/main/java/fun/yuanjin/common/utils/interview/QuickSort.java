package fun.yuanjin.common.utils.interview;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 快排
 * @Author yuanjin
 * @Date 2021-02-23 23:05
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {21, 25, 2, 14, 3, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int left, int right, int[] arr) {
        // 递归终止条件
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int p = arr[left];
        while (i < j) {
            while (i < j && p <= arr[j]) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[i] < p) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = p;
        quickSort(left, i - 1, arr);
        quickSort(i + 1, right, arr);
    }

    private static void sort(int[] arr) {
        quickSort(0, arr.length - 1, arr);
    }
}
