package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName MaxDepth_55
 * @Description 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @Author yuanjin
 * @Date 2021-01-09 10:27
 * @Version 1.0
 */
public class MaxDepth_55 {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depth(root, 0);
    }

    private static int depth(TreeNode root, int c) {
        if (root.left == null && root.right == null) {
            return c;
        }
        if (root.left == null) {
            return depth(root.right, c + 1);
        }
        if (root.right == null) {
            return depth(root.left, c + 1);
        }
        return Math.min(depth(root.left, c + 1), depth(root.right, c + 1));
    }


}
