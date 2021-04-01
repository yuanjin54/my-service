package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-12-26 22:35
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
