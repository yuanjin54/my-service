package fun.yuanjin.common.utils.leetcode;

import fun.yuanjin.common.utils.PrintlnUtil;

/**
 * @ClassName Title1669
 * @Description 1669. 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 * 下图中蓝色边和节点展示了操作后的结果：
 * <p>
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
 * @Author yuanjin
 * @Date 2020-12-09 23:05
 * @Version 1.0
 */
public class Title1669 {
    public static void main(String[] args) {
        ListNode list1 = PrintlnUtil.createNode(new int[]{0, 1, 2, 3, 4, 5});
        ListNode list2 = PrintlnUtil.createNode(new int[]{1000000, 1000001, 1000002});
        PrintlnUtil.printNode(mergeInBetween(list1, 1, 5, list2));
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode rootCP = root;
        while (b > 0) {
            if (a > 0) {
                rootCP.next = list1;
                rootCP = rootCP.next;
            }
            list1 = list1.next;
            a--;
            b--;
        }
        ListNode nodeB = list1.next;
        System.out.println("rootCP");
        PrintlnUtil.printNode(rootCP);
        System.out.println("nodeB");
        PrintlnUtil.printNode(nodeB);
        while (list2 != null) {
            rootCP.next = list2;
            rootCP = rootCP.next;
            list2 = list2.next;
        }

        while (nodeB != null) {
            rootCP.next = nodeB;
            rootCP = rootCP.next;
            nodeB = nodeB.next;
        }
        return root.next;
    }
}
