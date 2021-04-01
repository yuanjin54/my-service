package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName OddEvenList_328
 * @Description https://leetcode-cn.com/problems/odd-even-linked-list/
 * @Author yuanjin
 * @Date 2021-03-29 14:27
 * @Version 1.0
 */
public class OddEvenList_328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode p1 = new ListNode(-1); // 奇
        ListNode p1Next = p1;
        ListNode p2 = new ListNode(-1); // 偶
        ListNode p2Next = p2;
        int k = 1;
        while (head != null) {
            if (k % 2 == 1) {
                p1Next.next = head;
                p1Next = p1Next.next;
            } else {
                p2Next.next = head;
                p2Next = p2Next.next;
            }
            head = head.next;
            k++;
        }
        p2Next.next = null;
        p1Next.next = p2.next;
        return p1.next;
    }
}
