package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName IsBalanced_55
 * @Description 剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @Author yuanjin
 * @Date 2021-01-12 22:04
 * @Version 1.0
 */
public class IsBalanced_55 {

    public static boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        // 如果左边或者右边不是平衡树就直接返回false
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        return Math.abs(getTreeMaxDepth(root.right) - getTreeMaxDepth(root.left)) < 2;
    }

    /**
     * 获取树的最大深度
     *
     * @param node
     * @return
     */
    private static int getTreeMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getTreeMaxDepth(node.left), getTreeMaxDepth(node.right)) + 1;
    }


}
