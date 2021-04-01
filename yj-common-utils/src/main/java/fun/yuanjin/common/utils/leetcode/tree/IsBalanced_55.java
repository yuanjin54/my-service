package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;

/**
 * @ClassName IsBalanced_55
 * @Description 剑指 Offer 55 - II. 平衡二叉树
 * 判断是不是平衡二叉树: 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @Author yuanjin
 * @Date 2021-03-30 19:44
 * @Version 1.0
 */
public class IsBalanced_55 {
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
