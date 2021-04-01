package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName MergeKList
 * @Description 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * @Author yuanjin
 * @Date 2020-11-14 12:37
 * @Version 1.0
 */
public class MergeKList23 {

    public static void main(String[] args) {
        int[][] values = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] nodes = PrintlnUtil.createNodeList(values);
//        printNodeList(nodes);
        ListNode lists = mergeKLists1(nodes);
        System.out.println(PrintlnUtil.nodeToList(lists));
    }

    /**
     * 方法二：
     * 通过两两进行merge
     *
     * @param lists lists
     * @return node
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        ListNode result = null;
        for (ListNode list : lists) {
            result = merge2Lists(result, list);
        }
        return result;
    }

    /**
     * 方法三：
     * 通过两两进行merge
     * 在方法二的基础上做了优化，减少了对遍历次数
     *
     * @param lists lists
     * @return node
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
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

    /**
     * 对a与b进行merge
     *
     * @param a a
     * @param b b
     * @return node
     */
    public static ListNode merge2Lists(ListNode a, ListNode b) {
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

    /**
     * 方法一：
     * 直接取出每个node的最小值进行比较，然后比较出的节点往后移动
     *
     * @param lists lists
     * @return node
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode temp = root;
        boolean f = true;
        while (f) {
            f = false;
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < lists.length; i++) {
                if (null != lists[i]) {
                    if (min >= lists[i].val) {
                        idx = i;
                        min = lists[i].val;
                    }
                    f = true;
                }
            }
            if (f) {
                temp.next = lists[idx];
                temp = temp.next;
                lists[idx] = lists[idx].next;
            }
        }
        return root.next;
    }
}
