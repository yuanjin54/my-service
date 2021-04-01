package fun.yuanjin.common.utils.leetcode;

import java.util.Stack;

/**
 * @ClassName Title
 * @Description 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @Author yuanjin
 * @Date 2020-12-26 22:34
 * @Version 1.0
 */
public class IsValidBST_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(7);
        TreeNode l2 = new TreeNode(6);
        TreeNode r2 = new TreeNode(2147483647);
        root.right = r2;
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        Stack<ColorTreeNode> stack = new Stack<>();
        stack.push(new ColorTreeNode(0, root));
        int max = Integer.MIN_VALUE;
        int n = 1;
        while (stack.size() > 0) {
            ColorTreeNode treeNode = stack.pop();
            TreeNode node = treeNode.node;
            if (treeNode.color == 1) {
                System.out.println(node.val);
                if (n == 1){
                    n++;
                }else {
                    if (node.val <= max) {
                        return false;
                    }
                }
                max = node.val;
                continue;
            }
            if (node.right != null) {
                stack.push(new ColorTreeNode(0, node.right));
            }
            stack.push(new ColorTreeNode(1, node));
            if (node.left != null) {
                stack.push(new ColorTreeNode(0, node.left));
            }
        }
        return true;
    }

    static class ColorTreeNode {
        int color;
        TreeNode node;

        public ColorTreeNode(int color, TreeNode node) {
            this.color = color;
            this.node = node;
        }
    }
}
