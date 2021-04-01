package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName GetIntersectionNode_52
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-22 18:17
 * @Version 1.0
 */
public class GetIntersectionNode_52 {
    public static void main(String[] args) {
        ListNode mid = PrintlnUtil.createNode(new int[]{3, 2, 1});
        ListNode headA = PrintlnUtil.createNode(new int[]{6, 5});
        headA.next = mid;
        ListNode headB = PrintlnUtil.createNode(new int[]{9, 8, 7});
        headB.next = mid;

        PrintlnUtil.printNode(getIntersectionNode(headA, mid));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }

}
