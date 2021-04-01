package fun.yuanjin.common.utils.thread;

import fun.yuanjin.common.utils.leetcode.ListNode;
import org.openjdk.jol.info.ClassLayout;

import java.util.Arrays;

/**
 * @ClassName TestI
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-13 15:25
 * @Version 1.0
 */
public class TestI {
    private static int k = 0;

    public static void main(String[] args) throws InterruptedException {
        TestI testI = new TestI();
        int[] nums = {6, 2, 6, 5, 7, 4, 1, 2};
        System.out.println();
    }

    private void test1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (TestI.class) {
                        k++;
                    }
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(k);
    }

    private void test2() {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i].trim().length() == 0) {
                i++;
            } else if (arr[j].trim().length() == 0) {
                j--;
            } else {
                left.append(arr[j]).append(" ");
                right.insert(0, " " + arr[i]);
                j--;
                i++;
            }
        }
        return left + right.toString();
    }

    public int arrayPairSum(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            max += nums[i];
        }
        return max;
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        while (k > 0) {
            temp = temp.next;
            k--;
        }
        while (temp != null) {
            temp = temp.next;
            head = head.next;
        }
        return head;
    }

    public int[] printNumbers(int n) {
        int len = 1;
        while (n > 0) {
            len *= 10;
            n--;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
