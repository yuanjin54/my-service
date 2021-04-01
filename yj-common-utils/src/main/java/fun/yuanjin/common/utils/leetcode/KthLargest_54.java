package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName KthLargest_54
 * @Description 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @Author yuanjin
 * @Date 2021-01-12 22:41
 * @Version 1.0
 */
public class KthLargest_54 {
    static int kk;
    static int result;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthLargest(root, 5));
    }

    public static int kthLargest(TreeNode root, int k) {
        kk = k;
        bl(root);
        return result;
    }

    private static void bl(TreeNode root) {
        if (null == root) return;
        bl(root.right);
        kk--;
        if (kk == 0) result = root.val;
        bl(root.left);
    }
}
