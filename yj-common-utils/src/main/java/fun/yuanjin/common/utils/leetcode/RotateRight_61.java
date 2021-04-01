package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName RotateRight_61
 * @Description 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * @Author yuanjin
 * @Date 2021-03-27 18:31
 * @Version 1.0
 */
public class RotateRight_61 {
    public static void main(String[] args) {
        ListNode root = PrintlnUtil.createNode(new int[]{0, 1, 2});
        PrintlnUtil.printNode(rotateRight1(root, 4));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        k = len - k % len;
        ListNode left = new ListNode(-1);
        ListNode leftTemp = left;
        ListNode right = new ListNode(-1);
        ListNode rightTemp = right;
        while (head != null) {
            if (k > 0) {
                leftTemp.next = head;
                leftTemp = leftTemp.next;
            } else {
                rightTemp.next = head;
                rightTemp = rightTemp.next;
            }
            head = head.next;
            k--;
        }
        leftTemp.next = null;
        rightTemp.next = left.next;
        return right.next;
    }


    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        node.next = head;
        k = len - k % len;
        while (k > 0) {
            head = head.next;
            k--;
        }


        return head.next;


    }
}
