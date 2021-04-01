package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;

/**
 * @ClassName KthLargest_54
 * @Description 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @Author yuanjin
 * @Date 2021-04-01 14:21
 * @Version 1.0 7 4 6 1 2 5
 */
public class KthLargest_54 {
    public static void main(String[] args) {
        KthLargest_54 obj = new KthLargest_54();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(obj.findTilt(root));
    }

    int k;
    TreeNode res = null;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        cur(root);
        return res == null ? 0 : res.val;
    }

    public void cur(TreeNode root) {
        if (root == null || k <= 0) {
            return;
        }
        cur(root.right);
        if (k == 1) {
            res = root;
        }
        k--;
        cur(root.left);
    }

    public int findTilt(TreeNode root) {
        find(root);
        return root.val;
    }

    public int find(TreeNode root) {
        if(root == null) return 0;
        int left = find(root.left);
        int right = find(root.right);
        int res = left + right + root.val;
        root.val = Math.abs(left - right);
        return res;
    }
}
