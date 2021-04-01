package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName ReverseBetween_92
 * @Description 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @Author yuanjin
 * @Date 2021-03-18 21:51
 * @Version 1.0
 */
public class ReverseBetween_92 {
    public static void main(String[] args) {
        ListNode root = PrintlnUtil.createNode(new int[]{1});
        PrintlnUtil.printNode(root);
        ListNode res = reverse(root);
//        ListNode res = reverseBetween(root, 2, 4);
        PrintlnUtil.printNode(res);
    }

    public static ListNode reverse(ListNode node) {
        ListNode res = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = res;
            res = node;
            node = next;
        }
        return res;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int index = 1;
        ListNode root = new ListNode(-1);
        ListNode node = root;
        ListNode leftNode;
        ListNode rightNode;
        while (index < left) {
            node.next = head;
            node = node.next;
            head = head.next;
            index++;
        }
        leftNode = head;
        head = head.next;
        index++;
        rightNode = leftNode;
        while (index <= right) {
            ListNode temp = new ListNode(head.val);
            temp.next = rightNode;
            rightNode = temp;
            head = head.next;
            index++;
        }
        while (head != null) {
            leftNode.next = head;
            leftNode = leftNode.next;
            head = head.next;
        }
        node.next = rightNode;
        leftNode.next = null;
        return root.next;
    }
}
