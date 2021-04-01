package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName MirrorTree_27
 * @Description 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @Author yuanjin
 * @Date 2021-01-13 19:01
 * @Version 1.0
 */
public class MirrorTree_27 {
    public static TreeNode mirrorTree(TreeNode root) {
        return recur(root);
    }

    private static TreeNode recur(TreeNode root) {
        if (root == null) return null;
        TreeNode left = recur(root.left);
        TreeNode right = recur(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
