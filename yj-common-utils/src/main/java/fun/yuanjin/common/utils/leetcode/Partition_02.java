package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName Partition_02
 * @Description https://leetcode-cn.com/problems/partition-list-lcci/
 * @Author yuanjin
 * @Date 2021-03-29 14:21
 * @Version 1.0
 */
public class Partition_02 {
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = new ListNode(-1);
        ListNode p1Next = p1;
        ListNode p2 = new ListNode(-1);
        ListNode p2Next = p2;
        while (head != null) {
            if (head.val < x) {
                p1Next.next = head;
                p1Next = p1Next.next;
            } else {
                p2Next.next = head;
                p2Next = p2Next.next;
            }
            head = head.next;
        }
        p2Next.next = null;
        p1Next.next = p2.next;
        return p1.next;
    }
}
