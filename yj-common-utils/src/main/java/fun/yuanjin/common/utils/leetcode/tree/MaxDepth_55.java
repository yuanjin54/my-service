package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName MaxDepth_55
 * @Description 剑指 Offer 55 - I. 二叉树的深度
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @Author yuanjin
 * @Date 2021-03-30 19:37
 * @Version 1.0
 */
public class MaxDepth_55 {
    public static void main(String[] args) {
        MaxDepth_55 maxDepth55 = new MaxDepth_55();

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 效率比较低
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeNode last = root;
        int h = 0;
        while (deque.size() > 0) {
            TreeNode node = deque.pollFirst();
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
            if (last == node) {
                last = deque.peekLast();
                h++;
            }
        }
        return h;
    }
}
