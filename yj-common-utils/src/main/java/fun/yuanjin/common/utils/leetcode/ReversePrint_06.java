package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

import java.util.Arrays;

/**
 * @ClassName ReversePrint_06
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-22 18:51
 * @Version 1.0
 */
public class ReversePrint_06 {
    public static void main(String[] args) {
        ListNode head = PrintlnUtil.createNode(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(reversePrint(head)));
    }

    public static int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] res = new int[len];
        while (head != null) {
            res[len - 1] = head.val;
            head = head.next;
            len--;
        }
        return res;
    }
}
