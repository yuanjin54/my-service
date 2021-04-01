package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName SwapNodes_1721
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-29 15:03
 * @Version 1.0
 */
public class SwapNodes_1721 {
    public static void main(String[] args) {
        ListNode head = PrintlnUtil.createNode(new int[]{1, 2, 3, 4, 5, 6});
        PrintlnUtil.printNode(swapNodes(head, 6));
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode first = new ListNode(-1);
        ListNode firstNext = first;
        ListNode mid = new ListNode(-1);
        ListNode midNext = mid;
        ListNode end = new ListNode(-1);
        Integer left = null;
        Integer right = null;
        int len = 0;
        ListNode pp = head;
        while (pp != null) {
            pp = pp.next;
            len++;
        }
        if (len - k + 1 == k) {
            return head;
        }
        k = Math.min(k, len - k + 1);
        int kk = k;
        ListNode quick = head;
        while (kk > 0) {
            quick = quick.next;
            kk--;
        }
        kk = k;
        while (quick != null) {
            if (kk > 1) {
                firstNext.next = head;
                firstNext = firstNext.next;
            } else if (kk == 1) {
                left = head.val;
            } else {
                midNext.next = head;
                midNext = midNext.next;
            }
            head = head.next;
            quick = quick.next;
            kk--;
        }
        if (head != null) {
            right = head.val;
            end.next = head.next;
        }
        if (right != null && left != null) {
            firstNext.next = new ListNode(right);
            firstNext = firstNext.next;
            if (mid.next != null) {
                firstNext.next = mid.next;
                midNext.next = new ListNode(left);
                midNext = midNext.next;
                midNext.next = end.next;
            } else {
                firstNext.next = new ListNode(left);
                firstNext.next.next = end.next;
            }

        }
        return first.next;
    }


    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }
        return result;
    }

}
