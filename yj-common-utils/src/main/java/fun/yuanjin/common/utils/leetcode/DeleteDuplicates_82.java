package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName DeleteDuplicates_82
 * @Description 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @Author yuanjin
 * @Date 2021-03-25 09:59
 * @Version 1.0
 */
public class DeleteDuplicates_82 {
    public static void main(String[] args) {
        ListNode listNode = PrintlnUtil.createNode(new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5});
        PrintlnUtil.printNode(deleteDuplicates1(listNode));
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode node = root;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null) {
            while (p2 != null && p1.val == p2.val) {
                p2 = p2.next;
            }
            node.next = p1;
            p1.next = null;
            node = node.next;
            p1 = p2;
        }
        return root.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode node = root;
        ListNode p1 = head;
        ListNode p2 = head;
        boolean flag = true;
        while (p2 != null) {
            while (p2 != null && p1.val == p2.val) {
                flag = false;
                p2 = p2.next;
            }
            if (flag) {
                node.next = p1;
                p1.next = null;
                node = node.next;
            }
            p1 = p2;
            flag = true;
        }
        return root.next;
    }
}
