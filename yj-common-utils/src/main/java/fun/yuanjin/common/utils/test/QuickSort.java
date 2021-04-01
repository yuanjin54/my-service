package fun.yuanjin.common.utils.test;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-28 17:03
 * @Version 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        quickSort(0, arr.length - 1, arr);
    }

    private static void quickSort(int l, int r, int[] arr) {
        if (l >= r) {
            return;
        }
        int i = l;
        int j = r;
        int p = arr[i];
        while (i < j) {
            while (i < j && p <= arr[j]) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && p > arr[i]) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = p;
        quickSort(l, i - 1, arr);
        quickSort(i + 1, r, arr);
    }

}
