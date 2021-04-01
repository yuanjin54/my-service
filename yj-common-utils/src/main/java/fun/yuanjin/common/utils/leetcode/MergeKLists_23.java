package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName MergeKLists_23
 * @Description https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @Author yuanjin
 * @Date 2021-03-29 14:37
 * @Version 1.0
 */
public class MergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        while (len > 1) {
            int mid = len / 2;
            for (int i = 0; i < mid; i++) {
                lists[i] = merge2Lists(lists[i], lists[len - 1 - i]);
            }
            len = len % 2 == 0 ? mid : mid + 1;
        }
        return lists[0];
    }

    public ListNode merge2Lists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode root = new ListNode(0);
        ListNode temp = root;
        while (null != a && null != b) {
            if (a.val <= b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        temp.next = null != a ? a : b;
        return root.next;
    }
}

