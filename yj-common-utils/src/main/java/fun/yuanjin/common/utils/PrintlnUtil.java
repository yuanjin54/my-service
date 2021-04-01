package fun.yuanjin.common.utils;

import fun.yuanjin.common.utils.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListNodeUtil
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-14 23:35
 * @Version 1.0
 */
public class PrintlnUtil {

    /**
     * 创建节点list
     *
     * @param values values
     * @return list
     */
    public static ListNode[] createNodeList(int[][] values) {
        ListNode[] lists = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            lists[i] = createNode(values[i]);
        }
        return lists;
    }

    /**
     * 创建node
     *
     * @param values values
     * @return node
     */
    public static ListNode createNode(int[] values) {
        ListNode root = new ListNode(0);
        ListNode temp = root;
        for (int value : values) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        return root.next;
    }

    /**
     * 打印节点list
     *
     * @param lists lists
     */
    public static void printNodeList(ListNode[] lists) {
        StringBuilder res = new StringBuilder();
        for (ListNode list : lists) {
            res.append(nodeToList(list).toString());
        }
        System.out.println(res.toString());
    }

    /**
     * 打印node
     *
     * @param node node
     * @return list
     */
    public static void printNode(ListNode node) {
        List<Object> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(list);
    }

    /**
     * 打印node
     *
     * @param node node
     * @return list
     */
    public static List<Object> nodeToList(ListNode node) {
        List<Object> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }


    public static <T> void print1Array(T[] arr) {
        for (T o : arr) {
            System.out.print(o.toString() + ",");
        }
        System.out.println();
    }

    public static <T> void print2Array(int[][] arr) {
        for (int[] o : arr) {
            for (int t : o) {
                System.out.print(t + ",");
            }
            System.out.println();
        }
    }
}
