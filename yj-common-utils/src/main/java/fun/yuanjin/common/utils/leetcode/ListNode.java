package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-14 12:32
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
