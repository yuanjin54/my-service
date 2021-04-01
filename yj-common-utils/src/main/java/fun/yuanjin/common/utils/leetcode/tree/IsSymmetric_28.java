package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;

/**
 * @ClassName IsSymmetric_28
 * @Description 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @Author yuanjin
 * @Date 2021-04-01 10:23
 * @Version 1.0
 */
public class IsSymmetric_28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 左节点的左与右节点的右相等，且左节点的右与右节点的左相等
        return recur(left.left, right.right) && recur(right.left, left.right);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}










