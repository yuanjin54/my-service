package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName TreeNodePrint
 * @Description 二叉树前、中、后序遍历，层次遍历
 * @Author yuanjin
 * @Date 2021-01-13 10:30
 * @Version 1.0
 */
public class TreeNodePrint {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        behind(root);
    }

    /**
     * 前序：根左右
     */
    public static void order(TreeNode root) {
        if (null == root) return;
        System.out.println(root.val);
        order(root.left);
        order(root.right);
    }

    /**
     * 中序：左根右
     */
    public static void mid(TreeNode root) {
        if (null == root) return;
        mid(root.left);
        System.out.println(root.val);
        mid(root.right);
    }

    /**
     * 后序：左右根
     */
    public static void behind(TreeNode root) {
        if (null == root) return;
        behind(root.left);
        behind(root.right);
        System.out.println(root.val);
    }


    /**
     * 层次
     */
    public static void level(TreeNode root) {
        if (null == root) return;
        List<Integer> item = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeNode last = root;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            item.add(node.val);
            if (node.left != null) deque.addLast(node.left);
            if (node.right != null) deque.addLast(node.right);
            if (node == last) {
                System.out.println(item);
                item = new ArrayList<>();
                if (!deque.isEmpty()) last = deque.getLast();
            }
        }
    }
}
