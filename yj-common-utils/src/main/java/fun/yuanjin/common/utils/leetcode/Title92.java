package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName Title
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-12-26 21:27
 * @Version 1.0
 */
public class Title92 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = PrintlnUtil.createNode(arr);
        ListNode res = reverseBetween(head, 1, 5);
        PrintlnUtil.printNode(res);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(-1);
        ListNode node1 = res;
        ListNode node2 = null;
        ListNode node3 = null;
        while (null != head) {
            if (m > 1) {
                node1.next = head;
                node1 = node1.next;
            }
            if (m == 1) {
                node2 = head;
                node3 = node2;
            }
            if (n >= 1 && m < 1) {
                ListNode temp = new ListNode(head.val);
                temp.next = node3;
                node3 = temp;
            }
            if (n < 1 && m < 1) {
                break;
            }
            PrintlnUtil.printNode(res);
            head = head.next;
            m--;
            n--;
        }
        node1.next = node3;
        node2.next = head;
        return res.next;
    }
}
