package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName Partition_86
 * @Description 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * @Author yuanjin
 * @Date 2021-01-07 22:33
 * @Version 1.0
 */
public class Partition_86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        PrintlnUtil.printNode(head);
        PrintlnUtil.printNode(partition(head, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode leftNode = left;
        ListNode right = new ListNode(0);
        ListNode rightNode = right;
        while (head != null) {
            if (head.val < x) {
                leftNode.next = head;
                leftNode = leftNode.next;
            } else {
                rightNode.next = head;
                rightNode = rightNode.next;
            }
            head = head.next;
        }
        rightNode.next = null;
        if (right.next != null) {
            leftNode.next = right.next;
        }
        return left.next;
    }
}
