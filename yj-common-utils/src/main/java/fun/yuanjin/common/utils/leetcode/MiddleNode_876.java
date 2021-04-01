package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName MiddleNode_876
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-29 20:54
 * @Version 1.0
 */
public class MiddleNode_876 {
    public static void main(String[] args) {
        ListNode head = PrintlnUtil.createNode(new int[]{1,2});
        PrintlnUtil.printNode(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
