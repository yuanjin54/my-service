package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName DeleteNode_18
 * @Description 剑指 Offer 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @Author yuanjin
 * @Date 2021-01-08 10:21
 * @Version 1.0
 */
public class DeleteNode_18 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 1, 9};
        ListNode head = PrintlnUtil.createNode(arr);
        PrintlnUtil.printNode(deleteNode(head, 5));

    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                break;
            }
            temp.next = head;
            temp = temp.next;
            head = head.next;
        }
        temp.next = head;
        return root.next;
    }
}
