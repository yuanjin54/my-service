package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;

/**
 * @ClassName LowestCommonAncestor_68
 * @Description 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @Author yuanjin
 * @Date 2021-04-01 10:37
 * @Version 1.0
 */
public class LowestCommonAncestor_68 {
    public static void main(String[] args) {
        LowestCommonAncestor_68 obj = new LowestCommonAncestor_68();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode node = obj.lowestCommonAncestor(root, root.right, root.left.left);
        System.out.println(node.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果p或q与root相等直接返回
        if (root == null || p == root || q == root) {
            return root;
        }
        // 如果p、q分别在root的两边，返回root，否则就只在某一边
        // 找出左边，左边返回null的话，说明在右边
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 找出右边，右边返回null的话，说明在左边
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }

}
