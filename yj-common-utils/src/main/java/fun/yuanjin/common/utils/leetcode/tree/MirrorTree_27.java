package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;

/**
 * @ClassName MirrorTree_27
 * @Description 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @Author yuanjin
 * @Date 2021-04-01 10:17
 * @Version 1.0
 */
public class MirrorTree_27 {
    public TreeNode mirrorTree(TreeNode root) {
        return mirror(root);
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = mirror(root.left);
        TreeNode right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
