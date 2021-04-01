package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName MergeTwoLists_25
 * @Description 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @Author yuanjin
 * @Date 2021-03-22 19:17
 * @Version 1.0
 */
public class MergeTwoLists_25 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode node = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 != null ? l1 : l2;
        return root.next;
    }
}
