package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName IsSymmetric_28
 * @Description 剑指 Offer 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @Author yuanjin
 * @Date 2021-01-13 11:57
 * @Version 1.0
 */
public class IsSymmetric_28 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric1(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null) return false;
        if (root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (null == left && right == null) continue;
            if (null == left) return false;
            if (null == right) return false;
            if (left.val != right.val) return false;
            if (left.left == null && right.right != null) {
                return false;
            }
            if (left.left != null && right.right == null) {
                return false;
            }
            if (left.left != null) {
                deque.addFirst(left.left);
                deque.addLast(right.right);
            }

            if (left.right == null && right.left != null) {
                return false;
            }
            if (left.right != null && right.left == null) {
                return false;
            }
            if (left.right != null) {
                deque.addFirst(left.right);
                deque.addLast(right.left);
            }
        }
        return true;
    }

    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    private static boolean recur(TreeNode left, TreeNode right){
        if (left == null && right == null)return true;
        if (left ==null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

}
