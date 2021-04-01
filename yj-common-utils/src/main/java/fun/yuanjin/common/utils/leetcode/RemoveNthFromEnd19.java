package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName RemoveNthFromEnd19
 * @Description 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * @Author yuanjin
 * @Date 2020-11-26 22:55
 * @Version 1.0
 */
public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = PrintlnUtil.createNode(arr);
        PrintlnUtil.printNode(head);
        ListNode result = removeNthFromEnd(head, 0);
        PrintlnUtil.printNode(result);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n > 0) {
            n--;
            fast = fast.next;
        }
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (null != fast) {
            fast = fast.next;
            node.next = head;
            node = node.next;
            head = head.next;
        }
        if (head == null){
            node.next = null;
            return result.next;
        }
        head = head.next;
        while (head != null){
            node.next = head;
            node = node.next;
            head = head.next;
        }
        node.next = null;
        return result.next;
    }
}
